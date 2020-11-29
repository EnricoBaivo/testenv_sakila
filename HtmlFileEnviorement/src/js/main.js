



$(document).ready(function() {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
    });

    console.log("%c  Dev by Enrico Bono — https://baivo.studio", "background-color: #222222; color: #f9d63d; font-size:10px; padding:8px 10px 6px; border-radius:4px;")
    console.log('hello, World !, lets do this!')
});