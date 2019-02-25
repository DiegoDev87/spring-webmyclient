function validaFormulario() {
	
	let nome = $("#nome");
	let sobrenome = $("#sobrenome");
	let email = $("#email");
	let senha = $("#senha");
	let senhaConfirma = $("#senhaConfirma");
	
	if (!nome.val().trim()) {
		alert("Informe o Nome");
		return false;
	}
	if (!sobrenome.val().trim()) {
		alert("Informe o Sobrenome");
		return false;
	}
	if (!email.val().trim()) {
		alert("Informe o email");
		return false;
	}
	if (!senha.val().trim()) {
		alert("Informe a senha");
		return false;
	}
	if (!senhaConfirma.val().trim()) {
		alert("Confirme a senha.");
		return false;
	}
	
	if(senha.val().trim() !== senhaConfirma.val().trim()){
		alert("Senhas diferentes.");
		return false;
	}else{
		if(senha.val().trim().length < 8 || senha.val().trim().length > 10){
			alert("A senha deve conter entre 8 e 10 caracteres.");
			return false;
		}
	}
	return true;
}

function salvar() {
	let form = $("#formCadUsuario");
	if (validaFormulario()) {
		$.ajax({
			url : '/usuario/cadastro/salvar',
			type : 'POST',
			data : form.serialize(),
			beforeSend : function() {
				console.log('enviando...')
			},
			success : function(data) {
				if(data){
					alert('Conta criada com sucesso!');
					window.location = '/home';
				}
			},
			error : function(xhr, status) {
				
			}
		});
	}
}
