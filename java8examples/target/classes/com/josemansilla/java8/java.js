/**
 * Pruebas nashron
 */

print('Hola desde el archivo JS del proyecto.');

function calcular(numero1, numero2){
	return numero1 + numero2;
}

var hiloImpl = {
		run: function(){
			for(var i = 0; i < 20; i++){
				print("Imprimiendo: " + i);
			}
		}
}