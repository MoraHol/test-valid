$('#formCreate').submit((event)=>{
    event.preventDefault();
    let user = {
        name: $('#name').val(),
        lastname: $('#lastname').val()
    };
    $.ajax({
        url: '/api/users',
        type: 'post',
        dataType: 'json',
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(user)
    }).done((data,status,xhr)=>{
        $.alert({
            title: 'Alerta!',
            content: 'Guardado Correctamente!',
            type: 'success'
        });
        $("#formCreate")[0].reset();
    });
});

