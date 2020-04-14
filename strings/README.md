### Requisitos
- Java JDK8+
- Maven 3

### Como instalar ?
Na pasta raiz do projeto `/strings` execute o seguinte comando:
> mvn clean install

### Como executar ?

 **Sem parâmetros**
   
  Será formatada e justificada uma string default 
   
`java -jar formatter`
   
**Um parâmetros**

Onde `nome_arquivo` é o direitório do arquivo com o texto a ser formatado.

`java -jar formatter nome_arquivo`
  
**Dois parâmetros**

`java -jar formatter nome_arquivo limit`

**Três parâmetros**

Onde `justify` é um booleano que determina se deve ou não justificar.

`java -jar formatter nome_arquivo limit justify`


