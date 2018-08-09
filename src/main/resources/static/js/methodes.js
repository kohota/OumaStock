
$(document).ready(function() {
   // Clients Listes 
    $("#table-style").on(
			"click",
			" a.linkCommandesDuClient",
			function() {
				var idClient=$(this).parent().closest("tr").find("input:hidden").val();
				//alert(code);
				$("#tableCommandeDuClient tbody tr").remove();
				$.ajax({
					 url:'client/commandeList',
	                 type:'post',
	                 data:{idClient:idClient},
	                 dataType: 'json',
	                 success: function(data) {
	                	 
	                 
	                	 for (i = 0; i < data.length; i++) {
	                 		
	                 		var rowN = "<tr class='rows'> <td> "
	         					+ data[i]['idCommande']
	         					+ "</td><td> "
	         					+ data[i]['dateCommande']
	         					+ "</td></tr>";
	                 		$("#tableCommandeDuClient tbody")
	         				.append(rowN);
	                	 }
	                 },
	                 error : function(data){
	                	 alert("erreur");
	                 }
	                    
				});
				
			});
   
  // Categorie List 
    
    
    $("#table-style").on(
			"click",
			" a.linkArticleCategorie",
			function() {
				var idCath=$(this).parent().closest("tr").find("input:hidden").val();
				//alert(code);
				$("#tableArticleCategorie tbody tr").remove();
				$.ajax({
					 url:'categorie/articleList',
	                 type:'post',
	                 data:{idCath:idCath},
	                 dataType: 'json',
	                 success: function(data) {
	                	 
	                 
	                	 for (i = 0; i < data.length; i++) {
	                 		
	                 		var rowN = "<tr class='rows'> <td> "
	         					+ data[i]['idArticle']
	         					+ "</td><td> "
	         					+ data[i]['nom']
	                 			+ "</td><td> "
		                 		+ data[i]['prixAchat']
		                 		+ "</td><td> "
		                 		+ data[i]['prixVente']
		                 		+ "</td><td> "
		                 		+ data[i]['qteStock']
	         					+ "</td></tr>";
	                 		$("#tableArticleCategorie tbody")
	         				.append(rowN);
	                	 }
	                 },
	                 error : function(data){
	                	 alert("erreur");
	                 }
	                    
				});
				
			});
   
  });

