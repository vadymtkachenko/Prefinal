/**
 * Created by Admin on 24.01.2018.
 */
$(document).ready(function() {
    $('#userName').blur(function(event) {
        var name = $('#userName').val();
        $.get('GetUserServlet', {
            userName : name
        }, function(responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });
});
