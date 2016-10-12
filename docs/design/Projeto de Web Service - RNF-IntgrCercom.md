a o Projeto de Web Service RNF-IntgrCercom
======
#### (Há integração com sistemas do CERCOMP para importação de dados de egressos)
**Prioridade**: Alta.

**Partes Interessadas**: PROGRAD, PRPG.

**Descrição**: O software interage com sistemas do CERCOMP a fim de obter dados dos egressos dos cursos de graduação e pós-graduação da UFG, conforme RF-ImportEgresPeriod. As informações enviadas pelo CERCOMP sobre os egressos, a forma como essas informações são enviadas e as credenciais exigidas para a importação de dados de egressos estão definidas na seção Proposta de Integração.

Proposta de Integração
------
Para viabilizar esta integração segundo os requerimentos do requisito, um Web Service implementado sobre o framework Axis da Apache rodando em um contexto do Glassfish para oferecer uma interface SOAP/WSDL.

#### Interface do Web Service

- Exemplo de Definição XSD

Duas estruturas de dados se fazem necessárias para a integração, uma para a requisição e outra para a resposta. A requisição tem 6 dados simples, 2 do tipo data (todos obrigatórios) e 4 do tipo string (todos opcionais) conforme definição do requisito ImportEgressPeriod. A resposta por sua vez tem 3 dados compostos, cada dado composto representando uma tabela do domínio da entidade "egresso" do software SempreUFG.
O webservice deve retornar uma resposta exatamente com essas informações para que a inclusão de egresso possa ocorrer de forma consistente.

```xml
<?xml version="1.0"?>

	<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

		<xs:element name="RecuperarEgressoRequest" type="tns:RecuperarEgressoRequestType" />
		<xs:element name="RecuperarEgressoResponse" type="tns:RecuperarEgressoResponseType" />

		<xs:element name="TabelaEgresso" type="tns:TabelaEgressoType" />
		<xs:element name="TabelaResidencia" type="tns:TabelaResidenciaType" />
		<xs:element name="TabelaLocalizacaoGeografica" type="tns:TabelaLocalizacaoGeograficaType" />

		<xs:complexType name"RecuperarEgressoRequestType">
			<xs:sequence>
				<xs:element name="dataInicial" type="xs:date" minOccurs="1" maxOccurs="1" />
				<xs:element name="dataFinal" type="xs:date" minOccurs="1" maxOccurs="1" />
				<xs:element name="egressos_id_list" type="xs:string" minOccurs="0" maxOccurs="1" />
				<xs:element name="cursos_id_list" type="xs:string" minOccurs="0" maxOccurs="1" />
				<xs:element name="unidades_id_list" type="xs:string" minOccurs="0" maxOccurs="1" />
				<xs:element name="regionais_id_list" type="xs:string" minOccurs="0" maxOccurs="1" />
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name"RecuperarEgressoResponseType">
			<xs:sequence>
				<xs:element name="tabela_egresso" type="xs:TabelaEgressoType" />
				<xs:element name="tabela_residencia" type="xs:TabelaResidenciaType" />
				<xs:element name="tabela_localizacao_geografica" type="xs:TabelaLocalizacaoGeograficaType" />
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name"TabelaEgressoType">
			<xs:sequence>
				<xs:element name="nome" type="xs:string" />
				<xs:element name="nome_mae" type="xs:string" />
				<xs:element name="data_nascimento" type="xs:date" />
				<xs:element name="foto_principal" type="xs:base64Binary" />
				<xs:element name="foto_adicionais" type="xs:base64Binary" />
				<xs:element name="visibilidade" type="xs:string" />
				<xs:element name="sexo" type="xs:string" />
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name"TabelaResidenciaType">
			<xs:sequence>
				<xs:element name="data_inicio" type="xs:date" />
				<xs:element name="data_fim" type="xs:date" />
				<xs:element name="endereco" type="xs:string" />
			</xs:sequence>
		</xs:complexType>

		<xs:complexType name"TabelaLocalizacaoGeograficaType">
			<xs:sequence>
				<xs:element name="nome_cidade" type="xs:string" />
				<xs:element name="nome_unidade_federativa" type="xs:string" />
				<xs:element name="nome_pais" type="xs:string" />
				<xs:element name="sigla" type="xs:string" />
				<xs:element name="latitude" type="xs:double" />
				<xs:element name="longitude" type="xs:double" />
			</xs:sequence>
		</xs:complexType>

	</xs:schema>
```

- Exemplo de Definição WSDL

Agora para o webservice em si, a chamada ao serviço se dará por uma chamada remota ao método (RPC) de modo que o parâmetro pra esse método é do tipo RecuperarEgressoRequestType e a resposta é do tipo RecuperarEgressoResponseType.

```xml
<?xml version="1.0" encoding="UTF-8"?>
  <wsdl:definitions targetNamespace="http://localhost:8080/axis/RecuperaDadosEgresso.jws"
       xmlns="http://schemas.xmlsoap.org/wsdl/"
       xmlns:apachesoap="http://xml.apache.org/xml-soap"
       xmlns:impl="http://localhost:8080/axis/RecuperaDadosEgresso.jws"
       xmlns:intf="http://localhost:8080/axis/RecuperaDadosEgresso.jws"
       xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
       xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
       xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/"
       xmlns:xsd="http://www.w3.org/2001/XMLSchema">  
    <wsdl:message name="RecuperaDadosEgressoRequest">  
     <wsdl:part name="entrada" type="xsd:RecuperarEgressoRequestType"/>
   </wsdl:message>  
   <wsdl:message name="RecuperaDadosEgressoResponse">  
     <wsdl:part name="saida" type="xsd:RecuperarEgressoResponseType"/>  
   </wsdl:message>  
   <wsdl:portType name="RecuperaDadosEgresso">  
     <wsdl:operation name="RecuperaDadosEgresso">  
       <wsdl:input message="impl:RecuperaDadosEgressoRequest" name="RecuperaDadosEgressoRequest"/>  
       <wsdl:output message="impl:RecuperaDadosEgressoResponse" name="RecuperaDadosEgressoResponse"/>  
     </wsdl:operation>  
   </wsdl:portType>  
   <wsdl:binding name="RecuperaDadosEgressoSoapBinding" type="impl:RecuperaDadosEgresso">  
     <wsdlsoap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>  
     <wsdl:operation name="RecuperaDadosEgresso">  
       <wsdlsoap:operation soapAction=""/>  
       <wsdl:input name="RecuperaDadosEgressoRequest">  
         <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"
             namespace="http://DefaultNamespace" use="encoded"/>  
       </wsdl:input>  
       <wsdl:output name="RecuperaDadosEgressoResponse">  
         <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"
             namespace="http://localhost:8080/axis/RecuperaDadosEgresso.jws" use="encoded"/>  
       </wsdl:output>  
     </wsdl:operation>  
   </wsdl:binding>  
   <wsdl:service name="RecuperaDadosEgressoService">  
     <wsdl:port binding="impl:RecuperaDadosEgressoService" name="RecuperaDadosEgresso">  
       <wsdlsoap:address location="http://localhost:8080/axis/RecuperaDadosEgresso.jws"/>  
     </wsdl:port>  
   </wsdl:service>  
 </wsdl:definitions>
```
OBS: Mudar ocorrências de http://localhost:8080 pelo IP/DNS e porta do ambiente que for implantado o serviço.
