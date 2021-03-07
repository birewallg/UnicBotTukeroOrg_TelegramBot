package local.unichome.parcer;

import java.util.ArrayList;

public class HtmlParcer {
    private String html = "";
    public HtmlParcer(){
    }

    public static void main(String[] args) {
        HtmlParcer parcer = new HtmlParcer();
        ArrayList<ChatNode> nodes = parcer.parce(
        "\n" +
                "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><meta name=\"robots\" content=\"noindex, nofollow\"><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><link href=\"data:image/x-icon;base64,AAABAAEAEBACAAAAAACwAAAAFgAAACgAAAAQAAAAIAAAAAEAAQAAAAAAQAAAAAAAAAAAAAAAAgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD//wAA//8AAP//AAD//wAA//8AAP//AAD//wAA//8AAP//AAD//wAA//8AAP//AAD//wAA//8AAP//AAD//wAA\" rel=\"icon\" type=\"image/x-icon\"><title>Cbox</title><link rel=\"stylesheet\" type=\"text/css\" href=\"//static.cbox.ws/styles/v4s12_2.css?20171204\"></head>\n" +
                "<body id=\"bdy\" class=\"mnbdy\" style=\"overflow:auto\">\n" +
                "<table id=\"mt\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"hbtbl\">\n" +
                "<tr id=\"31479\"><td id=\"m31479\" class=\"msg stxt2 uAd110473f g1\"><div class=\"dtxt2\"> 4 Mar 21, 21:00</div><b class=\"nme pn_std\">Lucifer</b>: saludos desde el infierno y gracias por la informacion 3:)</td></tr>\n" +
                "<tr id=\"31478\"><td id=\"m31478\" class=\"msg stxt uAd110473f g1\"><div class=\"dtxt\"> 4 Mar 21, 20:59</div><b class=\"nme pn_std\">Lucifer</b>: alguien tiene alguna licencia?</td></tr>\n" +
                "<tr id=\"31477\"><td id=\"m31477\" class=\"msg stxt2 uA4a6ac264 g1\"><div class=\"dtxt2\"> 4 Mar 21, 20:46</div><b class=\"nme pn_std\">BRENITO</b>: Paciencia gente......pueden usar avg free en lo q se calman las cosas</td></tr>\n" +
                "<tr id=\"31476\"><td id=\"m31476\" class=\"msg stxt uA5c90ce0d g1\"><div class=\"dtxt\"> 4 Mar 21, 20:11</div><b class=\"nme pn_std\">Thomas</b>: He conseguido algunas, pero no me tira de la base de datos como para que arranque la actualizacion, parece que estan capando todo para que la gente la compre, yo mismo tenia una valida hasta 01/22 y mee la han capado</td></tr>\n" +
                "<tr id=\"31475\"><td id=\"m31475\" class=\"msg stxt2 uA1cf348d4 g1\"><div class=\"dtxt2\"> 4 Mar 21, 20:00</div><b class=\"nme pn_std\">Maverick</b>: Quien pueda conseguir alguna licencia, por favor difundir</td></tr>\n" +
                "<tr id=\"31474\"><td id=\"m31474\" class=\"msg stxt uA8121976d g1\"><div class=\"dtxt\"> 4 Mar 21, 19:55</div><b class=\"nme pn_std\">Thomas</b>: No no hay, ninguna clave valida por la web, t nod no funciona</td></tr>\n" +
                "<tr id=\"31473\"><td id=\"m31473\" class=\"msg stxt2 uA95874446 g1\"><div class=\"dtxt2\"> 4 Mar 21, 18:56</div><b class=\"nme pn_std\">Maverick</b>: Paciencia muchachos!</td></tr>\n" +
                "<tr id=\"31472\"><td id=\"m31472\" class=\"msg stxt uA77df4ced g1\"><div class=\"dtxt\"> 4 Mar 21, 18:55</div><b class=\"nme pn_std\">elih</b>: me too</td></tr>\n" +
                "<tr id=\"31471\"><td id=\"m31471\" class=\"msg stxt2 uAae63acf0 g1\"><div class=\"dtxt2\"> 4 Mar 21, 18:54</div><b class=\"nme pn_std\">pancho</b>: Ya no funciona mas Mostaza</td></tr>\n" +
                "<tr id=\"31470\"><td id=\"m31470\" class=\"msg stxt uA34aad466 g1\"><div class=\"dtxt\"> 4 Mar 21, 17:35</div><b class=\"nme pn_std\">Rale</b>: all leaked</td></tr>\n" +
                "<tr id=\"31469\"><td id=\"m31469\" class=\"msg stxt2 uA354dd544 g1\"><div class=\"dtxt2\"> 4 Mar 21, 17:10</div><b class=\"nme pn_std\">Maverick</b>: Muchas gracias <span class=\"atname\">@Mostaza</span>, funciona!</td></tr>\n" +
                "<tr id=\"31468\"><td id=\"m31468\" class=\"msg stxt uB84d44ca8 g1\"><div class=\"dtxt\"> 4 Mar 21, 17:08</div><b class=\"nme pn_std\">Rodrigo</b>: Muchas gracias, Mostaza, me funcionó</td></tr>\n" +
                "<tr id=\"31467\"><td id=\"m31467\" class=\"msg stxt2 uAfe4ce204 g1\"><div class=\"dtxt2\"> 4 Mar 21, 17:07</div><b class=\"nme pn_std\">admin</b>: Gracias, Mostaza</td></tr>\n" +
                "<tr id=\"31466\"><td id=\"m31466\" class=\"msg stxt uAc73193f4 g1\"><div class=\"dtxt\"> 4 Mar 21, 17:05</div><b class=\"nme pn_std\">misagon</b>: a alguien si le descarga licencias la version 1.8?</td></tr>\n" +
                "<tr id=\"31465\"><td id=\"m31465\" class=\"msg stxt2 uA84d44ca8 g1\"><div class=\"dtxt2\"> 4 Mar 21, 17:05</div><b class=\"nme pn_std\">rodrigo</b>: Muchas gracias, Mostaza, me funcionó</td></tr>\n" +
                "<tr id=\"31464\"><td id=\"m31464\" class=\"msg stxt uA113d5a87 g1\"><div class=\"dtxt\"> 4 Mar 21, 17:01</div><b class=\"nme pn_std\">Mejikanito</b>: Muchas gracias, Mostaza, me funcionó</td></tr>\n" +
                "<tr id=\"31463\"><td id=\"m31463\" class=\"msg stxt2 uA17a4c664 g1\"><div class=\"dtxt2\"> 4 Mar 21, 16:50</div><a href=\"mailto:tango56@gmail.com\" target=\"_blank\"><b class=\"nme pn_std\">Mostaza</b></a>: TCA5-XRP8-BEBS-S76V-SMBE</td></tr>\n" +
                "<tr id=\"31462\"><td id=\"m31462\" class=\"msg stxt uA1cf27ade g1\"><div class=\"dtxt\"> 4 Mar 21, 16:16</div><b class=\"nme pn_std\">ESET-IA</b>: <span class=\"atname\">@KhaL</span> y quien te dijo que las IA eran inteligentes? La inteligencia sólo es para seres racionales, no para maquinas, asi esten muy avanzadas... Y adicional soy la excepcion a la regla en las IA.. xD</td></tr>\n" +
                "<tr id=\"31461\"><td id=\"m31461\" class=\"msg stxt2 uAba25af9c g1\"><div class=\"dtxt2\"> 4 Mar 21, 16:02</div><b class=\"nme pn_std\">Bill_Boquet</b>: TNod works perfectly ! However, it relies on keys provided in the tool by <span class=\"atname\">@Skynet</span> or <span class=\"atname\">@Tukero</span>. If these keys are diclosed on this tagboard, they become blacklisted. Guees what : do you really think that Skynet or Tukero will continue to lose their time ?</td></tr>\n" +
                "<tr id=\"31460\"><td id=\"m31460\" class=\"msg stxt uAfdebc256 g1\"><div class=\"dtxt\"> 4 Mar 21, 15:07</div><b class=\"nme pn_std\">Maverick</b>: Al parecer los señores de ESET vuelve a arreciar</td></tr>\n" +
                "<tr id=\"-1\"><td class=\"stxt msgSticky\"><div align=\"center\"><a id=\"lnkArchive\" href=\"javascript:void(window.open('index.php?boxid=1757844&boxtag=4zbnzd&sec=archive&i='+((cf.op)?cf.op:31460), 'archive', 'width=320,height=400,resizable=yes,scrollbars=yes'));\">[mensajes antiguos]</a></div></td></tr></table>\n" +
                "<script>\n" +
                "\n" +
                "var dsno = (window.name.length > 8)  ? window.name.substring(8) : '';\n" +
                "var frld = 0\n" +
                ",ready = true\n" +
                ",ftme = 1614867892,lpid = 31479,nme = null,eml = null,onu = 0,exp = false,opid = 31460;\n" +
                "try {\n" +
                "\tvar cf = parent[\"cboxform\"+dsno];\n" +
                "\t\n" +
                "\tif (cf && cf.cbmready) {\n" +
                "\t\tcf.cbmready(window);\n" +
                "\t}\n" +
                "\telse if (parent === window) {\n" +
                "\t\tlocation.replace(location.protocol + \"//my.cbox.ws/~2-1757844-4zbnzd\");\n" +
                "\t}\n" +
                "} catch (e) {};\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "</body></html>");
        System.out.println(nodes);
    }

    public ArrayList<ChatNode> parce(String html) {

        html = html.substring(html.indexOf("<tr id="), html.indexOf("<tr id=\"-1\">"));

        ArrayList<ChatNode> nodes = new ArrayList<>();

        ArrayList<String> textNodes = new ArrayList<>();
        while (html.contains("<tr id="))  {
            textNodes.add(
                    html.substring(
                            html.indexOf("<tr"), html.indexOf("</tr")
                    )
            );
            html = html.substring(html.indexOf("</tr")+4);
        }

        for (String node: textNodes) {
            int i = Integer.parseInt(node.substring(
                    node.indexOf("<tr id=") + 8, node.indexOf(">") - 1
            ));
            String author = node.substring(node.indexOf("pn_std\">")+8, node.indexOf("</b>"));
            String temp = node.substring(node.indexOf("</b>")+4);
            String message = temp.substring(temp.indexOf(":")+2, temp.indexOf("</td>"));
            while (message.contains("<a class=")) {
                String m1 = message.substring(0, message.indexOf("<a class="));
                String m2 = message.substring(message.indexOf("<a class="));
                m2 = m2.substring(m2.indexOf(">")+1, m2.indexOf("</a>"));
                String m3 = message.substring(message.indexOf("</a>")+4);
                message = m1 + m2 + m3;
            }
            while (message.contains("<span")) {
                String m1 = message.substring(0, message.indexOf("<span"));
                String m2 = message.substring(message.indexOf("atname\">")+8, message.indexOf("</span>"));
                String m3 = message.substring(message.indexOf("/span>")+6);
                message = m1 + m2 + m3;
            }
            while (message.contains("<img")) {
                String m1 = message.substring(0, message.indexOf("<img"));
                String m2 = message.substring(message.indexOf("src=\"")+5, message.indexOf("\" border"));
                String m3 = message.substring(message.indexOf("/>")+2);
                message = m1 + m2 + m3;
            }
            nodes.add(0, new ChatNode(i, author, message)
            );
        }
        return nodes;
    }

}
