/**
 * 
 */
$(document).ready(function()
{
		if ($("#alertSuccess").text().trim() == "")
 		{
 			$("#alertSuccess").hide();
 		}
		$("#alertError").hide();
}); 

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
 	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();

	// Form validation----------------
	var status = validateFundForm();
	if (status != true)
 	{
 		$("#alertError").text(status);
 		$("#alertError").show();
 		return;
 	}
	
 	// If valid------------------------
	var type = ($("#hidFIDSave").val() == "") ? "POST" : "PUT";
	$.ajax(
		{
			url: "FundAPI",
			type: type,
			data: $("#formFund").serialize(),
			dataType: "text",
			complete: function(response, status) {
				onFundSaveComplete(response.responseText, status);
			}
		});
	
});

function onFundSaveComplete(response, status) 
{

		if (status == "success") 
		{
			var resultSet = JSON.parse(response);
			
			if (resultSet.status.trim() == "success") 
			{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divFundGrid").html(resultSet.data);
			}
			else if (resultSet.status.trim() == "error") 
			{
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}
		} 
		else if (status == "error") 
		{
			$("#alertError").text("Error while saving.");
			$("#alertError").show();
		} 
		else 
		{
			$("#alertError").text("Unknown error while saving..");
			$("#alertError").show();
		}

	$("#hidFIDSave").val("");
	$("#formFund")[0].reset();

}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{

 	$("#hidFIDSave").val($(this).closest("tr").find('#hidFIDUpdate').val());
 	$("#FunderCode").val($(this).closest("tr").find('td:eq(0)').text());
 	$("#CompanyName").val($(this).closest("tr").find('td:eq(1)').text());
 	$("#ContactNo").val($(this).closest("tr").find('td:eq(2)').text());
 	$("#CompanyDesc").val($(this).closest("tr").find('td:eq(3)').text());
});

// CLIENT-MODEL=================================================================

function validateFundForm()
{
	// CODE
	if ($("#FunderCode").val().trim() == "")
 	{
 		return "Insert Funder Code";
 	} 
	//COMPANY NAME
	if ($("#CompanyName").val().trim() == "")
 	{
 		return "Insert Company Name";
 	}

	// CONTACT NUMBER
	if ($("#ContactNo").val().trim().length>10)
 	{
 		return "Max.length of Contact Number is 10 ";
 	}
 	
 	// COMPANY DESCRIPTION
	if ($("#CompanyDesc").val().trim() == "")
 	{
 		return "Insert Company Description";
 	}
	
	return true;
} 

///REMOVE============================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax(
		{
			url: "FundAPI",
			type: "DELETE",
			data: "FID=" + $(this).data("FID"),
			dataType: "text",
			complete: function(response, status) {
				onFundDeleteComplete(response.responseText, status);
			}


		});

});

function onFundDeleteComplete(response, status) {

	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") 
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divFundGrid").html(resultSet.data);
		}
		else if (resultSet.status.trim() == "error") 
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	}

	else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	}

	else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();

	}

}

		








