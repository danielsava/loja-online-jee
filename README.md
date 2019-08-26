# loja-online-jee

- Comandos do JBoss Forge utilizados no projeto. O processo de instação se resume em descompactar o arquivo ".zip",
e adicionar o /bin no path do Windows. 

# forge
$ project-new --named loja-online-jee

# Exemplos Path CSS
.formularioDoCarrinho-atualizar {
	background-image: url(../imagens/refresh.png);
	background-repeat: no-repeat;
	background-position: 50%;
	background-color: transparent;
	background-size: 75%;
	width: 24px;
	height: 24px;
	border: none;
	cursor: pointer;
	font-size: 0;
}



# Exemplo Imagem Ícone
<td class="formularioDoCarrinho-item">
    <a jsf:action="#{carrinhoComprasBean.remover(carrinhoItem)}">
        <img class="formularioDoCarrinho-item-remover-imagem"  src="#{request.contextPath}/resources/imagens/trash.png" alt="X" title="Remover" />
    </a>
</td>