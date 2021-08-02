<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar custom-toggler navbar-dark bg-dark">
		<div class="d-flex">
		<button class="navbar-toggler" data-target="#menuBoton"
			data-toggle="collapse" type="button">
			<span> 
				<span class="navbar-toggler-icon"></span>
				<h5 class="text-white">Mustango Islas</h5>
			</span>
		</button>

		<form action="listarAnunciosIsla" method="POST">
			<input type="text" name="tituloAnuncio" value="${tituloAnuncio}"/>
			<input type="submit" value="Buscar"/>
		</form> 
		
		</div>
		<div class="collapse navbar-collapse" id="menuBoton">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item " ><a href="listarAnunciosIsla"
					class="nav-link">Inicio</a>
				</li>
				<li class="nav-item "><a href="misAnuncios"
					class="nav-link">Mis Anuncios</a>
				</li>
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown"
					data-target="desplegable" href="#">Usuario</a>
					<div class="dropdown-menu">
						<c:if test="${sessionScope.idUsuario == null }">
						<a class="dropdown-item" href="prepararIdentificacionUsuario">Identificarme</a> 
						<a  class="dropdown-item" href="prepararRegistroUsuario">Registrarme</a>
					    </c:if>	
						<c:if test="${sessionScope.idUsuario != null }">
						<a  class="dropdown-item" href="cerrarSesionUsuario">Cerrar sesion</a>	
						</c:if>
					</div>
				</li>
			</ul>
		</div>
	</nav>
