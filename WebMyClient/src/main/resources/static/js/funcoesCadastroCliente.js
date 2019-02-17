function mudaMascaraParaCpfOuCnpj() {
	let valorTipoPessoa = $("#tipoPessoa").val();
	let cpfOuCnpj = $("#cpfOuCnpj");
	if(!cpfOuCnpj){
		if (valorTipoPessoa == 'F') {
			cpfOuCnpj.val("");
			cpfOuCnpj.attr("placeholder", "000.000.000-00");
			cpfOuCnpj.unmask().mask("000.000.000-00");
		} else if (valorTipoPessoa == 'J') {
			cpfOuCnpj.val("");
			cpfOuCnpj.attr("placeholder", "00.000.000/0000-00");
			cpfOuCnpj.unmask().mask("00.000.000/0000-00");
		}
	}
}

function travaCampos() {
	let valorTipoPessoa = $("#tipoPessoa").val();
	if (valorTipoPessoa == 'F') {
		$('#dataNascimento').prop('readonly', false);
		$('#rg').prop('readonly', false);
		$('#sexo').prop('disabled', false);
		$('#inscricaoEstadual').prop('readonly', true);
		$('#nomeFantasia').prop('readonly', true);
	} else if (valorTipoPessoa == 'J') {
		$('#nomeFantasia').prop('readonly', false);
		$('#inscricaoEstadual').prop('readonly', false);
		$('#dataNascimento').prop('readonly', true);
		$('#rg').prop('readonly', true);
		$('#sexo').prop('disabled', true);
	}
}

function validaFormulario() {
	let nomeOuRazaoSocial = $("#nome");
	if (!nomeOuRazaoSocial.val().trim()) {
		alert("Informe o Nome/Razão Social");
		return false;
	}
	return true;
}

function salvar() {
	let form = $("#formCadCliente");
	if (validaFormulario()) {
		$.ajax({
			url : '/cliente/cadastro/salvar',
			type : 'POST',
			data : form.serialize(),
			beforeSend : function() {
				console.log('enviando...');
			},
			success : function(data) {
				if(data){
					window.location = '/cliente/consultar';
				}
			},
			error : function(xhr, status) {
				console.log(xhr.status);
			}
		});
	}
}
