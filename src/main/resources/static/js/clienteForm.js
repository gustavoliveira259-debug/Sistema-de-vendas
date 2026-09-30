document.querySelector("form").addEventListener("submit", function () {

    const campos = [
        document.getElementById("logradouro").value,
        document.getElementById("numero").value,
        document.getElementById("complemento").value,
        document.getElementById("bairro").value,
        document.getElementById("cidade").value,
        document.getElementById("uf").value,
        document.getElementById("cep").value
    ];

    const endereco = campos
        .filter(valor => valor.trim() !== "")
        .join(", ");

    document.getElementById("endereco").value = endereco;
});
