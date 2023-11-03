@file:Suppress("ktlint")
package gg.jte.generated.ondemand
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JteindexGenerated {
companion object {
	@JvmField val JTE_NAME = "index.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(0,0,0,0,0,0,0,0,0,0,33,33,33)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?) {
		gg.jte.generated.ondemand.layouts.JtebaseGenerated.render(jteOutput, jteHtmlInterceptor, object : gg.jte.html.HtmlContent {
			override fun writeTo(jteOutput:gg.jte.html.HtmlTemplateOutput) {
				jteOutput.writeContent("\n<header class=\"container\">\n    <hgroup>\n        <h1>📖 Bookist</h1>\n        <h2>Manage your reading list</h2>\n    </hgroup>\n</header>\n<main class=\"container\">\n    <section>\n        <form method=\"post\" action=\"/login\">\n            <div class=\"grid\">\n                <input\n                        type=\"text\"\n                        name=\"username\"\n                        placeholder=\"Username\"\n                        aria-label=\"Username\"\n                        required\n                />\n                <input\n                        type=\"password\"\n                        name=\"password\"\n                        placeholder=\"Password\"\n                        aria-label=\"Password\"\n                        required\n                />\n                <button type=\"submit\">Login</button>\n            </div>\n            <fieldset>\n                <p>Noch keinen Account? <a href=\"/register\">Hier registrieren.</a></p>\n            </fieldset>\n        </form>\n    </section>\n</main>\n")
			}
		}, "Login");
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
}
