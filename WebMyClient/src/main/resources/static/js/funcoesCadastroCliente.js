function mudaMascaraParaCpfOuCnpj() {
	let valorTipoPessoa = $("#tipoPessoa").val();
	let cpfOuCnpj = $("#cpfOuCnpj");
	if (valorTipoPessoa == 1) {
		cpfOuCnpj.val("");
		cpfOuCnpj.attr("placeholder", "000.000.000-00");
		cpfOuCnpj.unmask().mask("000.000.000-00");
	} else if (valorTipoPessoa == 2) {
		cpfOuCnpj.val("");
		cpfOuCnpj.attr("placeholder", "00.000.000/0000-00");
		cpfOuCnpj.unmask().mask("00.000.000/0000-00");
	}
}

function validaFormulario(){
	let nomeOuRazaoSocial = $("#nome");
	if(!nomeOuRazaoSocial.val().trim()){
		alert("Informe o Nome/Razão Social");
		return false;
	}
	return true;
}

function salvar(){
	let form = $("#formCadCliente");
	if(validaFormulario()){
		$.ajax({
			url : '/cliente/cadastro/salvar',
			type : 'POST',
			data : form.serialize(),
			beforeSend: function(){
				console.log('enviando...')
			},
			success: function(data){
				console.log(data);
			},
			error: function(xhr, status, errorThrwn){
				conlose.log(xhr.status);
				conlose.log(status);
				conlose.log(xhr.responseText);
			}
		});
	}
}
