$(document).ready(function() {

	$('#login_form').submit(function(e) {
		document.cookie = "username=" + $('#username').val();
	});
});