package com.dao;

import java.math.BigInteger;
import java.util.List;

import com.pojo.UserStock;

public interface TradeRecommendationSystemDAO {
	
	public List<UserStock> findCustomerStocks(int customerid);
	public boolean verifyUser(String username, String password);
	public List<String> stocksWithinMarketCap(BigInteger marketCapSelected);
	public void updateDatabaseForToday();
	public void insertCompanySymbolsAndSector();
	public void unsaveAStock(int userid,String stockSymbol);
	
	public String x_rapidapi_key="ad930ecec8mshbddd2c857bc6bb4p1a3f2bjsn469460ef77f1";
	public String x_rapidapi_host="apidojo-yahoo-finance-v1.p.rapidapi.com";
	
	// Took all nse symbols from a downloaded csv from NSE
	public String [] nsestocks={"RELIANCE",
		"TCS",
		"HDFCBANK",
		"INFY",
		"HINDUNILVR",
		"HDFC",
		"ICICIBANK",
		"KOTAKBANK",
		"SBIN",
		"BAJFINANCE",
		"BHARTIARTL",
		"ITC",
		"HCLTECH",
		"ASIANPAINT",
		"WIPRO",
		"AXISBANK",
		"MARUTI",
		"LT",
		"ULTRACEMCO",
		"DMART",
		"ADANIGREEN",
		"BAJAJFINSV",
		"SUNPHARMA",
		"ADANIPORTS",
		"HDFCLIFE",
		"TITAN",
		"ONGC",
		"HINDZINC",
		"ADANIENT",
		"JSWSTEEL",
		"POWERGRID",
		"SHREECEM",
		"BAJAJ-AUTO",
		"ATGL",
		"NTPC",
		"TATAMOTORS",
		"ADANITRANS",
		"M&M",
		"DIVISLAB",
		"TECHM",
		"DABUR",
		"GRASIM",
		"BPCL",
		"PIDILITIND",
		"TATASTEEL",
		"SBILIFE",
		"BRITANNIA",
		"SBICARD",
		"IOC",
		"VEDL",
		"COALINDIA",
		"DRREDDY",
		"GODREJCP",
		"BERGEPAINT",
		"INDUSINDBK",
		"HINDALCO",
		"EICHERMOT",
		"DLF",
		"LTI",
		"INDUSTOWER",
		"HAVELLS",
		"CIPLA",
		"SIEMENS",
		"ICICIGI",
		"ICICIPRULI",
		"MOTHERSUMI",
		"INDIGO",
		"HDFCAMC",
		"AMBUJACEM",
		"GAIL",
		"TATACONSUM",
		"HEROMOTOCO",
		"NAUKRI",
		"BANDHANBNK",
		"MARICO",
		"AUROPHARMA",
		"BIOCON",
		"UPL",
		"MUTHOOTFIN",
		"LUPIN",
		"CHOLAFIN",
		"CADILAHC",
		"TORNTPHARM",
		"COLPAL",
		"HONAUT",
		"APOLLOHOSP",
		"BOSCHLTD",
		"IDBI",
		"PGHH",
		"GLAND",
		"MCDOWELL-N",
		"NMDC",
		"PEL",
		"GODREJPROP",
		"YESBANK",
		"JUBLFOOD",
		"PNB",
		"AUBANK",
		"BANKBARODA",
		"GUJGASLTD",
		"BAJAJHLDNG",
		"CONCOR",
		"SRTRANSFIN",
		"IGL",
		"ACC",
		"JINDALSTEL",
		"GICRE",
		"MRF",
		"HINDPETRO",
		"MINDTREE",
		"3MINDIA",
		"PIIND",
		"PAGEIND",
		"PETRONET",
		"ASHOKLEY",
		"HAL",
		"MPHASIS",
		"VOLTAS",
		"ALKEM",
		"TATAPOWER",
		"UBL",
		"ADANIPOWER",
		"BALKRISIND",
		"SAIL",
		"ASTRAL",
		"KANSAINER",
		"SRF",
		"IDFCFIRSTB",
		"BEL",
		"TATACOMM",
		"PFC",
		"IRFC",
		"ABB",
		"DALBHARAT",
		"MFSL",
		"VBL",
		"ABCAPITAL",
		"SUNDARMFIN",
		"WHIRLPOOL",
		"IRCTC",
		"LTTS",
		"TVSMOTOR",
		"BHARATFORG",
		"OFSS",
		"TRENT",
		"IDEA",
		"IOB",
		"SUPREMEIND",
		"RECLTD",
		"CUMMINSIND",
		"NIACL",
		"CANBK",
		"CROMPTON",
		"M&MFIN",
		"NHPC",
		"GLAXO",
		"IPCALAB",
		"L&TFH",
		"RAMCOCEM",
		"INDIAMART",
		"TIINDIA",
		"AARTIIND",
		"COROMANDEL",
		"DEEPAKNTR",
		"LALPATHLAB",
		"JKCEMENT",
		"BANKINDIA",
		"UNIONBANK",
		"RELAXO",
		"SYNGENE",
		"LICHSGFIN",
		"EMAMILTD",
		"DIXON",
		"ATUL",
		"OBEROIRLTY",
		"NAM-INDIA",
		"PFIZER",
		"POLYCAB",
		"ENDURANCE",
		"TORNTPOWER",
		"MAXHEALTH",
		"ZEEL",
		"LAURUSLABS",
		"AIAENG",
		"GILLETTE",
		"TATACHEM",
		"AAVAS",
		"RUCHI",
		"APLLTD",
		"SUNTV",
		"GODREJIND",
		"SANOFI",
		"BATAINDIA",
		"COFORGE",
		"APLAPOLLO",
		"ESCORTS",
		"ABFRL",
		"SCHAEFFLER",
		"BHEL",
		"SUNDRMFAST",
		"TATAELXSI",
		"THERMAX",
		"HATSUN",
		"EXIDEIND",
		"AJANTPHARM",
		"GSPL",
		"LINDEINDIA",
		"FEDERALBNK",
		"NATCOPHARM",
		"FORTIS",
		"KAJARIACER",
		"MINDAIND",
		"PERSISTENT",
		"GMRINFRA",
		"AMARAJABAT",
		"SUMICHEM",
		"JSWENERGY",
		"VINATIORGA",
		"APOLLOTYRE",
		"RAJESHEXPO",
		"AFFLE",
		"MAHABANK",
		"NAVINFLUOR",
		"PHOENIXLTD",
		"CRISIL",
		"OIL",
		"BLUEDART",
		"INDHOTEL",
		"GLENMARK",
		"INDIANB",
		"SUVENPHAR",
		"MANAPPURAM",
		"ZYDUSWELL",
		"VAIBHAVGBL",
		"WABCOINDIA",
		"RBLBANK",
		"CASTROLIND",
		"ISEC",
		"PRESTIGE",
		"ALKYLAMINE",
		"SOLARINDS",
		"MGL",
		"CUB",
		"METROPOLIS",
		"INDIGOPNTS",
		"CHOLAHLDNG",
		"BAJAJELEC",
		"AMBER",
		"SKFINDIA",
		"TANLA",
		"HINDCOPPER",
		"UCOBANK",
		"IIFLWAM",
		"JUBLPHARMA",
		"VGUARD",
		"ITI",
		"IIFL",
		"KEC",
		"GRINDWELL",
		"AEGISCHEM",
		"AKZOINDIA",
		"CREDITACC",
		"QUESS",
		"PGHL",
		"SJVN",
		"NATIONALUM",
		"GODREJAGRO",
		"TTKPRESTIG",
		"ALOKINDS",
		"GRAPHITE",
		"IEX",
		"INTELLECT",
		"ORCHPHARMA",
		"TIMKEN",
		"JBCHEPHARM",
		"CARBORUNIV",
		"SFL",
		"CENTRALBK",
		"CHAMBLFERT",
		"MOTILALOFS",
		"IBULHSGFIN",
		"GALAXYSURF",
		"SHRIRAMCIT",
		"BLUESTARCO",
		"BASF",
		"CGPOWER",
		"RATNAMANI",
		"DHANI",
		"SYMPHONY",
		"HUDCO",
		"KIOCL",
		"NBCC",
		"NH",
		"ERIS",
		"CANFINHOME",
		"ROUTE",
		"WELSPUNIND",
		"JMFINANCIL",
		"DBL",
		"HAPPSTMNDS",
		"FSL",
		"FINPIPE",
		"POLYMED",
		"CESC",
		"DCMSHRIRAM",
		"BBTC",
		"STLTECH",
		"STAR",
		"IDFC",
		"ASAHIINDIA",
		"ASTRAZEN",
		"GRANULES",
		"RADICO",
		"VTL",
		"EPL",
		"PVR",
		"REDINGTON",
		"UTIAMC",
		"KPRMILL",
		"BIRLACORPN",
		"LAXMIMACH",
		"JCHAC",
		"TRIDENT",
		"CYIENT",
		"CENTURYPLY",
		"BSOFT",
		"KALYANKJIL",
		"FINEORG",
		"NLCINDIA",
		"ASTERDM",
		"EQUITASBNK",
		"CDSL",
		"MRPL",
		"CGCL",
		"PNCINFRA",
		"ORIENTELEC",
		"PRSMJOHNSN",
		"AARTIDRUGS",
		"TEAMLEASE",
		"MMTC",
		"FLUOROCHEM",
		"INFIBEAM",
		"PNBHOUSING",
		"CEATLTD",
		"GMMPFAUDLR",
		"SUNCLAYLTD",
		"ZENSARTECH",
		"MAHINDCIE",
		"BDL",
		"RVNL",
		"ELGIEQUIP",
		"KNRCON",
		"SEQUENT",
		"VAKRANGEE",
		"EDELWEISS",
		"BRIGADE",
		"FINCABLES",
		"EIHOTEL",
		"POWERINDIA",
		"RITES",
		"SIS",
		"TATASTLBSL",
		"BALAMINES",
		"HEG",
		"AVANTIFEED",
		"EIDPARRY",
		"KALPATPOWR",
		"VMART",
		"ROSSARI",
		"SONATSOFTW",
		"JUSTDIAL",
		"HEIDELBERG",
		"GARFIBRES",
		"UJJIVANSFB",
		"TATAINVEST",
		"VSTIND",
		"BEML",
		"CENTURYTEX",
		"INDIACEM",
		"SCI",
		"JKLAKSHMI",
		"CERA",
		"JYOTHYLAB",
		"VIPIND",
		"SOLARA",
		"TV18BRDCST",
		"COCHINSHIP",
		"BURGERKING",
		"VARROC",
		"RALLIS",
		"ANURAS",
		"KPITTECH",
		"FDC",
		"NCC",
		"RAIN",
		"THYROCARE",
		"GODFRYPHLP",
		"KEI",
		"GPPL",
		"GNFC",
		"MASFIN",
		"LXCHEM",
		"GESHIP",
		"PRINCEPIPE",
		"WOCKPHARMA",
		"HATHWAY",
		"BALRAMCHIN",
		"IFBIND",
		"NAZARA",
		"RESPONIND",
		"KARURVYSYA",
		"LUXIND",
		"ENGINERSIN",
		"DELTACORP",
		"MAZDOCK",
		"RCF",
		"JSWHL",
		"SUZLON",
		"KRBL",
		"MAHLOG",
		"IRCON",
		"SWSOLAR",
		"SOBHA",
		"JUBLINGREA",
		"SUNTECK",
		"MAHSCOOTER",
		"RAILTEL",
		"CSBBANK",
		"BHARATRAS",
		"STARCEMENT",
		"SUPPETRO",
		"HOMEFIRST",
		"HEMIPROP",
		"SPANDANA",
		"AGCNET",
		"INDOSTAR",
		"ADVENZYMES",
		"SUPRAJIT",
		"ECLERX",
		"BAJAJCON",
		"IRB",
		"NETWORK18",
		"FACT",
		"SPARC",
		"NESCO",
		"IBREALEST",
		"TASTYBITE",
		"TCIEXP",
		"GULFOILLUB",
		"WELCORP",
		"HGS",
		"SUDARSCHEM",
		"MOIL",
		"PRAJIND",
		"TATASTLLP",
		"TECHNOE",
		"PAISALO",
		"PRIVISCL",
		"MIDHANI",
		"SWANENERGY",
		"ITDC",
		"JSL",
		"TRITURBINE",
		"PHILIPCARB",
		"JINDALPOLY",
		"GSFC",
		"KSCL",
		"IOLCP",
		"HFCL",
		"DHANUKA",
		"INOXLEISUR",
		"BORORENEW",
		"DCBBANK",
		"ICRA",
		"MTARTECH",
		"KSB",
		"TCNSBRANDS",
		"CCL",
		"MASTEK",
		"CAPLIPOINT",
		"ALLCARGO",
		"CHALET",
		"CRAFTSMAN",
		"EQUITAS",
		"GET&D",
		"MAGMA",
		"MEGH",
		"GREAVESCOT",
		"JSLHISAR",
		"GAEL",
		"LEMONTREE",
		"MAHLIFE",
		"NILKAMAL",
		"SURYODAY",
		"NOCIL",
		"ASHOKA",
		"MHRIL",
		"SAREGAMA",
		"TTML",
		"ESABINDIA",
		"UFLEX",
		"SHILPAMED",
		"ORIENTREF",
		"POLYPLEX",
		"JAMNAAUTO",
		"JKTYRE",
		"NEULANDLAB",
		"NFL",
		"INDOCO",
		"ALEMBICLTD",
		"ICIL",
		"SHARDACROP",
		"TATAMETALI",
		"BSE",
		"UJJIVAN",
		"JKPAPER",
		"GPIL",
		"GUJALKALI",
		"HERANBA",
		"LAOPALA",
		"RUPA",
		"RAYMOND",
		"MINDACORP",
		"HCG",
		"ANGELBRKG",
		"JINDALSAW",
		"KIRLOSENG",
		"SHOPERSTOP",
		"DEN",
		"DEEPAKFERT",
		"BEPL",
		"FRETAIL",
		"PTC",
		"HIL",
		"IFCI",
		"RELIGARE",
		"GREENLAM",
		"SCHNEIDER",
		"EASEMYTRIP",
		"TATACOFFEE",
		"JPPOWER",
		"RAMCOIND",
		"GDL",
		"BALMLAWRIE",
		"MATRIMONY",
		"VENKEYS",
		"UNICHEMLAB",
		"GHCL",
		"INGERRAND",
		"SUVIDHAA",
		"GRSE",
		"HUHTAMAKI",
		"REPCOHOME",
		"MSTCLTD",
		"VRLLOG",
		"GREENPLY",
		"JTEKTINDIA",
		"MARKSANS",
		"TRIVENI",
		"ATFL",
		"SUBROS",
		"NEOGEN",
		"AHLUCONT",
		"ORIENTCEM",
		"SUBEXLTD",
		"JBMA",
		"BANARISUG",
		"NEWGEN",
		"BECTORFOOD",
		"TCI",
		"OAL",
		"ASTEC",
		"GREENPANEL",
		"SHIL",
		"NIITLTD",
		"EVEREADY",
		"VESUVIUS",
		"RENUKA",
		"HGINFRA",
		"GEPIL",
		"BOROLTD",
		"KIRLOSBROS",
		"KTKBANK",
		"SURYAROSNI",
		"DAAWAT",
		"MAYURUNIQ",
		"THOMASCOOK",
		"MAHSEAMLES",
		"NAVNETEDUL",
		"DFMFOODS",
		"J&KBANK",
		"APARINDS",
		"SOMANYCERA",
		"CAMLINFINE",
		"ADFFOODS",
		"OLECTRA",
		"SHRIPISTON",
		"HIKAL",
		"GMDCLTD",
		"ACE",
		"PILANIINVS",
		"HSCL",
		"PDSMFL",
		"KOLTEPATIL",
		"PFOCUS",
		"DCAL",
		"ARVIND",
		"DISHTV",
		"JPASSOCIAT",
		"TINPLATE",
		"SAGCEM",
		"RKFORGE",
		"PSPPROJECT",
		"PURVA",
		"AMRUTANJAN",
		"JAGRAN",
		"INEOSSTYRO",
		"HESTERBIO",
		"RAMCOSYS",
		"WELENT",
		"ANANTRAJ",
		"AUTOAXLES",
		"WSTCSTPAPR",
		"SWARAJENG",
		"TVTODAY",
		"SHK",
		"DBCORP",
		"MAITHANALL",
		"FMGOETZE",
		"WABAG",
		"VSTTILLERS",
		"INOXWIND",
		"DALMIASUG",
		"JAICORPLTD",
		"SARDAEN",
		"TIDEWATER",
		"LUMAXIND",
		"SOUTHBANK",
		"CHEMCON",
		"STOVEKRAFT",
		"CHENNPETRO",
		"GABRIEL",
		"ORISSAMINE",
		"TEJASNET",
		"FILATEX",
		"JKIL",
		"BOMDYEING",
		"MOREPENLAB",
		"HMT",
		"HIMATSEIDE",
		"IIFLSEC",
		"KIRIINDUS",
		"NUCLEUS",
		"KSL",
		"DIAMONDYD",
		"SOTL",
		"ARVINDFASN",
		"CAPACITE",
		"TIMETECHNO",
		"HERITGFOOD",
		"RSYSTEMS",
		"TVSSRICHAK",
		"SAFARI",
		"ASHIANA",
		"GTPL",
		"ITDCEM",
		"SASKEN",
		"DOLLAR",
		"APOLLOPIPE",
		"INDIAGLYCO",
		"GANECOS",
		"HINDOILEXP",
		"ACCELYA",
		"PRAKASH",
		"IGPL",
		"PCJEWELLER",
		"JMCPROJECT",
		"RTNPOWER",
		"GATI",
		"OMAXE",
		"GENUSPOWER",
		"SANDHAR",
		"PSB",
		"JSWISPL",
		"NBVENTURES",
		"CONFIPET",
		"IMFA",
		"RPOWER",
		"HCC",
		"DHAMPURSUG",
		"CARERATING",
		"3IINFOTECH",
		"KIRLOSIND",
		"GEOJITFSL",
		"QUICKHEAL",
		"MMFL",
		"FCONSUMER",
		"MTNL",
		"CENTRUM",
		"MUKANDLTD",
		"SHARDAMOTR",
		"PFS",
		"DIGISPICE",
		"SUNDARMHLD",
		"GIPCL",
		"DPSCLTD",
		"IFGLEXPOR",
		"SUNFLAG",
		"COSMOFILMS",
		"ASTRAMICRO",
		"NXTDIGITAL",
		"SEAMECLTD",
		"VOLTAMP",
		"LUMAXTECH",
		"BODALCHEM",
		"PANACEABIO",
		"MOLDTKPAC",
		"SSWL",
		"WHEELS",
		"SHALBY",
		"WONDERLA",
		"JETAIRWAYS",
		"ELECTCAST",
		"GOCLCORP",
		"KCP",
		"PUNJABCHEM",
		"SADBHAV",
		"KKCL",
		"SANGHIIND",
		"YAARII",
		"VIDHIING",
		"EXCELINDUS",
		"NRBBEARING",
		"SMSPHARMA",
		"OPTIEMUS",
		"DREDGECORP",
		"BFINVEST",
		"MANINFRA",
		"GALLISPAT",
		"SESHAPAPER",
		"MANALIPETC",
		"BLISSGVS",
		"TNPL",
		"USHAMART",
		"INDORAMA",
		"BANCOINDIA",
		"KESORAMIND",
		"GTLINFRA",
		"HSIL",
		"BUTTERFLY",
		"FLFL",
		"INSECTICID",
		"SHANTIGEAR",
		"FAIRCHEMOR",
		"ESTER",
		"VINDHYATEL",
		"HONDAPOWER",
		"JINDWORLD",
		"TIIL",
		"LGBBROSLTD",
		"SHAKTIPUMP",
		"BLS",
		"SHANKARA",
		"PRABHAT",
		"APCOTEXIND",
		"BFUTILITIE",
		"HBLPOWER",
		"RELINFRA",
		"ONMOBILE",
		"OCCL",
		"GLOBUSSPR",
		"JISLJALEQS",
		"ASHAPURMIN",
		"SUVEN",
		"RPSGVENT",
		"TEXINFRA",
		"GUFICBIO",
		"PARAGMILK",
		"CIGNITITEC",
		"SHREDIGCEM",
		"EKC",
		"PANAMAPET",
		"TIRUMALCHM",
		"SIYSIL",
		"ANDHRAPAP",
		"PNBGILTS",
		"ARSHIYA",
		"SIRCA",
		"POWERMECH",
		"CLNINDIA",
		"IGARASHI",
		"TARC",
		"MANGCHEFER",
		"PRICOLLTD",
		"IMPAL",
		"RANEHOLDIN",
		"SHAREINDIA",
		"MPSLTD",
		"INDNIPPON",
		"INDIANHUME",
		"MAXVIL",
		"ACRYSIL",
		"POKARNA",
		"SATIA",
		"RADIOCITY",
		"MARINE",
		"SRIPIPES",
		"THANGAMAYL",
		"GFLLIMITED",
		"RAJRATAN",
		"PGEL",
		"ANDHRSUGAR",
		"VISAKAIND",
		"SMCGLOBAL",
		"NCLIND",
		"GMBREW",
		"ASALCBR",
		"APTECHT",
		"GOLDIAM",
		"EMAMIPAP",
		"MANGLMCEM",
		"KARDA",
		"NACLIND",
		"SNOWMAN",
		"FIEMIND",
		"GNA",
		"FOSECOIND",
		"FCL",
		"XCHANGING",
		"TEXRAIL",
		"EIHAHOTELS",
		"ELECON",
		"KINGFA",
		"AARTISURF",
		"RTNINFRA",
		"STERTOOLS",
		"BAJAJHIND",
		"TTKHLTCARE",
		"KELLTONTEC",
		"ENIL",
		"SADBHIN",
		"BHAGERIA",
		"KICL",
		"AVTNPL",
		"TAJGVK",
		"AWHCL",
		"DCW",
		"DATAMATICS",
		"JAYNECOIND",
		"TAKE",
		"KITEX",
		"SMLISUZU",
		"APEX",
		"VADILALIND",
		"SUTLEJTEX",
		"RPGLIFE",
		"5PAISA",
		"SPENCERS",
		"BBL",
		"WENDT",
		"LIKHITHA",
		"CEREBRAINT",
		"GICHSGFIN",
		"SKIPPER",
		"GRAVITA",
		"RBL",
		"CANTABIL",
		"ZENTEC",
		"TIPSINDLTD",
		"MUTHOOTCAP",
		"NURECA",
		"DYNAMATECH",
		"PLASTIBLEN",
		"SPIC",
		"UNIENTER",
		"DYNPRO",
		"ALICON",
		"KUANTUM",
		"DBREALTY",
		"SUMMITSEC",
		"ANUP",
		"DECCANCE",
		"DWARKESH",
		"BALAJITELE",
		"HARITASEAT",
		"NATHBIOGEN",
		"KABRAEXTRU",
		"VSSL",
		"VHL",
		"NELCAST",
		"MUNJALSHOW",
		"RGL",
		"CENTENKA",
		"KOKUYOCMLN",
		"RIIL",
		"MIRZAINT",
		"PATELENG",
		"NSIL",
		"EXPLEOSOL",
		"MUNJALAU",
		"RAMKY",
		"APCL",
		"UNIDT",
		"TWL",
		"GAYAPROJ",
		"EBIXFOREX",
		"SHALPAINTS",
		"BALAXI",
		"ORIENTPPR",
		"ARMANFIN",
		"RML",
		"AMBIKCO",
		"SALASAR",
		"TFCILTD",
		"JAYBARMARU",
		"INDRAMEDCO",
		"DHFL",
		"SANDESH",
		"CENTUM",
		"SUULD",
		"HTMEDIA",
		"ALLSEC",
		"NBIFIN",
		"RICOAUTO",
		"STEELXIND",
		"THEINVEST",
		"RCOM",
		"MONTECARLO",
		"NAVKARCORP",
		"BINDALAGRO",
		"TDPOWERSYS",
		"MANINDS",
		"KOPRAN",
		"NITINSPIN",
		"LINCOLN",
		"EVERESTIND",
		"PRECWIRE",
		"SATIN",
		"STCINDIA",
		"ASIANTILES",
		"VISHWARAJ",
		"HMVL",
		"RSWM",
		"TNPETRO",
		"UNIVCABLES",
		"SANGHVIMOV",
		"SORILINFRA",
		"HITECH",
		"GULPOLY",
		"UNITECH",
		"NELCO",
		"V2RETAIL",
		"INDSWFTLAB",
		"REPRO",
		"SHREEPUSHK",
		"BCG",
		"AJMERA",
		"NECLIFE",
		"BLKASHYAP",
		"RUSHIL",
		"TBZ",
		"THEJO",
		"HEXATRADEX",
		"JAYAGROGN",
		"ADORWELD",
		"PILITA",
		"MADRASFERT",
		"ORIENTHOT",
		"TCPLPACK",
		"SRHHYPOLTD",
		"JAIBALAJI",
		"NRAIL",
		"KANORICHEM",
		"MAHEPC",
		"CONTROLPR",
		"SPAL",
		"ATULAUTO",
		"HINDCOMPOS",
		"SHRIRAMEPC",
		"KAYA",
		"ROSSELLIND",
		"ZUARI",
		"ASAHISONG",
		"IFBAGRO",
		"SAKSOFT",
		"PRECAM",
		"NAGAFERT",
		"NAHARSPING",
		"KAMDHENU",
		"DHANBANK",
		"DLINKINDIA",
		"PARSVNATH",
		"SCHAND",
		"PGIL",
		"AVADHSUGAR",
		"SASTASUNDR",
		"TI",
		"NDTV",
		"HLVLTD",
		"FEL",
		"DICIND",
		"JASH",
		"VIMTALABS",
		"HERCULES",
		"XELPMOC",
		"AKASH",
		"GALLANTT",
		"VIPULLTD",
		"REPL",
		"SREEL",
		"GANDHITUBE",
		"INFOBEAN",
		"UTTAMSUGAR",
		"DVL",
		"MAXIND",
		"ARVSMART",
		"ZOTA",
		"VENUSREM",
		"VISHNU",
		"ZEELEARN",
		"GOKEX",
		"KDDL",
		"CYBERTECH",
		"URJA",
		"MANAKSIA",
		"VASCONEQ",
		"BAFNAPH",
		"BIRLATYRE",
		"VERTOZ",
		"GENESYS",
		"HITECHGEAR",
		"SANGAMIND",
		"63MOONS",
		"VLSFINANCE",
		"BGRENERGY",
		"AURIONPRO",
		"HPL",
		"UCALFUEL",
		"MIRCELECTR",
		"SWELECTES",
		"PPL",
		"ASHIMASYN",
		"ZEEMEDIA",
		"MENONBE",
		"GKWLIMITED",
		"VARDHACRLC",
		"ORIENTBELL",
		"GSCLCEMENT",
		"HCL-INSYS",
		"ARTEMISMED",
		"MEP",
		"HINDNATGLS",
		"MARATHON",
		"MSPL",
		"ORICONENT",
		"JUBLINDS",
		"CUPID",
		"FSC",
		"PPAP",
		"RUBYMILLS",
		"GANESHHOUC",
		"NAHARPOLY",
		"RELCAPITAL",
		"GOKULAGRO",
		"NIPPOBATRY",
		"KHADIM",
		"ADVANIHOTR",
		"AHLWEST",
		"DPABHUSHAN",
		"JINDRILL",
		"BCLIND",
		"THEMISMED",
		"GUJAPOLLO",
		"HARRMALAYA",
		"PTL",
		"CHEMBOND",
		"PROZONINTU",
		"SREINFRA",
		"GOACARBON",
		"TALBROAUTO",
		"ORIENTABRA",
		"INVENTURE",
		"RAMANEWS",
		"MCL",
		"LASA",
		"CREST",
		"BRNL",
		"EROSMEDIA",
		"MODIRUBBER",
		"WALCHANNAG",
		"TVSELECT",
		"CAREERP",
		"ZUARIGLOB",
		"SECURKLOUD",
		"KRISHANA",
		"AYMSYNTEX",
		"PENIND",
		"BIRLAMONEY",
		"PDMJEPAPER",
		"KOTARISUG",
		"ALANKIT",
		"PENINLAND",
		"GIRRESORTS",
		"HDIL",
		"LINCPEN",
		"JPINFRATEC",
		"VETO",
		"MAHESHWARI",
		"ADSL",
		"RNAVAL",
		"TRIL",
		"OMINFRAL",
		"LIBERTSHOE",
		"MMP",
		"MBAPL",
		"ALBERTDAVD",
		"BRFL",
		"VINYLINDIA",
		"PITTIENG",
		"KHAICHEM",
		"HITECHCORP",
		"GEECEE",
		"SDBL",
		"SPTL",
		"JAGSNPHARM",
		"ZODIACLOTH",
		"MBLINFRA",
		"BIL",
		"KANPRPLA",
		"SILINV",
		"WANBURY",
		"SINTERCOM",
		"SELAN",
		"SARLAPOLY",
		"SINTEX",
		"PODDARMENT",
		"MCLEODRUSS",
		"WINDMACHIN",
		"UFO",
		"HIRECT",
		"REFEX",
		"SALZERELEC",
		"VIKASMCORP",
		"UGARSUGAR",
		"AIRAN",
		"EIMCOELECO",
		"BASML",
		"EIFFL",
		"JAYSREETEA",
		"ASTRON",
		"TRIGYN",
		"AKSHARCHEM",
		"APOLLO",
		"KOTHARIPRO",
		"MAJESCO",
		"STARPAPER",
		"SETCO",
		"ONWARDTEC",
		"GENCON",
		"CONSOFINVT",
		"GULFPETRO",
		"SHIVATEX",
		"GENUSPAPER",
		"AHLEAST",
		"BIRLACABLE",
		"MAZDA",
		"DTIL",
		"SHIVAMAUTO",
		"GOKUL",
		"SPECIALITY",
		"CHEMFAB",
		"INSPIRISYS",
		"SHEMAROO",
		"SAKAR",
		"RANEENGINE",
		"NAHARINDUS",
		"NAHARCAP",
		"SIMPLEXINF",
		"UNIVPHOTO",
		"ROHLTD",
		"ABAN",
		"BANSWRAS",
		"NILAINFRA",
		"KREBSBIO",
		"KCPSUGIND",
		"RAJTV",
		"NIRAJ",
		"PREMEXPLN",
		"AGARIND",
		"DHUNINV",
		"BBTCL",
		"ESSARSHPNG",
		"EMKAY",
		"DCMNVL",
		"MANGALAM",
		"ANDHRACEMT",
		"ISMTLTD",
		"GREENPOWER",
		"ORBTEXP",
		"BIGBLOC",
		"SHREYAS",
		"MANAKSTEEL",
		"DONEAR",
		"CAPTRUST",
		"BHARATWIRE",
		"KOTHARIPET",
		"3RDROCK",
		"GOODLUCK",
		"TIL",
		"WELINV",
		"BROOKS",
		"STEL",
		"NDL",
		"PARACABLES",
		"RUCHIRA",
		"AXISCADES",
		"ASPINWALL",
		"SOUTHWEST",
		"UNITEDTEA",
		"SMSLIFE",
		"EMMBI",
		"RANASUG",
		"APOLSINHOT",
		"BSHSL",
		"ARIHANTSUP",
		"IRISDOREME",
		"DPWIRES",
		"REVATHI",
		"RKEC",
		"PIONDIST",
		"MAGADSUGAR",
		"ELECTHERM",
		"SHREYANIND",
		"MAWANASUG",
		"BHAGYANGR",
		"HINDMOTORS",
		"NITCO",
		"SUNDRMBRAK",
		"GINNIFILA",
		"VIDEOIND",
		"OSWALAGRO",
		"CEBBCO",
		"BALLARPUR",
		"SUPERHOUSE",
		"MBECL",
		"WEALTH",
		"MARALOVER",
		"VIVIMEDLAB",
		"EMKAYTOOLS",
		"DENORA",
		"ROML",
		"ELGIRUBCO",
		"DANGEE",
		"WEBELSOLAR",
		"AAKASH",
		"KAKATCEM",
		"UMANGDAIRY",
		"PRECOT",
		"CLEDUCATE",
		"RPPINFRA",
		"JHS",
		"JOCIL",
		"PONNIERODE",
		"SIL",
		"IITL",
		"AUTOIND",
		"KILITCH",
		"INDTERRAIN",
		"20MICRONS",
		"JMTAUTOLTD",
		"SKMEGGPROD",
		"SEYAIND",
		"MAHASTEEL",
		"PASHUPATI",
		"LOVABLE",
		"JBFIND",
		"CREATIVE",
		"RUCHINFRA",
		"COMPINFO",
		"TPLPLASTEH",
		"PENTAGOLD",
		"IVC",
		"PODDARHOUS",
		"AHLADA",
		"RAMASTEEL",
		"TOUCHWOOD",
		"RHFL",
		"VIPCLOTHNG",
		"ASIANHOTNR",
		"SHYAMCENT",
		"BETA",
		"MGEL",
		"MOLDTECH",
		"TCIDEVELOP",
		"SHRENIK",
		"DRCSYSTEMS",
		"ALPHAGEO",
		"SAKUMA",
		"SAKHTISUG",
		"NOIDATOLL",
		"NDRAUTO",
		"SMARTLINK",
		"HUBTOWN",
		"BPL",
		"FCSSOFT",
		"EMAMIREAL",
		"DRSDILIP",
		"PRIMESECU",
		"UTTAMSTL",
		"RAJMET",
		"DEEPENR",
		"SILVERTUC",
		"KMSUGAR",
		"BIOFILCHEM",
		"MINDTECK",
		"GRPLTD",
		"GPTINFRA",
		"DUCON",
		"PIONEEREMB",
		"ICEMAKE",
		"MAANALU",
		"KSOLVES",
		"LSIL",
		"PRAXIS",
		"INNOVANA",
		"PAVNAIND",
		"MURUDCERA",
		"ARIES",
		"IVP",
		"KAPSTON",
		"ISFT",
		"SOFTTECH",
		"TEMBO",
		"TTL",
		"RVHL",
		"SPLIL",
		"MOTOGENFIN",
		"ARROWGREEN",
		"TRF",
		"GROBTEA",
		"MAHAPEXLTD",
		"ANSALAPI",
		"PALREDTEC",
		"BHAGYAPROP",
		"RPPL",
		"INDOTECH",
		"MACPOWER",
		"PANSARI",
		"AMJLAND",
		"LGBFORGE",
		"ADHUNIKIND",
		"GSS",
		"SIGIND",
		"CINELINE",
		"GILLANDERS",
		"OPTOCIRCUI",
		"AKSHOPTFBR",
		"CORALFINAC",
		"OMAXAUTO",
		"XPROINDIA",
		"SPECTRUM",
		"LOTUSEYE",
		"JINDALPHOT",
		"OSIAHYPER",
		"KERNEX",
		"GTL",
		"KECL",
		"REMSONSIND",
		"GEEKAYWIRE",
		"URAVI",
		"SVLL",
		"INDIANCARD",
		"ORIENTLTD",
		"MANAKCOAT",
		"ALMONDZ",
		"AARVI",
		"INDOSOLAR",
		"PAR",
		"BALPHARMA",
		"WORTH",
		"ALPA",
		"ACCURACY",
		"WEIZMANIND",
		"VISASTEEL",
		"HOVS",
		"LYKALABS",
		"SHIVAUM",
		"PREMIERPOL",
		"SITINET",
		"NDGL",
		"BYKE",
		"JMA",
		"TEXMOPIPES",
		"KALYANIFRG",
		"INTENTECH",
		"AKG",
		"GOLDENTOBC",
		"COMPUSOFT",
		"KAMATHOTEL",
		"IL&FSTRANS",
		"LCCINFOTEC",
		"PANACHE",
		"FMNL",
		"DSSL",
		"ABMINTLTD",
		"PKTEA",
		"BHARATGEAR",
		"SUPREMEENG",
		"IZMO",
		"CCHHL",
		"TOKYOPLAST",
		"A2ZINFRA",
		"GAMMNINFRA",
		"MAHICKRA",
		"KRITIKA",
		"ARCHIDPLY",
		"MUKTAARTS",
		"CMICABLES",
		"LIBAS",
		"VIKASECO",
		"AROGRANITE",
		"AUSOMENT",
		"TOTAL",
		"DEVIT",
		"RSSOFTWARE",
		"BANKA",
		"SONAMCLOCK",
		"ARVEE",
		"HISARMETAL",
		"SICAL",
		"SRPL",
		"PNC",
		"SHREERAMA",
		"GANGESSECU",
		"GOENKA",
		"BDR",
		"SILGO",
		"TARMAT",
		"MCDHOLDING",
		"JAKHARIA",
		"AARON",
		"SICAGEN",
		"PARIN",
		"SUNDARAM",
		"MANAKALUCO",
		"ROLLT",
		"E2E",
		"LOKESHMACH",
		"INDBANK",
		"DAMODARIND",
		"SURANAT&P",
		"INDOTHAI",
		"IMAGICAA",
		"SAGARDEEP",
		"SKIL",
		"MITCON",
		"WFL",
		"AVG",
		"SARVESHWAR",
		"PRAENG",
		"GLOBALVECT",
		"ROLTA",
		"ATLANTA",
		"JYOTISTRUC",
		"MOKSH",
		"TAINWALCHM",
		"NILASPACES",
		"STEELCITY",
		"ASAL",
		"GODHA",
		"MORARJEE",
		"CORDSCABLE",
		"WIPL",
		"ALKALI",
		"LAMBODHARA",
		"PRESSMN",
		"PUNJLLOYD",
		"CTE",
		"FLEXITUFF",
		"RAJSREESUG",
		"GLOBE",
		"BEDMUTHA",
		"SALONA",
		"SURYALAXMI",
		"UJAAS",
		"NITIRAJ",
		"HPIL",
		"SUMEETINDS",
		"PALASHSECU",
		"TERASOFT",
		"OSWALSEEDS",
		"MRO-TEK",
		"MRO",
		"MTEDUCARE",
		"NIBL",
		"GANGAFORGE",
		"DCM",
		"TARACHAND",
		"SURANASOL",
		"MALUPAPER",
		"MHHL",
		"SHRADHA",
		"UNIVASTU",
		"ARSSINFRA",
		"MADHAV",
		"MEGASOFT",
		"TIRUPATI",
		"ENERGYDEV",
		"DGCONTENT",
		"CNOVAPETRO",
		"AARVEEDEN",
		"PATINTLOG",
		"KANANIIND",
		"BAGFILMS",
		"AIROLAM",
		"SANWARIA",
		"NECCLTD",
		"ANIKINDS",
		"ARTNIRMAN",
		"BVCL",
		"SHAIVAL",
		"VARDMNPOLY",
		"SAMBHAAV",
		"IL&FSENGG",
		"ZENITHEXPO",
		"KEYFINSERV",
		"MDL",
		"KHFM",
		"SERVOTECH",
		"GLOBAL",
		"MADHUCON",
		"SHIVAMILLS",
		"BANG",
		"AAATECH",
		"SOMICONVEY",
		"SPMLINFRA",
		"MANUGRAPH",
		"KRIDHANINF",
		"TREJHARA",
		"VAISHALI",
		"DELTAMAGNT",
		"CINEVISTA",
		"ARCHIES",
		"ASCOM",
		"CENTEXT",
		"LGHL",
		"BSL",
		"INDOWIND",
		"BLBLIMITED",
		"AMDIND",
		"SANGINITA",
		"MKPL",
		"AISL",
		"BANARBEADS",
		"BHANDARI",
		"ONEPOINT",
		"VINNY",
		"BCONCEPTS",
		"ANSALHSG",
		"TREEHOUSE",
		"AJOONI",
		"GAL",
		"DBSTOCKBRO",
		"VASWANI",
		"LATTEYS",
		"EDUCOMP",
		"SIMBHALS",
		"SUMIT",
		"UNITEDPOLY",
		"TIRUPATIFL",
		"GIRIRAJ",
		"SANGHVIFOR",
		"DCI",
		"SIKKO",
		"PIGL",
		"AURDIS",
		"BEARDSELL",
		"TMRVL",
		"CELEBRITY",
		"VCL",
		"SALSTEEL",
		"UCL",
		"LPDC",
		"SHANTI",
		"LAGNAM",
		"KGL",
		"NANDANI",
		"LFIC",
		"ORTINLAB",
		"GUJRAFFIA",
		"HINDCON",
		"OILCOUNTUB",
		"LEXUS",
		"PRITI",
		"RELIABLE",
		"KEERTI",
		"FOCUS",
		"CUBEXTUB",
		"MERCATOR",
		"HECPROJECT",
		"OMKARCHEM",
		"BRIGHT",
		"AGROPHOS",
		"PEARLPOLY",
		"GOLDSTAR",
		"NEXTMEDIA",
		"AMBANIORG",
		"FELIX",
		"HUSYSLTD",
		"SUPERSPIN",
		"EXCEL",
		"SGL",
		"METALFORGE",
		"DHARSUGAR",
		"MANGTIMBER",
		"BALKRISHNA",
		"TIMESGTY",
		"KSHITIJPOL",
		"UNIINFO",
		"PROLIFE",
		"ZODIAC",
		"VIVIDHA",
		"ROHITFERRO",
		"JITFINFRA",
		"DIAPOWER",
		"SONAHISONA",
		"MMNL",
		"MUKANDENGG",
		"RMCL",
		"WILLAMAGOR",
		"COX&KINGS",
		"MILTON",
		"NAGREEKEXP",
		"SILLYMONKS",
		"SOMATEX",
		"TIJARIA",
		"SEZAL",
		"MAGNUM",
		"AGRITECH",
		"JETFREIGHT",
		"SIGMA",
		"BURNPUR",
		"AVSL",
		"RKDL",
		"LAXMICOT",
		"MARSHALL",
		"ORIENTALTL",
		"KHANDSE",
		"SOLEX",
		"WSI",
		"ATALREAL",
		"SHAHALLOYS",
		"KKVAPOW",
		"ASLIND",
		"GOLDTECH",
		"NATNLSTEEL",
		"GICL",
		"VSCL",
		"NITINFIRE",
		"VERA",
		"ADROITINFO",
		"UWCSL",
		"KARMAENG",
		"SEPOWER",
		"SURANI",
		"ADL",
		"COUNCODOS",
		"SRIRAM",
		"3PLAND",
		"INNOVATIVE",
		"INFOMEDIA",
		"ARIHANT",
		"PATSPINLTD",
		"21STCENMGM",
		"MIC",
		"CADSYS",
		"ANKITMETAL",
		"PRAKASHSTL",
		"RMDRIP",
		"WEWIN",
		"SPYL",
		"NARMADA",
		"NKIND",
		"MOHITIND",
		"GAYAHWS",
		"SSINFRA",
		"CALSOFT",
		"LYPSAGEMS",
		"ZODJRDMKJ",
		"S&SPOWER",
		"TGBHOTELS",
		"AVROIND",
		"CYBERMEDIA",
		"HBSL",
		"EASTSILK",
		"SHUBHLAXMI",
		"MITTAL",
		"INDLMETER",
		"PARTYCRUS",
		"HILTON",
		"CASTEXTECH",
		"EMCO",
		"AHIMSA",
		"HAVISHA",
		"CANDC",
		"BTML",
		"TNTELE",
		"PERFECT",
		"MOHOTAIND",
		"UNITY",
		"SETUINFRA",
		"MASKINVEST",
		"ACEINTEG",
		"SECL",
		"ZENITHSTL",
		"SYNCOM",
		"CROWN",
		"DALALSTCOM",
		"UMESLTD",
		"ABINFRA",
		"IMPEXFERRO",
		"TVVISION",
		"VICEROY",
		"PAEL",
		"ABNINT",
		"EASUNREYRL",
		"BSELINFRA",
		"DNAMEDIA",
		"SKSTEXTILE",
		"BARTRONICS",
		"SANCO",
		"ONELIFECAP",
		"PREMIER",
		"NAGREEKCAP",
		"CMMIPL",
		"JETKNIT",
		"MPTODAY",
		"EUROTEXIND",
		"MINDPOOL",
		"THIRUSUGAR",
		"RAJRAYON",
		"ALPSINDUS",
		"NORBTEAEXP",
		"GLFL",
		"SPENTEX",
		"NIRAJISPAT",
		"DSML",
		"SECURCRED",
		"AMJUMBO",
		"SUBCAPCITY",
		"ACCORD",
		"OMFURN",
		"GTNTEX",
		"GFSTEELS",
		"CONTI",
		"TCIFINANCE",
		"KALYANI",
		"TFL",
		"CREATIVEYE",
		"VIJIFIN",
		"KAUSHALYA",
		"BKMINDST",
		"JALAN",
		"PULZ",
		"DRL",
		"TANTIACONS",
		"TRANSWIND",
		"SONISOYA",
		"BHALCHANDR",
		"GRETEX",
		"TECHIN",
		"RADAAN",
		"SMVD",
		"LAKPRE",
		"EUROCERA",
		"NTL",
		"RAMSARUP",
		"MANAV",
		"ARENTERP",
		"POWERFUL",
		"VASA",
		"JIKIND",
		"THOMASCOTT",
		"MELSTAR",
		"ORTEL",
		"BOHRA",
		"GBGLOBAL",
		"DCMFINSERV",
		"GISOLUTION",
		"JAINSTUDIO",
		"HOTELRUGBY",
		"SABEVENTS",
		"BLUECHIP",
		"ABHISHEK",
		"AIFL",
		"ALCHEM",
		"AMBICAAGAR",
		"AMTEKAUTO",
		"ANTGRAPHIC",
		"ARCOTECH",
		"ASIL",
		"ATCOM",
		"ATLASCYCLE",
		"ATNINTER",
		"AUSTRAL",
		"AUTOLITIND",
		"BGLOBAL",
		"BHARATIDIL",
		"BILENERGY",
		"BINANIIND",
		"BLUEBLENDS",
		"BLUECOAST",
		"CCCL",
		"CELESTIAL",
		"CHROMATIC",
		"CKFSL",
		"COFFEEDAY",
		"CURATECH",
		"DIGJAMLTD",
		"DOLPHINOFF",
		"DQE",
		"DSKULKARNI",
		"EASTSUGIND",
		"EON",
		"ESSDEE",
		"EUROMULTI",
		"FEDDERELEC",
		"GAMMONIND",
		"GANGOTRI",
		"GITANJALI",
		"GUJNRECOKE",
		"GVKPIL",
		"HIGHGROUND",
		"HINDSYNTEX",
		"ICDSLTD",
		"ICSA",
		"INDSWFTLTD",
		"INTEGRA",
		"IVRCLINFRA",
		"JAIHINDPRO",
		"JINDCOT",
		"JPOLYINVST",
		"JVLAGRO",
		"KAVVERITEL",
		"KHAITANLTD",
		"KOHINOOR",
		"KSERASERA",
		"KSK",
		"KWALITY",
		"LAKSHMIEFL",
		"LEEL",
		"MAFATLAFIN",
		"MANPASAND",
		"METKORE",
		"MODTHREAD",
		"MVL",
		"NAKODA",
		"NOESISIND",
		"NUTEK",
		"OISL",
		"PARABDRUGS",
		"PARASPETRO",
		"PBAINFRA",
		"PDPL",
		"PETRONENGG",
		"PINCON",
		"PRADIP",
		"PRATIBHA",
		"PROSEED",
		"PRUDMOULI",
		"PSL",
		"PVP",
		"QUINTEGRA",
		"RAINBOWPAP",
		"RAJVIR",
		"REGENCERAM",
		"RMMIL",
		"RUSHABEAR",
		"SABTN",
		"SATHAISPAT",
		"SBIHOMEFIN",
		"SELMCL",
		"SHARONBIO",
		"SHIRPUR-G",
		"SHLAKSHMI",
		"SHYAMTEL",
		"SIMPLEX",
		"SITASHREE",
		"SMPL",
		"SPCENET",
		"SRSLTD",
		"STAMPEDE",
		"STERLINBIO",
		"STINDIA",
		"SUJANAUNI",
		"SUPREMEINF",
		"TALWALKARS",
		"TALWGYM",
		"TARAPUR",
		"TECHNOFAB",
		"TECILCHEM",
		"TULSI",
		"UNIPLY",
		"VALECHAENG",
		"VALUEIND",
		"VIMALOIL",
		"VISESHINFO",
		"VISUINTL",
		"WINSOME",
		"XLENERGY",
		"ZICOM",
		"SIIL",
		"OPAL",
		"FIVECORE",
		"PUSHPREALM",
		"CKPLEISURE",
		"CKPPRODUCT",
		"FOURTHDIM",
		"ARTEDZ",
		"BANSAL"
};



}
