package webscraping

import customizado.TratativaJson

class TransformarDados {

  def transformacaoDados(conteudo:String): List[(String, String, Float, String)] = {

    //Chama objeto que vai tratar os dados
    /* Para reutilizar o codigo basta escrever no package cutomizado
    toda sua transformação e chama-la por aqui cada vez que for utilizar uma
    transformação diferente, mas preste atenção no tipo de retorno
    talvez voce precise altera-lo de acordo com a sua classe customizada
     */

    val tratativa = new TratativaJson()
    tratativa.extracaoJson(conteudo)
  }



}
