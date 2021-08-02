

		const validateName = (nameIsle = undefined) => {
			if(nameIsle === undefined) return false;

			if(nameIsle.length >= 25) return false;

			return (/^[a-zA-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/g.test(nameIsle))
			 ? true 
			 : false ; 
		}
		
		const validateNumber = (number = undefined) => {
			if(number === undefined) false;

			return (/^([0-9])*$/.test(number)) 
			? true 
			: false; 
		}
		 
		

		const validatePhone = (phone = undefined) => {	
			if(phone === undefined) false;

			return (/^[9|6]{1}([\d]{2}[-]*){3}[\d]{2}$/g.test(phone)) 
			? true 
			: false; 
		}
	

		const validateEmail = (email = undefined) => {
			if(email === undefined) false;
			
			return (/[\w]+@{1}[\w]+\.[a-z]{2,3}/g.test(email)) 
		 	 ? true 
		 	 : false;
		}
		

		const validarCadenaTexto = (texto = undefined)  => {

			if(texto === undefined) return false;

			return (/^\s+$/.test(texto))
			? true
			: false;

		} 
		const validateDescripcion = (descripcion = undefined) => {
			if(descripcion === undefined) return false;
		
			if(descripcion.length <= 14) return false;

			if(descripcion.length >= 15) return true;
			
		}
		const validatePassword = (password = undefined) =>{
			if(password === undefined) return false;

			return (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,15}$/.test(password))
			 ? true
			 : false;

		}
		const validatePortada = (portada = "") => 
		 (portada !== "") 
		  ? true
		  : false; 

		const validateCategoria = (categoria = "0") => 
			(categoria !== "0") 
			 ? true
			 : false;

		