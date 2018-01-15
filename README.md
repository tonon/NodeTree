<h1>Node Rest</h1>

O Objetivo do projeto é a realização de um webservice de cadastro de nodes utiliando rest.

Foram utilizados como tecnologia, o java, a api Jersey da apache, o apache Maven como controlador de dependencias e o apache tomcat como servidor de aplicações.

Já a persistencia dos dados foram feitas com hibernate e derby embarcado

Para os testes :

<b>Retornar o Id:</b>
localhost:8080/treeRest/rest/node/get/{id}

<b>Listar:</b>
localhost:8080/treeRest/rest/node/getAll

<b>Post:</b>
localhost:8080/treeRest/rest/node/post

<b>Put:</b>
localhost:8080/treeRest/rest/node/put


<b>Delete:</b>
localhost:8080/treeRest/rest/node/delete/{id}
