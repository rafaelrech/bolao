package rio2016.util;

import java.util.HashMap;

public class Rio2016WebUtil {

	public static final String DASHBOARD_JSP = "dashboard.jsp";
	public static final String DBUTIL_JSP = "db-admin.jsp";

	private static HashMap<String, String[]> map = new HashMap<String, String[]>();

	static {
		map.put("ABW", new String[] { "Aruba", "Aruba.png" });
		map.put("AFG", new String[] { "Afeganistão", "Afghanistan.png" });
		map.put("AFS", new String[] { "África do Sul", "South-africa.png" });
		map.put("AGO", new String[] { "Angola", "Angola.png" });
		map.put("AIA", new String[] { "Anguilla", "Anguilla.png" });
		map.put("ALA", new String[] { "Ilhas Aland", "Aland.png" });
		map.put("ALB", new String[] { "Albania", "Albania.png" });
		map.put("ALE", new String[] { "Alemanha", "Germany.png" });
		map.put("ALG", new String[] { "Algéria", "Algeria.png" });
		map.put("AND", new String[] { "Andorra", "Andorra.png" });
		map.put("ANG", new String[] { "Angola", "Angola.png" });
		map.put("ARE", new String[] { "Emirados Árabes Unidos", "United-arab-emirates.png" });
		map.put("ARG", new String[] { "Argentina", "Argentina.png" });
		map.put("ARM", new String[] { "Armênia", "Armenia.png" });
		map.put("ARU", new String[] { "Aruba", "Aruba.png" });
		map.put("ASM", new String[] { "Samoa Ocidental", "American-samoa.png" });
		map.put("ATA", new String[] { "Antártida", "Antarctica.png" });
		map.put("ATG", new String[] { "Antigua e Barbuda", "Antigua-and-barbuda.png" });
		map.put("AUS", new String[] { "Austrália", "Australia.png" });
		map.put("AUT", new String[] { "Áustria", "Austria.png" });
		map.put("AZE", new String[] { "Azerbaijão", "Azerbaijan.png" });
		map.put("BAH", new String[] { "Bahamas", "Bahamas.png" });
		map.put("BDI", new String[] { "Burundi", "Burundi.png" });
		map.put("BEL", new String[] { "Bélgica", "Belgium.png" });
		map.put("BEN", new String[] { "Benin", "Benin.png" });
		map.put("BES", new String[] { "Bonaire", "Bonaire.png" });
		map.put("BFA", new String[] { "Burkina Faso", "Burkina-faso.png" });
		map.put("BGD", new String[] { "Bangladesh", "Bangladesh.png" });
		map.put("BGR", new String[] { "Bulgária", "Bulgaria.png" });
		map.put("BHR", new String[] { "Barein", "Bahrain.png" });
		map.put("BHS", new String[] { "Bahamas", "Bahamas.png" });
		map.put("BIE", new String[] { "Bielorrússia", "Belarus.png" });
		map.put("BIH", new String[] { "Bósnia e Herzegovínia", "Bosnia-and-Herzegovina.png" });
		map.put("BLR", new String[] { "Bielorrússia", "Belarus.png" });
		map.put("BLZ", new String[] { "Belize", "Belize.png" });
		map.put("BMU", new String[] { "Bermudas", "Bermuda.png" });
		map.put("BOL", new String[] { "Bolívia", "Bolivia.png" });
		map.put("BOT", new String[] { "Botsuana", "Botswana.png" });
		map.put("BRA", new String[] { "Brasil", "Brazil.png" });
		map.put("BRB", new String[] { "Barbados", "Barbados.png" });
		map.put("BRN", new String[] { "Brunei", "Brunei.png" });
		map.put("BTN", new String[] { "Butão", "Bhutan.png" });
		map.put("BUL", new String[] { "Bulgária", "Bulgaria.png" });
		map.put("BWA", new String[] { "Botsuana", "Botswana.png" });
		map.put("CAF", new String[] { "República Centro-Africana", "Central-african-republic.png" });
		map.put("CAM", new String[] { "Camarões", "Cameroon.png" });
		map.put("CAN", new String[] { "Canadá", "Canada.png" });
		map.put("CCK", new String[] { "Ilhas Cocos", "Cocos.png" });
		map.put("CDN", new String[] { "Coréia do Norte", "North-korea.png" });
		map.put("CDS", new String[] { "Coréia do Sul", "South-Korea.png" });
		map.put("CHE", new String[] { "Suiça", "Switzerland.png" });
		map.put("CHI", new String[] { "Chile", "Chile.png" });
		map.put("CHL", new String[] { "Chile", "Chile.png" });
		map.put("CHN", new String[] { "China", "China.png" });
		map.put("CIV", new String[] { "Costa do Marfim", "Ivory-coast.png" });
		map.put("CMR", new String[] { "Camarões", "Cameroon.png" });
		map.put("COD", new String[] { "República Democrática do Congo", "Congo.png" });
		map.put("COG", new String[] { "Congo", "Congo-kinshasa.png" });
		map.put("COK", new String[] { "Ilhas Cook", "Cook-islands.png" });
		map.put("COL", new String[] { "Colômbia", "Colombia.png" });
		map.put("COM", new String[] { "Comores", "Comoros.png" });
		map.put("CON", new String[] { "República Democrática do Congo", "Congo.png" });
		map.put("CPV", new String[] { "Cabo Verde", "Cape-verde.png" });
		map.put("CRI", new String[] { "Costa Rica", "Costa-rica.png" });
		map.put("CRO", new String[] { "Croácia", "Croatia.png" });
		map.put("CUB", new String[] { "Cuba", "Cuba.png" });
		map.put("CUR", new String[] { "Curaçao", "Curacao.png" });
		map.put("CUW", new String[] { "Curaçao", "Curacao.png" });
		map.put("CXR", new String[] { "Ilhas Natal", "Christmas-Island.png" });
		map.put("CYM", new String[] { "Ilhas Cayman", "Cayman-Islands.png" });
		map.put("CYP", new String[] { "Chipre", "Cyprus.png" });
		map.put("CZE", new String[] { "República Tcheca", "Czech-Republic.png" });
		map.put("DEN", new String[] { "Dinamarca", "Denmark.png" });
		map.put("DEU", new String[] { "Alemanha", "Germany.png" });
		map.put("DIN", new String[] { "Dinamarca", "Denmark.png" });
		map.put("DJI", new String[] { "Djibouti", "Djibouti.png" });
		map.put("DNK", new String[] { "Dinamarca", "Denmark.png" });
		map.put("DOM", new String[] { "República Dominicana", "Dominican-republic.png" });
		map.put("DZA", new String[] { "Algéria", "Algeria.png" });
		map.put("EAU", new String[] { "Emirados Árabes Unidos", "United-arab-emirates.png" });
		map.put("ECU", new String[] { "Equador", "Ecuador.png" });
		map.put("EGI", new String[] { "Egito", "Egypt.png" });
		map.put("EGY", new String[] { "Egito", "Egypt.png" });
		map.put("ELS", new String[] { "El Salvador", "El-salvador.png" });
		map.put("EQU", new String[] { "Equador", "Ecuador.png" });
		map.put("ERI", new String[] { "Eritréia", "Eritrea.png" });
		map.put("ESP", new String[] { "Espanha", "Spain.png" });
		map.put("EST", new String[] { "Estônia", "Estonia.png" });
		map.put("ETH", new String[] { "Etiópia", "Ethiopia.png" });
		map.put("EUA", new String[] { "Estados Unidos", "USA.png" });
		map.put("FIJ", new String[] { "Fiji", "Fiji.png" });
		map.put("FIL", new String[] { "Filipinas", "Philippines.png" });
		map.put("FIN", new String[] { "Finlândia", "Finland.png" });
		map.put("FJI", new String[] { "Fiji", "Fiji.png" });
		map.put("FLK", new String[] { "Inlhas Malvinas", "Falkland-islands.png" });
		map.put("FRA", new String[] { "França", "France.png" });
		map.put("FRO", new String[] { "Ilhas Faroe", "Faroe-islands.png" });
		map.put("FSM", new String[] { "Micronésia", "Micronesia.png" });
		map.put("GAB", new String[] { "Gabão", "Gabon.png" });
		map.put("GBR", new String[] { "Reino Unido", "United-kingdom.png" });
		map.put("GEO", new String[] { "Geórgia", "Georgia.png" });
		map.put("GER", new String[] { "Alemanha", "Germany.png" });
		map.put("GHA", new String[] { "Gana", "Ghana.png" });
		map.put("GIB", new String[] { "Gibraltar", "Gibraltar.png" });
		map.put("GIN", new String[] { "Guiné", "Guinea.png" });
		map.put("GLP", new String[] { "Guadalupe", "Guadeloupe.png" });
		map.put("GMB", new String[] { "Gâmbia", "Gambia.png" });
		map.put("GNB", new String[] { "Guiné Bissau", "Guinea-bissau.png" });
		map.put("GNQ", new String[] { "Guiné Equatorial", "Equatorial-guinea.png" });
		map.put("GRC", new String[] { "Grécia", "greece.png" });
		map.put("GRD", new String[] { "Granada", "Grenada.png" });
		map.put("GRE", new String[] { "Grécia", "greece.png" });
		map.put("GRL", new String[] { "Groenlândia", "Greenland.png" });
		map.put("GTM", new String[] { "Guatemala", "Guatemala.png" });
		map.put("GUA", new String[] { "Guatemala", "Guatemala.png" });
		map.put("GUM", new String[] { "Guam", "Guam.png" });
		map.put("GUY", new String[] { "Guiana", "Guyana.png" });
		map.put("HAI", new String[] { "Haiti", "Haiti.png" });
		map.put("HKG", new String[] { "Hong Kong", "Hong-kong.png" });
		map.put("HND", new String[] { "Honduras", "Honduras.png" });
		map.put("HOL", new String[] { "Países Baixos", "Netherlands.png" });
		map.put("HON", new String[] { "Honduras", "Honduras.png" });
		map.put("HRV", new String[] { "Croácia", "Croatia.png" });
		map.put("HTI", new String[] { "Haiti", "Haiti.png" });
		map.put("HUN", new String[] { "Hungria", "Hungary.png" });
		map.put("IDN", new String[] { "Indonésia", "Indonesia.png" });
		map.put("IND", new String[] { "Índia", "India.png" });
		map.put("IRL", new String[] { "Irlanda", "Ireland.png" });
		map.put("IRN", new String[] { "Irã", "Iran.png" });
		map.put("IRQ", new String[] { "Iraque", "Iraq.png" });
		map.put("ISL", new String[] { "Islândia", "Iceland.png" });
		map.put("ISR", new String[] { "Israel", "Israel.png" });
		map.put("ITA", new String[] { "Itália", "Italy.png" });
		map.put("JAM", new String[] { "Jamaica", "Jamaica.png" });
		map.put("JAP", new String[] { "Japão", "Japan.png" });
		map.put("JOR", new String[] { "Jordânia", "Jordan.png" });
		map.put("JPN", new String[] { "Japão", "Japan.png" });
		map.put("KAZ", new String[] { "Cazaquistão", "Kazakhstan.png" });
		map.put("KEN", new String[] { "Quênia", "Kenya.png" });
		map.put("KGZ", new String[] { "Quirguistão", "Kyrgyzstan.png" });
		map.put("KHM", new String[] { "Cambodja", "Cambodia.png" });
		map.put("KIR", new String[] { "Quiribati", "Kiribati.png" });
		map.put("KNA", new String[] { "São Cristóvão e Nevis", "Saint-kitts-and-nevis.png" });
		map.put("KOR", new String[] { "Coréia do Sul", "South-Korea.png" });
		map.put("KUW", new String[] { "Kuwait", "Kuwait.png" });
		map.put("KWT", new String[] { "Kuwait", "Kuwait.png" });
		map.put("LAO", new String[] { "Laos", "Laos.png" });
		map.put("LBN", new String[] { "Líbano", "Lebanon.png" });
		map.put("LBR", new String[] { "Libéria", "Liberia.png" });
		map.put("LBY", new String[] { "Líbia", "Libya.png" });
		map.put("LCA", new String[] { "Santa Lúcia", "Saint-lucia.png" });
		map.put("SLU", new String[] { "Santa Lúcia", "Saint-lucia.png" });
		map.put("LET", new String[] { "Letônia", "Latvia.png" });
		map.put("LIB", new String[] { "Líbano", "Lebanon.png" });
		map.put("LIE", new String[] { "Liechtenstein", "Liechtenstein.png" });
		map.put("LIT", new String[] { "Lituânia", "Lithuania.png" });
		map.put("LKA", new String[] { "Sri Lanka", "Sri-lanka.png" });
		map.put("LSO", new String[] { "Lesoto", "Lesotho.png" });
		map.put("LTU", new String[] { "Lituânia", "Lithuania.png" });
		map.put("LUX", new String[] { "Luxemburgo", "Luxembourg.png" });
		map.put("LVA", new String[] { "Letônia", "Latvia.png" });
		map.put("MAC", new String[] { "Macau", "Macau.png" });
		map.put("MAD", new String[] { "Madagascar", "Madagascar.png" });
		map.put("MAL", new String[] { "Malásia", "Malaysia.png" });
		map.put("MAR", new String[] { "Marrocos", "Morocco.png" });
		map.put("MCO", new String[] { "Mônaco", "Monaco.png" });
		map.put("MDA", new String[] { "Moldávia", "Moldova.png" });
		map.put("MDG", new String[] { "Madagascar", "Madagascar.png" });
		map.put("MDV", new String[] { "Maldivas", "Maldives.png" });
		map.put("MEX", new String[] { "México", "Mexico.png" });
		map.put("MHL", new String[] { "Ilhas Marshall", "Marshall-islands.png" });
		map.put("MKD", new String[] { "Macedônia", "Macedonia.png" });
		map.put("MLI", new String[] { "Mali", "Mali.png" });
		map.put("MLT", new String[] { "Malta", "Malta.png" });
		map.put("MMR", new String[] { "Mianmar", "Myanmar.png" });
		map.put("MNE", new String[] { "Montenegro", "Montenegro.png" });
		map.put("MNG", new String[] { "Mongólia", "Mongolia.png" });
		map.put("MNP", new String[] { "Ilhas Marianas do Norte", "Northern-Mariana.png" });
		map.put("MOR", new String[] { "Marrocos", "Morocco.png" });
		map.put("MOZ", new String[] { "Moçambique", "Mozambique.png" });
		map.put("MRT", new String[] { "Mauritânia", "Mauritania.png" });
		map.put("MSR", new String[] { "Montserrat", "Montserrat.png" });
		map.put("MTQ", new String[] { "Martinica", "Martinique.png" });
		map.put("MUS", new String[] { "Ilhas Maurício", "Mauritius.png" });
		map.put("MWI", new String[] { "Malawi", "Malawi.png" });
		map.put("MYS", new String[] { "Malásia", "Malaysia.png" });
		map.put("NAM", new String[] { "Namíbia", "Namibia.png" });
		map.put("NCL", new String[] { "Nova Caledônia", "New-caledonia.png" });
		map.put("NED", new String[] { "Países Baixos", "Netherlands.png" });
		map.put("NER", new String[] { "Níger", "Niger.png" });
		map.put("NFK", new String[] { "Ilhas Norfolk", "Norfolk-island.png" });
		map.put("NIG", new String[] { "Nigéria", "Nigeria.png" });
		map.put("NGA", new String[] { "Nigéria", "Nigeria.png" });
		map.put("NIC", new String[] { "Nicarágua", "Nicaragua.png" });
		map.put("NIU", new String[] { "Niue", "Niue.png" });
		map.put("NLD", new String[] { "Países Baixos", "Netherlands.png" });
		map.put("NOR", new String[] { "Noruega", "Norway.png" });
		map.put("NPL", new String[] { "Nepal", "Nepal.png" });
		map.put("NRU", new String[] { "Nauru", "Nauru.png" });
		map.put("NZL", new String[] { "Nova Zelândia", "New-Zealand.png" });
		map.put("OMN", new String[] { "Omã", "Oman.png" });
		map.put("PAK", new String[] { "Paquistão", "Pakistan.png" });
		map.put("PAN", new String[] { "Panamá", "Panama.png" });
		map.put("PAR", new String[] { "Paraguai", "Paraguay.png" });
		map.put("PER", new String[] { "Peru", "Peru.png" });
		map.put("PHL", new String[] { "Filipinas", "Philippines.png" });
		map.put("PNG", new String[] { "Papua Nova Guiné", "Papua-new-guinea.png" });
		map.put("POL", new String[] { "Polônia", "Poland.png" });
		map.put("POR", new String[] { "Portugal", "Portugal.png" });
		map.put("PRI", new String[] { "Porto Rico", "Puerto-rico.png" });
		map.put("PRK", new String[] { "Coréia do Norte", "North-korea.png" });
		map.put("PRT", new String[] { "Portugal", "Portugal.png" });
		map.put("PRY", new String[] { "Paraguai", "Paraguay.png" });
		map.put("PSE", new String[] { "Palestina", "Palestinian-Territory.png" });
		map.put("PUE", new String[] { "Porto Rico", "Puerto-rico.png" });
		map.put("PYF", new String[] { "Polinésia Francesa", "French-polynesia.png" });
		map.put("CAT", new String[] { "Catar", "Qatar.png" });
		map.put("QAT", new String[] { "Catar", "Qatar.png" });
		map.put("QUE", new String[] { "Quênia", "Kenya.png" });
		map.put("ROM", new String[] { "Romênia", "Romania.png" });
		map.put("ROU", new String[] { "Romênia", "Romania.png" });
		map.put("RUS", new String[] { "Rússia", "Russia.png" });
		map.put("RWA", new String[] { "Ruanda", "Rwanda.png" });
		map.put("SAU", new String[] { "Arábia Saudita", "Saudi-arabia.png" });
		map.put("SDN", new String[] { "Sudão", "Sudan.png" });
		map.put("SEN", new String[] { "Senegal", "Senegal.png" });
		map.put("SGP", new String[] { "Singapura", "Singapore.png" });
		map.put("SGS", new String[] { "Geórgia do Sul", "South-Georgia.png" });
		map.put("SJM", new String[] { "Svalbard", "Svalbard.png" });
		map.put("SLB", new String[] { "Ilhas Salomão", "Solomon-islands.png" });
		map.put("SLE", new String[] { "Serra Leoa", "Sierra-leone.png" });
		map.put("SLV", new String[] { "El Salvador", "El-salvador.png" });
		map.put("SMR", new String[] { "San Marino", "San-marino.png" });
		map.put("SOM", new String[] { "Somália", "somalia.png" });
		map.put("SPA", new String[] { "Espanha", "Spain.png" });
		map.put("SRB", new String[] { "Sérvia", "Serbia.png" });
		map.put("STP", new String[] { "São Tomé e Príncipe", "Sao-Tome-and-Principe.png" });
		map.put("SUD", new String[] { "Sudão", "Sudan.png" });
		map.put("SUE", new String[] { "Suécia", "Sweden.png" });
		map.put("SUI", new String[] { "Suiça", "Switzerland.png" });
		map.put("SUR", new String[] { "Suriname", "Suriname.png" });
		map.put("SVK", new String[] { "Eslováquia", "Slovakia.png" });
		map.put("SVN", new String[] { "Eslovênia", "Slovenia.png" });
		map.put("SLO", new String[] { "Eslovênia", "Slovenia.png" });
		map.put("SWE", new String[] { "Suécia", "Sweden.png" });
		map.put("SWZ", new String[] { "Suazilândia", "Swaziland.png" });
		map.put("SXM", new String[] { "San Marteen", "Sint-Maarten.png" });
		map.put("SYC", new String[] { "Seychelles", "Seychelles.png" });
		map.put("SYR", new String[] { "Síria", "Syria.png" });
		map.put("TCA", new String[] { "Ilhas Turcas e Caícos", "Turks-and-Caicos.png" });
		map.put("TCD", new String[] { "Chade", "Chad.png" });
		map.put("TGO", new String[] { "Togo", "Togo.png" });
		map.put("THA", new String[] { "Tailândia", "Thailand.png" });
		map.put("TJK", new String[] { "Tadjiquistão", "Tajikistan.png" });
		map.put("TKM", new String[] { "Turcomenistão", "Turkmenistan.png" });
		map.put("TLS", new String[] { "Timor Leste", "Timor-leste.png" });
		map.put("TOG", new String[] { "Togo", "Togo.png" });
		map.put("TON", new String[] { "Tonga", "Tonga.png" });
		map.put("TTO", new String[] { "Trinidad e Tobago", "Trinidad-and-tobago.png" });
		map.put("TUN", new String[] { "Tunísia", "Tunisia.png" });
		map.put("TUR", new String[] { "Turquia", "Turkey.png" });
		map.put("TUV", new String[] { "Tuvalu", "Tuvalu.png" });
		map.put("TWN", new String[] { "Taiwan", "Taiwan.png" });
		map.put("TZA", new String[] { "Tanzânia", "Tanzania.png" });
		map.put("TAN", new String[] { "Tanzânia", "Tanzania.png" });
		map.put("UGA", new String[] { "Uganda", "Uganda.png" });
		map.put("UKR", new String[] { "Ucrânia", "Ukraine.png" });
		map.put("URU", new String[] { "Uruguai", "Uruguay.png" });
		map.put("URY", new String[] { "Uruguai", "Uruguay.png" });
		map.put("USA", new String[] { "Estados Unidos", "USA.png" });
		map.put("UZB", new String[] { "Usbequistão", "Uzbekistan.png" });
		map.put("VCT", new String[] { "São Vicente e Granadinas", "Saint-Vincent-and-the-Grenadines.png" });
		map.put("VEN", new String[] { "Venezuela", "Venezuela.png" });
		map.put("VGB", new String[] { "Virgens Britânicas", "British-virgin.png" });
		map.put("VIR", new String[] { "Ilhas Virgens", "United-States-Virgin-Islands.png" });
		map.put("VNM", new String[] { "Vietnã", "Vietnam.png" });
		map.put("VUT", new String[] { "Vanuatu", "Vanuatu.png" });
		map.put("WSM", new String[] { "Samoa", "Samoa.png" });
		map.put("YEM", new String[] { "Iêmen", "Yemen.png" });
		map.put("ZAF", new String[] { "África do Sul", "South-africa.png" });
		map.put("ZAM", new String[] { "Zâmbia", "Zambia.png" });
		map.put("ZIM", new String[] { "Zimbábue", "Zimbabwe.png" });
		map.put("ZMB", new String[] { "Zâmbia", "Zambia.png" });
		map.put("ZWE", new String[] { "Zimbábue", "Zimbabwe.png" });
		map.put("CGO", new String[] { "Congo", "Congo-kinshasa.png" });
		map.put("SIN", new String[] { "Singapura", "Singapore.png" });
		map.put("MAS", new String[] { "Malásia", "Malaysia.png" });
		map.put("MGL", new String[] { "Mongólia", "Mongolia.png" });
		map.put("BER", new String[] { "Bermudas", "Bermuda.png" });
		map.put("KSA", new String[] { "Arábia Saudita", "Saudi-arabia.png" });
		map.put("ESA", new String[] { "El Salvador", "El-salvador.png" });
	}

	public static String getImageString(String key) {
		return getImageString(key, 40, 40);
	}

	public static String getImageString(String key, int width, int height) {
		String imgSrc = "";
		String[] strings = map.get(key);
		if (strings != null) {
			imgSrc = String.format("<img src='images/flags/%s' alt='%s' height='%d' width='%d'>", strings[1],
					strings[0], height, width);
		}
		return imgSrc;
	}

	public static void main(String args[]) {
		System.out.println(getImageString("BRA"));
		System.out.println(getImageString("EUA"));
		System.out.println(getImageString("USA"));
		System.out.println(getImageString("GRB"));
		System.out.println(getImageString("ALE"));
	}
}