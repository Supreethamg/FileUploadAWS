$(document).ready(function() {
	var username = getCookie('username');
	$(".username").val(username);
	
	$("#btnUpload").click(function(){
		uploadFile();
	});
	
	
});

function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
};

function uploadFile() {
	// Get form
	var form = $('#uploadForm')[0];

    var data = new FormData(form);
    
    $("#btnUpload").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/AwsFileUploadProject/upload/",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	alert("File Uploaded.");
            console.log("SUCCESS : ", data);
            $("#btnUpload").prop("disabled", false);
        },
        error: function (e) {
        	alert("Error uploading file.");
            console.log("ERROR : ", e);
            $("#btnUpload").prop("disabled", false);
        }
    });
};

function deleteFile(filename){
	
	$("#btnDelete").prop("disabled", true);
	
	$.ajax({
        type: "DELETE",
        url: "/AwsFileUploadProject/delete?filename=" + filename,
        success: function (data) {
        	alert("File Deleted.");
            $("#btnDelete").prop("disabled", false);
            $('#refreshList').submit();

        },
        error: function (e) {
        	alert("Error deleting file.");
            console.log("ERROR : ", e);
            $("#btnDelete").prop("disabled", false);
        }
    });
	
}