package com.minestein.novauniverse.nms;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class Packets {

    public static class JSON {

        public static final String DIVIDE = "{text:§6§l§m----------------------------------------}";

        public static final String MAINTENANCE = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lMAINTENANCE §7- §eUtility\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/maintenance \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/maintenance\n§7§oAliases: §cNone\n\n§e§lDisallow joining for certain players.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String BUG = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lBUG §7- §eReporting\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/bug <message> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/bug <message>\n§7§oAliases: §cNone\n\n§e§lReport a bug or glitch using 'message'.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String REPORT = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lREPORT §7- §eReporting\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/report <player> <message> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/report <player> <message>\n§7§oAliases: §cNone\n\n§e§lReport 'player' for a wrongdoing ('message').\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String SKIN_REPORT = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lSKIN REPORT §7- §eReporting\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/skinreport <player> <message> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/skinreport <player> <message>\n§7§oAliases: §cNone\n\n§e§lReport 'player' for an inappropriate skin.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String MESSAGE = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lMESSAGE §7- §eGeneral\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/message <player> <message>\"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/message <player> <message>\n§7§oAliases: §e/msg, /tell, /w, /whisper\n\n§e§lSends 'player' 'message'.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String HELP = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lHELP §7- §eUtility\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/help \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/help\n§7§oAliases: §cNone\n\n§e§lReceive help for a command.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String ROCKET = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lROCKET §7- §eFun\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/rocket <player> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/rocket <player>\n§7§oAliases: §cNone\n\n§e§lRocket 'player' into the air.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String SLAP = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lSLAP §7- §eFun\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/slap <player> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/slap <player>\n§7§oAliases: §cNone\n\n§e§lSlap 'player' away.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String CONTROL_PANEL = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lCONTROL PANEL §7- §eUtility\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/controlpanel \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/controlpanel <player>\n§7§oAliases: §e/cp\n\n§e§lOpens the admin control panel.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";

        public static final String LAUNCH = "[\n" +
                "    {\n" +
                "        \"text\": \"§e§lLAUNCH §7- §eFun\",\n" +
                "        \"clickEvent\": {\n" +
                "            \"action\": \"suggest_command\",\n" +
                "            \"value\": \"/launch <player> \"\n" +
                "        },\n" +
                "        \"hoverEvent\": {\n" +
                "            \"action\": \"show_text\",\n" +
                "            \"value\": {\n" +
                "                \"text\": \"§7§oUsage: §e/launch <player>\n§7§oAliases: §cNone\n\n§e§lLaunches 'player' into the air.\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";
    }
}
