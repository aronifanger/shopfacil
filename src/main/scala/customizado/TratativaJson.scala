package customizado

import java.util.Date

import play.api.libs.json._




class TratativaJson {

  def extracaoJson(conteudo:String): List[(String, String, Float, String)] = {

    val json: JsValue = Json.parse(conteudo) //Converte o conteudo para formato Json

    //Localização dos dados no Json
    //Documentação da api: https://www.playframework.com/
    val item = (json \\ "itemId").map(_.as[String])
    val loja = (json \\ "sellerId").map(_.as[String])
    val preco = (json \\ "Price").map(_.as[Float])

    val ref = Range(0, loja.length)

    val data = new Date()
    val dataAtual = data.toInstant.toString

    val resultdadoItem = ref.map(l => (item(0), loja(l), preco(l), dataAtual )) //Transforma o resultado em lista



    resultdadoItem.toList

  }

}
