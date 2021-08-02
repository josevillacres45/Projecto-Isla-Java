package constantesSQL;

public class ConstantesIslas {
	public static final String OBTENER_ISLAS_POR_IDUsuario = "SELECT nombre,precio,pais,telefono,email,numeroFotos,id FROM tabla_islas WHERE usuario_id=:idUsuario order by id desc";
	public static final String OBTENER_ISLA_PARA_EDITAR = "SELECT*FROM tabla_islas WHERE id =:idIsla";
	public static final String OBTENER_LISTADO_CATEGORIA = "SELECT nombre,id FROM tabla_categorias";
	public static final String OBTENER_TOTALISLA = "SELECT COUNT(id) FROM tabla_islas WHERE nombre like :nombreIsla ;";
}
