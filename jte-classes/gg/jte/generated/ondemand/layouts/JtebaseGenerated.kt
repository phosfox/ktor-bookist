@file:Suppress("ktlint")
package gg.jte.generated.ondemand.layouts
import gg.jte.Content
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JtebaseGenerated {
companion object {
	@JvmField val JTE_NAME = "layouts/base.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(0,0,0,1,1,1,1,1,9,9,9,9,13,13,13,15)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, content:Content, title:String) {
		jteOutput.writeContent("<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\">\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css\">\n        <title>")
		jteOutput.setContext("title", null)
		jteOutput.writeUserContent(title)
		jteOutput.writeContent(" | Bookist</title>\n    </head>\n\n    <body>\n        ")
		jteOutput.setContext("body", null)
		jteOutput.writeUserContent(content)
		jteOutput.writeContent("\n    </body>\n</html>")
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		val content = params["content"] as Content
		val title = params["title"] as String
		render(jteOutput, jteHtmlInterceptor, content, title);
	}
}
}
