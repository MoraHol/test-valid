$(document).ready(function () {
    let table = $('#userTable').DataTable({
        ajax: {
            url: '/api/users',
            dataSrc: ''
        },
        select: true,
        columns: [
            {
                title: 'nombre',
                data: 'name'
            },
            {
                title: 'apellidos',
                data: 'lastname'
            },
            {
                title: 'procesado',
                data: 'processed'
            }
        ]
    });
    $('#procesar').click((event) => {
        let rows = table.rows('.selected').data();
        let count = 0;
        if (rows.length > 0) {
            rows.each(row => {
                row.processed = true;
                $.ajax({
                    url: '/api/users',
                    data: JSON.stringify(row),
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    type: 'put'
                }).done((data, status, xhr) => {
                    count++;
                    if (count == rows.length) {
                        table.ajax.reload();
                        $.alert({
                            title: 'Alerta!',
                            content: 'procesado!',
                            type: 'success'
                        });
                    }
                });
            })
        } else {
            $.alert({
                title: 'Alerta!',
                content: 'No se ha seleccionado nada!',
                type: 'warning'
            });
        }

    });

    $('#borrar').click((event) => {
        let rows = table.rows('.selected').data();
        let count = 0;
        if (rows.length > 0) {
            $.confirm({
                title: 'Confirmar!',
                content: 'Quiere Borrar!',
                buttons: {
                    confirmar: function () {
                        rows.each(row => {
                            row.processed = true;
                            $.ajax({
                                url: `/api/users/${row.id}`,
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8",
                                type: 'delete'
                            }).done((data, status, xhr) => {
                                count++;
                                if (count == rows.length) {
                                    table.ajax.reload();
                                    $.alert({
                                        title: 'Alerta!',
                                        content: 'borrados!',
                                        type: 'success'
                                    });
                                }
                                table.ajax.reload();
                            });
                        });
                    },
                    cancelar: function () {

                    }
                }
            });


        } else {
            $.alert({
                title: 'Alerta!',
                content: 'No se ha seleccionado nada!',
                type: 'warning'
            });
        }

    });

});