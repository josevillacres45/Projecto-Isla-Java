<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar custom-toggler navbar-dark bg-dark">
		<div class="d-flex">
		<button class="navbar-toggler" data-target="#menuBoton"
			data-toggle="collapse" type="button">
			<span> 
				<span class="navbar-toggler-icon"></span>
				<h5 class="text-white">ADMIN Mustango</h5>
			</span>
		</button>
		
		</div>
		<div class="collapse navbar-collapse" id="menuBoton">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item " ><a href="listarIslas"
					class="nav-link">Gestionar Islas</a>
				</li>
				<li class="nav-item "><a href="listarUsuarios"
					class="nav-link">Gestionar Usuarios</a>
				</li>
				<li class="nav-item "><a href="listarCategorias"
					class="nav-link">Gestionar Categorias</a>
				</li>
				<li class="nav-item "><a href="addCategoria"
					class="nav-link">Registrar Categoria</a>
				</li>
				<li class="nav-item "><a href="islaNueva"
					class="nav-link">Registrar Isla</a>
				</li>
				<li class="nav-item "><a href="usuarioNuevo"
					class="nav-link">Registrar Usuario</a>
				</li>
				<li class="nav-item "><a href="../listarAnunciosIsla"
					class="nav-link">Salir</a>
				</li>
				
			</ul>
		</div>
	</nav>
