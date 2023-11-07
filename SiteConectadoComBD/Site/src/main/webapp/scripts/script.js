function enviar() {
		let email = frmContato.emailContato.value
		let nome = frmContato.nomeContato.value
		let telefone = frmContato.telefoneContato.value
		if(nome === "") {
			alert('preencha o campo nome')
			frmContato.nomeContato.focus()
		} else if(email === "") {
			alert('preencha o campo email')
			frmContato.emailContato.focus()
		} else if(telefone === "") {
			alert('preencha o campo telefone')
			frmContato.telefoneContato.focus()
		} else {
			alert("A RJTRIP agradece o contato! Retornaremos em breve!")
			document.forms["frmContato"].submit()
		}
}

function confirmar(contato_id) {
	let resposta = confirm("Confirma a exclusão desse contato?")
	if (resposta === true) {
		window.location.href = "delete?contato_id=" + contato_id
	}
}

function cpfMask() {
    const cpfInput = document.getElementById('inputCpf')
    let cpfInputLength = cpfInput.value.length
    if (cpfInputLength === 3 || cpfInputLength === 7) {
        cpfInput.value += '.'
    } else if(cpfInputLength === 11) {
        cpfInput.value += '-'
    }
}

