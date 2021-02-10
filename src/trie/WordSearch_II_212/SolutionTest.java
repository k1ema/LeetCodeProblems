package trie.WordSearch_II_212;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new Solution_I()),
                Arguments.of(new Solution_II()),
                Arguments.of(new SolutionHashMap())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(Solution s) {
        char[][] board = new char[][] {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        assertEquals(Arrays.asList("oath", "eat"), s.findWords(board, new String[] {"oath", "pea", "eat", "rain"}));
        assertEquals(Collections.singletonList("a"), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"a"}));
        assertEquals(new ArrayList<>(), s.findWords(new char[][] {{'a', 'a'}}, new String[] {"aaa"}));

        board = new char[][] {{'a', 'b'}, {'c', 'd'}};
        List<String> words = s.findWords(board, new String[] {"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"});
        words.sort(String::compareTo);
        assertEquals(Arrays.asList("ab", "ac", "bd", "ca", "db"), words);

        board = new char[][] {
                {'s', 'e', 'e', 'n', 'e', 'w'},
                {'t', 'm', 'r', 'i', 'v', 'a'},
                {'o', 'b', 's', 'i', 'b', 'd'},
                {'w', 'm', 'y', 's', 'e', 'n'},
                {'l', 't', 's', 'n', 's', 'a'},
                {'i', 'e', 'z', 'l', 'g', 'n'}};
        words = s.findWords(board, new String[] {"anda", "anes", "anesis", "avener", "avine", "bena", "bend", "benda", "besa", "besan", "bowl", "daven", "embow", "inerm", "irene", "myst", "nane", "nanes", "neem", "reem", "reest", "renew", "rine", "riva", "rive", "riven", "sand", "sane", "sang", "seen", "seer", "send", "sise", "stob", "stow", "teil", "vine", "viner", "vire", "wadna", "wave", "wene", "wots", "pluma", "holm", "lippen", "trag", "milla", "bietle", "upbind", "waxy", "knead", "nickle", "reem", "skice", "unde", "hain", "savant", "tryt", "ribose", "niton", "lysis", "bedad", "sindry", "themis", "blushy", "cocket", "tube", "craps", "clavel", "towhee", "ogeed", "gloss", "goes", "bena", "mayhap", "shor", "grief", "agria", "debosh", "rimmed", "unlent", "whenas", "planky", "dormer", "yati", "rang", "duer", "yigh", "deasil", "diwata", "indic", "puerer", "levers", "fusser", "verre", "rutile", "erical", "batata", "swager", "pudgy", "sputa", "alite", "bummer", "velum", "infamy", "ngai", "unfed", "bulger", "wharve", "dipole", "sorter", "pily", "chatty", "yapok", "womble", "liana", "parch", "speltz", "cyan", "limose", "noggin", "proker", "crayer", "ration", "tivy", "moyite", "beany", "fils", "riper", "jixie", "sink", "quit", "tupuna", "jetton", "genua", "stanno", "apace", "busine", "havers", "bedrip", "behorn", "uncake", "cystid", "grinch", "hexene", "fratch", "agama", "relift", "tillot", "plaint", "ropp", "anna", "chaos", "cytoma", "coost", "fitted", "kegler", "twin", "rimple", "armory", "uniced", "tubig", "trull", "glumly", "tutrix", "rhamn", "knelt", "astely", "colin", "clawk", "alar", "tower", "vealy", "yearn", "roter", "prase", "undub", "toozoo", "liter", "omelet", "taler", "curium", "bullet", "yday", "codol", "elute", "slight", "boopis", "lotto", "nagara", "riffle", "bustic", "shrug", "gunk", "syrma", "wrocht", "depose", "tramal", "tidley", "prof", "lacmus", "copse", "flosh", "whelky", "fifer", "needy", "wealth", "joyant", "uroxin", "carlet", "snarly", "lunged", "acetal", "kibosh", "unburn", "slimer", "elysia", "teagle", "chymic", "erept", "quince", "shin", "knoppy", "picudo", "chider", "gaspy", "stope", "drawly", "pigful", "unwarp", "sate", "nautch", "uphasp", "fluted", "pecht", "torpid", "childe", "inclip", "faints", "stela", "kuskus", "arcked", "repic", "kojang", "bigha", "lipoid", "owerby", "anadem", "lench", "ortiga", "astart", "slinky", "rubify", "wootz", "recure", "natch", "tiring", "skimp", "seck", "decay", "atria", "borax", "leeky", "auncel", "soary", "loir", "twinge", "pinto", "bemat", "bepuff", "odum", "uptorn", "frowy", "fother", "witful", "erenow", "cooker", "maddle", "okee", "leek", "hasky", "owght", "cnicin", "togate", "screve", "abac", "hustle", "packly", "tilt", "oscule", "nonary", "uranic", "sulka", "urheen", "rouncy", "gaze", "aril", "dint", "steep", "samp", "ferule", "cakey", "unlead", "drummy", "kelpy", "adati", "pawn", "cyanic", "corn", "caudle", "geyan", "danaid", "ayless", "acre", "secos", "yeld", "obole", "finely", "avowed", "tetard", "inflex", "sloke", "trice", "chaise", "nursle", "aldime", "whist", "waggly", "pilula", "loppy", "rignum", "groff", "rigsby", "istoke", "roughy", "bardo", "bijoux", "junker", "progne", "ninny", "wyss", "unhook", "lieve", "tibey", "rethaw", "corke", "stelar", "tirade", "earlet", "dried", "corach", "caroli", "decern", "congee", "stog", "arake", "braid", "plasma", "unwept", "maund", "kamahi", "pool", "local", "region", "sequa", "cuneus", "faster", "tung", "warly", "bosket", "museum", "rule", "basion", "iodate", "pommet", "shat", "cappy", "trail", "darbha", "scroop", "jarfly", "sirdar", "kulah", "ziffs", "thump", "galee", "melter", "padder", "odist", "comber", "apodia", "widdy", "priest", "manuma", "flob", "biaxal", "corbel", "sodden", "begash", "duress", "tenues", "bayman", "stases", "claro", "savage", "korero", "hurler", "routh", "civic", "flaser", "scurvy", "lather", "amla", "male", "tiara", "salted", "restir", "soap", "exhume", "embole", "keelie", "tera", "census", "tete", "folium", "dade", "quell", "grower", "phare", "bullan", "adrop", "athrob", "blurry", "cerous", "rosily", "heed", "finish", "anguis", "pizza", "mesad", "lief", "bebait", "matchy", "impoor", "needs", "prana", "tabret", "hoga", "gowk", "potash", "sileni", "cumene", "kahili", "thigh", "vortex", "fogy", "kuruma", "teeny", "naid", "unface", "linha", "aizle", "yender", "wolf", "deism", "bousy", "dink", "unboy", "toshly", "hebete", "ahura", "bowed", "porger", "gaol", "chasmy", "karree", "isopag", "bloody", "avail", "pinax", "slimy", "gamba", "arghel", "strung", "simmer", "smiler", "outlet", "gangly", "sialic", "hemine", "trophy", "excite", "tined", "bandar", "sprang", "kiwi", "winner", "unsack", "rupial", "swum", "censer", "borg", "retold", "ovular", "paal", "sware", "posh", "evade", "buffle", "plagal", "bottom", "amend", "swipy", "siss", "fixing", "anuran", "tinty", "weapon", "fogged", "sampan", "enring", "suade", "causey", "ferri", "upbrow", "jing", "rewove", "shield", "undaub", "cingle", "rebute", "dodd", "gaub", "scry", "cipo", "mantra", "huller", "boller", "baud", "diem", "rammer", "ruiner", "bardic", "ethyl", "pleion", "path", "burrow", "nutlet", "dital", "saxten", "assail", "minute", "berley", "labefy", "salema", "praxis", "entone", "ipecac", "holmic", "shita", "litas", "bemoil", "future", "defuse", "glom", "tilpah", "bisti", "skater", "typist", "carene", "nidget", "amply", "alveus", "salty", "crinet", "gourde", "saluki", "sextic", "xyrid", "likin", "refeed", "couper", "smaik", "vestee", "lactic", "croche", "figgle", "thunge", "tunner", "hill", "cooba", "tucuma", "casco", "copus", "beldam", "johnin", "soiled", "framea", "prose", "yeard", "sobeit", "nanism", "purply", "helper", "appeal", "mitten", "layery", "salon", "mitra", "rusine", "verser", "beluga", "moosa", "orate", "piemag", "attune", "rucker", "purfly", "freet", "simmon", "affine", "mardy", "stroam", "chia", "gynic", "saple", "serif", "bocce", "froze", "pilot", "arenae", "laney", "locum", "casbah", "awave", "armil", "escrow", "tetra", "unbelt", "mehari", "patten", "mome", "muscid", "wrang", "tundun", "sepad", "acetic", "afresh", "vealer", "raglin", "aloud", "pickle", "minuet", "retort", "murium", "arched", "punjum", "baylet", "brew", "holder", "slunk", "killas", "pomato", "penta", "hunger", "epocha", "damie", "scrod", "cannel", "belly", "monny", "gaum", "joker", "portly", "biurea", "eosin", "pint", "bumper", "koft", "hyrax", "sequin", "turn", "pilus", "fant", "advert", "unorn", "trolly", "minded", "toom", "wander", "unglad", "tweest", "elenge", "magpie", "agon", "boatly", "propyl", "swelly", "know", "myal", "pika", "bewept", "karamu", "hemal", "pigdom", "averil", "parker", "mids", "awash", "cornea", "icing", "falsie", "necked", "darner", "shrend", "rondo", "exequy", "adlet", "craze", "sign", "angry", "salpa", "stoper", "percha", "kartel", "garsil", "unfill", "gunge", "behind", "revet", "garava", "faker", "corded", "sauf", "poemet", "whew", "tolsey", "sluer", "trichi", "devout", "lung", "skip", "boreal", "razzly", "athing", "atavus", "moutan", "steepy", "whir", "sucuri", "sinful", "turp", "ramper", "bassan", "wheaty", "vidry", "upturn", "gipon", "ashlar", "facund", "liber", "warful", "geoid", "palay", "jammy", "uptide", "mural", "gashes", "silty", "nunlet", "tergum", "form", "soggy", "aide", "upwrap", "fabled", "kosin", "claval", "quail", "rummy", "junket", "vility", "treat", "sniper", "graham", "cestus", "koruna", "corban", "clerid", "aimer", "alada", "wedge", "trainy", "eyedot", "banker", "plumb", "xoanon", "wankly", "chello", "cheet", "uncalk", "cutely", "aurar", "bilsh", "unram", "hart", "beday", "raser", "babloh", "ticken", "troy", "canto", "bodhi", "pavior", "depone", "pore", "argosy", "hanker", "sexern", "millet", "pelean", "resign", "chaya", "furred", "tiling", "titler", "ionone", "tinman", "induce", "forged", "hamfat", "incur", "hammam", "sannup", "loungy", "glib", "fikie", "evovae", "fusure", "modern", "dinkey", "lyric", "hawer", "sawney", "wabeno", "calx", "troco", "sexly", "tosh", "byhand", "meek", "unflat", "amli", "vocate", "chamal", "askant", "fleche", "repour", "myitis", "thwite", "merism", "pent", "enolic", "nomina", "curney", "rother", "cooser", "depas", "thread", "riden", "pyosis", "uparch", "elding", "cotoro", "akpek", "quern", "rami", "daggy", "flawn", "puller", "colove", "cage", "exode", "nignay", "brooky", "rocket", "glar", "quota", "wiser", "atony", "nodi", "utrubi", "amass", "yachan", "patao", "quag", "slag", "douser", "arear", "recut", "corky", "estre", "thief", "gloat", "redia", "pricky", "ligas", "chisel", "defier", "shower", "repen", "nakong", "indane", "tetric", "action", "redux", "gally", "suffer", "sutler", "croupe", "metage", "terap", "bemud", "smog", "draggy", "plyer", "dolor", "daggly", "wiss", "isopod", "puzzle", "deair", "anole", "bever", "goyle", "odored", "duro", "seity", "abkari", "kersey", "spurry", "ungaro", "idiom", "yercum", "pugman", "astern", "ouabe", "taenia", "eneugh", "doze", "doily", "mixy", "floury", "sadic", "plummy", "miter", "zebra", "rushen", "photon", "bespot", "agnate", "kados", "tinner", "outsin", "aloid", "dime", "labba", "arista", "cuffy", "synema", "gainer", "reader", "skybal", "dairi", "cavort", "wrote", "blowth", "vacoua", "serum", "gapo", "spunk", "melody", "hymner", "append", "alacha", "wreat", "crenel", "cawney", "uncoy", "soul", "bidri", "eigne", "heaps", "plodge", "toper", "aerugo", "ungirt", "ablach", "domnei", "cowl", "sold", "anneal", "cruels", "udell", "necker", "broch", "clips", "cern", "rani", "sory", "neiper", "adead", "cashew", "spanky", "salep", "prexy", "togue", "tedge", "motion", "troche", "unlean", "babu", "rizzom", "craber", "tonga", "hyssop", "jessur", "whealy", "tashie", "badian", "refine", "bondar", "adept", "runnet", "jumby", "latish", "strone", "topcap", "ovarin", "rerent", "mustee", "begin", "oblong", "lapon", "vowed", "downy", "sept", "tabled", "racily", "quench", "shauri", "monad", "reword", "stude", "keup", "tiding", "boyla", "blende", "rusot", "unwind", "flioma", "ductor", "stealy", "pedant", "silane", "swaggy", "pulu", "uneven", "choky", "eloge", "earcap", "descry", "tyken", "cubica", "dregs", "scye", "chiton", "murine", "hinge", "quatch", "giller", "screwy", "clamb", "flask", "avijja", "amobyr", "sant", "glossy", "outgo", "partly", "wekeen", "tiffle", "lith", "fulgid", "knar", "mucket", "pundum", "doucin", "neurin", "cost", "hatred", "alee", "submit", "uncite", "shekel", "seme", "pyrex", "scog", "emery", "dolose", "skrike", "fizzer", "cephid", "curtal", "bunce", "linden", "dorser", "valgus", "ahem", "ricker", "wingle", "morne", "kmet", "swinge", "razoo", "floey", "tuik", "reif", "cohol", "patrol", "seek", "berger", "youd", "ransom", "chrism", "coram", "impel", "glisk", "phene", "midge", "palpi", "leban", "tactic", "jotter", "dasher", "rouge", "rough", "owler", "pinnet", "cetene", "noop", "eyrir", "griffe", "murra", "whone", "caza", "hoop", "inrun", "jerry", "cowboy", "swanny", "deevey", "scoke", "feck", "telfer", "pinna", "boglet", "unrule", "pipery", "malati", "poked", "cyclar", "shive", "acrawl", "brotan", "linty", "infare", "bevel", "ilia", "gelada", "skeet", "jojoba", "sposhy", "angary", "ghetto", "inness", "chitak", "aint", "natron", "navew", "adular", "steri", "altho", "thyrse", "palmy", "notum", "lift", "arsis", "insect", "nifle", "venner", "flap", "poleax", "sarwan", "halter", "lily", "seizer", "ectal", "bhikku", "ahmadi", "enure", "mingle", "shrewd", "whilk", "dodder", "buaze", "helmed", "bilify", "muscly", "ungum", "sophy", "pilau", "starky", "razz", "marara", "remove", "awned", "scrime", "pituri", "gummed", "pured", "rozum", "garawi", "jantu", "toman", "unlust", "whame", "frenzy", "amphid", "pirr", "hookah", "punt", "nether", "ducted", "turner", "canaba", "sunray", "aghast", "lavish", "degum", "turps", "tutor", "diker", "feist", "skulk", "inturn", "pannel", "jarry", "nonage", "elcaja", "talky", "purser", "yinst", "sprit", "torso", "teerer", "never", "retrim", "calf", "undamn", "degger", "blank", "thir", "toric", "tear", "learn", "bewrap", "amelu", "cadger", "miasm", "gawm", "asimen", "unkept", "papal", "splet", "oord", "tatchy", "clod", "khaja", "kasbah", "unget", "when", "mock", "inset", "molman", "cayman", "oxyl", "cytula", "dairy", "besuit", "casaun", "spite", "upbear", "drivel", "porch", "deflex", "resene", "rusky", "potdar", "holily", "barth", "reins", "singe", "duel", "gravel", "justen", "regush", "chillo", "pacaya", "inning", "swayer", "esne", "indign", "bronc", "keto", "murex", "chico", "gris", "demos", "becalm", "hijack", "kilo", "boral", "sleek", "perry", "hack", "bate", "sodded", "radome", "puddle", "area", "pasha", "saved", "jacko", "kidney", "breek", "barker", "encup", "horror", "aching", "relock", "owlet", "wallet", "twenty", "momble", "ganch", "quin", "cork", "meta", "helio", "scarp", "newing", "unrove", "altun", "darst", "swedge", "cebur", "huggle", "daleth", "billot", "level", "bolly", "petary", "sope", "meller", "rogue", "tubboe", "willet", "yaird", "dreamt", "codman", "stooge", "elain", "singh", "lienic", "deltal", "window", "bleed", "snore", "gliosa", "cacao", "pretan", "scoury", "swanky", "nowt", "finnac", "nudge", "biller", "adays", "billed", "bourn", "imbue", "ginned", "couth", "flaith", "terna", "ignote", "morion", "anonym", "rebush", "writee", "housty", "capped", "huldee", "teufit", "weta", "turbid", "muss", "caliph", "pouch", "waled", "lobby", "issuer", "leger", "runic", "sindle", "outer", "paynim", "kafta", "rotor", "inion", "feru", "tade", "swep", "kerrie", "goosy", "sorbin", "poplin", "hazen", "saft", "mumper", "loyal", "replum", "blood", "dumba", "leden", "nobber", "flamed", "vinal", "dynast", "attest", "renin", "strub", "howish", "octet", "scamp", "narine", "canso", "capful", "tropic", "dasnt", "thrust", "antiar", "brauna", "bisque", "thetin", "smarm", "crance", "ephebe", "naric", "intone", "gannet", "vetch", "wrier", "roddin", "ektene", "nibbed", "jollop", "skere", "cyme", "bogan", "mikado", "plier", "strum", "benshi", "order", "bigamy", "guango", "resin", "coigue", "sepion", "wisht", "slod", "spume", "warty", "fascis", "unname", "toddle", "scutum", "uncowl", "sapor", "brin", "tutory", "jersey", "remop", "marbly", "stout", "bypast", "geodic", "pili", "manoc", "lapper", "lopper", "naily", "wels", "hetter", "recant", "bade", "ingrow", "glial", "spinae", "urosis", "leet", "coat", "grilse", "chevy", "stept", "oxamid", "garbel", "humbug", "bawley", "babe", "thiasi", "luster", "greed", "toller", "areach", "marry", "soot", "navar", "family", "tora", "cerris", "soffit", "woons", "koyan", "gavel", "ustion", "cowpea", "clysis", "oculus", "jobo", "sewage", "mayday", "prog", "throu", "nylast", "caupo", "contra", "snum", "stuboy", "sizy", "epacme", "mentum", "yeven", "soiree", "pfund", "weft", "york", "lade", "pobs", "sorroa", "dultie", "maypop", "jinni", "strit", "arzun", "mease", "trank", "blain", "narr", "frache", "naish", "foliot", "dowie", "roundy", "musico", "megilp", "exalt", "spiker", "tisar", "aliped", "dole", "henism", "kuei", "quits", "stosh", "yatter", "relive", "typer", "atocia", "horser", "impala", "cupful", "bite", "cypres", "axenic", "ceil", "resina", "yakin", "untomb", "wedged", "caress", "anotus", "tilty", "burnut", "implex", "hathi", "clee", "strany", "mandua", "unmad", "ablude", "facade", "pattee", "byre", "afret", "latigo", "skelf", "voiced", "joll", "furoin", "stingy", "moiler", "risper", "sitten", "realty", "coecum", "wraw", "decile", "snob", "amir", "unjoin", "anonol", "orenda", "poplar", "llyn", "mealer", "aleak", "yaje", "larin", "sight", "color", "togs", "lunare", "diarch", "galiot", "rebear", "bight", "tetel", "ayous", "vogue", "sensal", "tragus", "civet", "nazim", "turus", "pruh", "tolter", "reguli", "korrel", "zequin", "slade", "soldi", "pavage", "tagger", "snook", "haboob", "coetus", "copier", "unsole", "clover", "bogy", "obol", "liny", "khoka", "riding", "cyke", "suid", "derout", "cradge", "recrew", "trance", "gulfy", "iddat", "grume", "weld", "kenner", "nace", "assure", "odoom", "moud", "soup", "enrut", "chunk", "hading", "hobbly", "bluey", "covado", "intend", "diglot", "screw", "unhurt", "rewave", "jive", "rehoop", "fife", "zemni", "taper", "crowl", "uhllo", "apicad", "apert", "entomb", "vall", "pantie", "payday", "unbury", "begnaw", "upon", "charuk", "guppy", "mucago", "graze", "cogon", "cried", "undone", "ducato", "seah", "shrank", "rectus", "grame", "aumrie", "japan", "hedger", "cock", "thujyl", "dunst", "reefy", "silva", "labium", "nankin", "olid", "refind", "oxidic", "offset", "errant", "hirse", "sedum", "upcry", "arock", "ended", "telium", "nuncio", "kainyn", "howe", "turbot", "freath", "vorpal", "asideu", "coming", "gated", "tydie", "laced", "mining", "justo", "oily", "nolo", "deedy", "skippy", "paled", "creasy", "kissy", "cohort", "skeily", "lentor", "talcky", "whelk", "adunc", "didnt", "absent", "gyre", "tidily", "bisson", "have", "mowrah", "tern", "roll", "stop", "index", "oleous", "ranter", "potoo", "booty", "mowcht", "arcual", "varec", "outre", "orris", "ancon", "mist", "seven", "tiffy", "forum", "rachis", "murkly", "refilm", "beduck", "catch", "pasang", "outlip", "bacony", "kerat", "ehlite", "savola", "soar", "fount", "durrin", "lubra", "begall", "juloid", "satan", "urubu", "rebend", "loric", "adry", "wauf", "rocher", "loathe", "gelose", "enatic", "homo", "grid", "gape", "cipher", "vamped", "dawut", "tamanu", "gifted", "damner", "milter", "ormer", "baster", "leavy", "tsere", "trapes", "laiose", "haoma", "vang", "float", "glider", "tining", "rybat", "wagon", "kilerg", "hoast", "dupery", "knout", "ewer", "unsing", "pother", "surat", "preset", "bajada", "bemuse", "pillar", "aluta", "dorado", "stony", "reft", "morlop", "nolle", "sixer", "sensed", "wecht", "gerefa", "fora", "pahmi", "couch", "crunch", "loll", "didna", "shafty", "doigt", "cameo", "begoud", "striga", "toft", "suff", "lauder", "unroof", "polite", "peepy", "recent", "flea", "ecoid", "sallee", "jungle", "sloo", "cloam", "rovet", "pott", "daver", "these", "scrog", "adda", "pekin", "ecad", "alkool", "viver", "whats", "plat", "rootle", "marm", "dufter", "anoli", "simile", "skyway", "oocyte", "lochus", "looten", "armor", "germy", "foody", "reroof", "scribe", "smich", "stert", "areole", "otalgy", "alburn", "spoof", "letchy", "tapet", "tchast", "pfui", "toggle", "bander", "punily", "mines", "zogo", "doll", "ulster", "caecal", "isba", "barse", "palt", "kokio", "eyebar", "frivol", "stanza", "arbor", "lean", "cowish", "moop", "torta", "mysoid", "uropod", "drusy", "dogly", "reglue", "loosen", "tupara", "admire", "algous", "fondue", "randle", "vela", "joyful", "semola", "smirch", "casava", "citrin", "drift", "dampy", "infula", "lyrist", "pownie", "bedot", "plait", "gelder", "spryly", "malt", "mantel", "copist", "coil", "klam", "cynic", "ditty", "taqua", "pernor", "whort", "garget", "reeker", "jibber", "sendee", "absit", "cheven", "webeye", "hagged", "fagine", "sklate", "mitrer", "rime", "czaric", "apii", "stetch", "mout", "drib", "rewet", "trochi", "chaute", "cedary", "stowce", "bustle", "dinky", "mowra", "palea", "brief", "plushy", "indaba", "purana", "harbi", "boom", "koph", "jimp", "acider", "moose", "sloan", "felon", "quatre", "skirt", "none", "bonito", "myth", "godown", "swaird", "resect", "cumyl", "sneeze", "vowel", "cubdom", "objure", "oftest", "whilst", "vertex", "browst", "bota", "kamias", "miche", "usage", "teaey", "sedate", "stall", "skat", "apiose", "unmaze", "mosker", "wind", "unity", "photal", "leanly", "marco", "hiller", "cymule", "jure", "reesk", "staver", "worky", "cymar", "vinea", "pise", "enlief", "muscat", "jipper", "bench", "morn", "klosh", "etui", "stoup", "unsin", "tite", "pisk", "halite", "yomer", "minty", "loft", "lienee", "manul", "exit", "downer", "entail", "peda", "menial", "dorad", "haggy", "ruler", "carbon", "precut", "bushed", "goring", "moors", "thema", "shela", "paraph", "carga", "mart", "arson", "beagle", "neuron", "echea", "kenyte", "lunes", "sizz", "hing", "irisin", "sniff", "opiate", "ideaed", "lienor", "tutee", "germen", "narica", "limous", "chekan", "amadou", "fecund", "doughy", "typic", "wrig", "inch", "gangue", "clot", "dumple", "harden", "roding", "vervel", "depict", "salal", "ascoma", "anisil", "unnose", "rhesus", "runer", "ondy", "carob", "cerule", "poesie", "raiser", "dight", "kelper", "cult", "pudder", "comedo", "pardo", "homrai", "blash", "dobrao", "winly", "unself", "cytoid", "anyhow", "weigh", "joch", "octene", "resort", "figury", "turken", "graver", "rater", "jagla", "bred", "hoddy", "datary", "draff", "telang", "tunful", "furoid", "sphery", "wally", "attask", "gamy", "riband", "axed", "battel", "kaolin", "rool", "tither", "stupor", "hageen", "fully", "begob", "gormaw", "vive", "orgue", "creem", "defog", "stroup", "regin", "source", "bezel", "glover", "soleyn", "tickie", "urnful", "bestar", "glusid", "behint", "ocher", "atoll", "refont", "nuzzle", "behear", "satron", "squirr", "peso", "truvat", "thrice", "lupeol", "brock", "kukupa", "seroot", "rechip", "tice", "tilter", "havage", "enstar", "force", "topsl", "clype", "furil", "kharua", "holing", "pesade", "aurum", "acrid", "foam", "polypi", "baul", "uncome", "grind", "bilch", "awoke", "blanc", "foci", "crook", "blebby", "usward", "eaten", "aiming", "cubeb", "grimp", "vell", "kimnel", "ocuby", "whare", "fore", "budger", "subtly", "lathe", "throng", "pylic", "benzil", "balker", "huaco", "erect", "gather", "tawney", "ghost", "abash", "aery", "spader", "reim", "wolfer", "hakeem", "uvalha", "spry", "musket", "hunker", "woady", "anes", "recurl", "caviya", "acor", "dudine", "scute", "toity", "fanged", "bemole", "comedy", "cilice", "sisal", "murly", "serval", "stylet", "fainty", "burgoo", "heir", "tetch", "kirn", "virgal", "funded", "overdo", "height", "bekiss", "mosser", "drawk", "slided", "sprat", "friezy", "alop", "unto", "works", "valved", "ariose", "batino", "gusle", "cond", "probal", "easter", "kokum", "imbark", "bend", "phosis", "infirm", "benami", "fortin", "slete", "naigie", "sillar", "wrap", "oons", "oared", "mezzo", "wiring", "pycnia", "corsac", "prest", "unpeel", "shard", "retral", "trasy", "reheap", "citric", "drone", "knave", "slung", "oven", "bardie", "ulema", "lytta", "rokee", "talpid", "knew", "freed", "clang", "minny", "booted", "judex", "octyl", "septan", "reself", "jugale", "buffy", "bluish", "glor", "lark", "humbo", "quale", "varna", "bundy", "evoke", "scolia", "five", "bandy", "mone", "silker", "clicky", "citee", "pandle", "wambly", "besped", "kagu", "farleu", "vexful", "cloyer", "wandy", "manism", "searce", "atman", "rizzar", "acuate", "tuny", "tonant", "fondly", "huron", "choil", "queest", "smith", "akazga", "herder", "spurt", "mating", "queme", "apio", "pontal", "give", "ensky", "gluish", "royet", "unrust", "uptear", "flaunt", "gain", "wuzzle", "poucey", "rifty", "clag", "robbin", "shook", "jingal", "scum", "daze", "auride", "reply", "crying", "dire", "hure", "abbas", "rident", "crink", "upgang", "voet", "duplex", "ribber", "batten", "erbia", "cabble", "scull", "reseda", "aponia", "quirl", "furcal", "masked", "telial", "fieldy", "wangle", "evoker", "prima", "moujik", "eunuch", "upmove", "bassus", "clipse", "view", "sence", "nabob", "tepid", "kusa", "wabber", "croppy", "mower", "tronc", "ozone", "brogan", "aural", "sorty", "labra", "pickee", "caback", "ceruse", "russia", "suncup", "walnut", "daisy", "ethid", "coli", "ketch", "orchat", "nodder", "flatus", "sault", "inleak", "slippy", "orange", "quack", "pantle", "loofie", "fourth", "wham", "haymow", "tenrec", "unmesh", "honda", "sake", "mias", "ardor", "marish", "upmost", "potgun", "cadmic", "stive", "ashery", "aridly", "dodge", "splosh", "bargh", "streke", "waivod", "crisis", "inring", "belee", "nunni", "magi", "tooter", "dimmet", "dyne", "shamba", "sedgy", "enseem", "walsh", "aero", "dawtet", "stuber", "june", "flory", "fouler", "orgeat", "floret", "nixie", "redo", "ogamic", "caplin", "bier", "pholad", "pratey", "pattu", "frab", "podex", "lierre", "drung", "risp", "inblow", "echo", "sirree", "embind", "stern", "crania", "elater", "zamang", "apiece", "safari", "revue", "unshot", "staged", "godet", "basely", "snoove", "isobar", "flued", "touchy", "signet", "mucky", "mona", "unbolt", "thresh", "extine", "within", "fresco", "jarra", "deepen", "encell", "evenly", "assacu", "hour", "khan", "fylfot", "hafnyl", "dimer", "decad", "upgaze", "checky", "dame", "trews", "ungill", "pith", "paver", "pronpl", "tenson", "sextet", "snugly", "pack", "sedan", "sunlit", "extant", "parma", "tinkly", "unsalt", "bergy", "yurta", "whekau", "nibble", "pallor", "panter", "zonoid", "tatbeb", "bowker", "piper", "yoicks", "tekke", "slewed", "ashes", "shore", "wharp", "seth", "dive", "hunh", "kulm", "massoy", "poteen", "medlar", "testar", "elope", "nepote", "cusie", "arigue", "urluch", "awide", "sancho", "witney", "busky", "toffy", "rudely", "unzone", "primy", "teest", "foxily", "untile", "tummy", "abvolt", "katar", "cytase", "mado", "upsey", "enmesh", "asse", "depa", "toher", "laich", "gambol", "faring", "slitch", "groat", "amban", "urnal", "udal", "witter", "petit", "slad", "calved", "unfine", "unbusk", "unible", "coiny", "hevi", "inro", "sharny", "chegoe", "betail", "thill", "atabeg", "dunair", "thack", "sclere", "scopet", "flute", "guru", "crumen", "logion", "bozze", "exude", "motey", "ikey", "urari", "moyen", "coak", "unhang", "brayer", "forgo", "canaut", "player", "tholi", "rerope", "serran", "whip", "thenal", "deputy", "office", "salar", "bority", "whaler", "moot", "nutter", "feast", "dogdom", "tweeg", "outsum", "ritzy", "cleric", "crea", "quote", "bahar", "typica", "befriz", "richen", "nodous", "influx", "antic", "hereto", "bees", "coact", "scrawl", "coiler", "orpine", "daut", "crater", "evilly", "quet", "nais", "outing", "sister", "unshy", "cedent", "masha", "sprig", "weber", "jacent", "jockey", "gigolo", "urea", "abaca", "clawer", "ebony", "totty", "clonus", "ovisac", "cathro", "yether", "wilk", "bios", "podded", "shoji", "kyack", "snurt", "jocker", "hutch", "caulis", "vimen", "casket", "pundit", "waken", "retime", "cetic", "unclip", "tussis", "meteor", "slote", "cuddly", "inower", "mallee", "niche", "unipod", "gusty", "sane", "lendee", "pogrom", "ascare", "anion", "stymie", "mastic", "ruffin", "umbone", "daunch", "cloof", "brant", "unidly", "lances", "hooly", "zoaria", "tilth", "pirol", "pobby", "wive", "train", "rivery", "corona", "gaper", "guff", "bepill", "exoner", "strue", "tanked", "boza", "beeman", "usque", "pilule", "fise", "glaky", "bemolt", "aswail", "facing", "glomus", "smur", "notal", "crunk", "studia", "swarth", "skully", "broth", "invent", "sabzi", "queach", "tipful", "expert", "aboral", "popal", "taglet", "shan", "wooler", "skene", "skua", "fremd", "inanga", "hymn", "cope", "hooker", "bafaro", "subdue", "coryl", "towai", "disher", "unpale", "pooler", "striae", "ascent", "caama", "moray", "omlah", "pankin", "gyrant", "ursone", "ararao", "malter", "douce", "basalt", "cored", "rainer", "sireny", "grad", "mucin", "slump", "wanle", "fester", "torpor", "nabber", "undirk", "dinar", "dangle", "lava", "multum", "grove", "egesta", "invein", "chakra", "ortet", "spot", "rack", "pega", "scoad", "pavan", "bieldy", "gunsel", "occult", "hals", "tamp", "hider", "trog", "madefy", "pluff", "yoke", "knurly", "swampy", "precis", "buddle", "busby", "embay", "baker", "knell", "fennec", "unsewn", "frig", "palmus", "cathin", "stoma", "crayon", "resnap", "triple", "khoja", "sylvic", "tercel", "waker", "lucet", "pastor", "asyla", "pullen", "bedog", "kuttar", "sheaf", "squat", "desmid", "whiten", "folden", "fiscal", "smug", "uprose", "myall", "rennet", "idlish", "formyl", "whippy", "artlet", "tangie", "pinta", "rabbit", "lacto", "sadist", "leck", "golfer", "buddy", "dewer", "rodeo", "phoca", "amsath", "satin", "gorged", "khirka", "kapa", "pecket", "pollen", "foal", "augur", "oside", "chaser", "roke", "booker", "hovel", "manga", "cozen", "skuse", "oxlip", "gote", "puggy", "sweet", "yappy", "oulap", "fork", "umlaut", "jowery", "trock", "crux", "wheely", "zoonal", "biriba", "geodal", "fusil", "bussu", "jeff", "uvula", "fixer", "heaper", "autism", "genty", "bally", "ceibo", "atop", "twerp", "ranty", "lobfig", "sunt", "lask", "loxic", "stoep", "sprong", "unfew", "toby", "sorbic", "endoss", "dotard", "gonys", "apices", "houndy", "clinal", "foeish", "jibman", "gange", "exon", "iwaiwa", "odic", "retree", "iridal", "degust", "cauda", "turr", "hurroo", "teapoy", "bromic", "mothy", "amin", "rimose", "paean", "bardy", "testa", "eroded", "anorth", "meed", "bruzz", "pelt", "cupel", "turgid", "deport", "spilly", "teamer", "lull", "graphy", "relbun", "smethe", "rewrap", "fudgy", "joky", "feer", "brandy", "dull", "tropal", "relose", "brieve", "allene", "farina", "achill", "basal", "warve", "stuffy", "awning", "cuboid", "mender", "malo", "skyman", "volet", "morrow", "scun", "dulcet", "bafta", "gladii", "dinus", "histon", "coto", "sidder", "aquo", "mark", "sample", "perron", "perit", "pinker", "kozo", "fustet", "flaky", "isogen", "crum", "rappel", "enrapt", "alesan", "hodder", "bregma", "deface", "acate", "delft", "lilyfy", "cunner", "fare", "nidus", "opaque", "brog", "brumby", "prut", "ibices", "tinnet", "coof", "shilfa", "peeper", "create", "asdic", "maro", "atabek", "maim", "battik", "ding", "houser", "uresis", "kumhar", "soles", "pollex", "heal", "inter", "gnat", "ovate", "alive", "fluter", "singed", "puddy", "jaunty", "sapek", "dorlot", "artabe", "gawsie", "leaper", "buckie", "gulden", "wowt", "caffle", "clites"});
        words.sort(String::compareTo);
        assertEquals(Arrays.asList("anda", "anes", "anesis", "avener", "avine", "bena", "bend", "benda", "besa", "besan", "bowl", "daven", "embow", "inerm", "irene", "myst", "nane", "nanes", "neem", "reem", "reest", "renew", "rine", "riva", "rive", "riven", "sand", "sane", "sang", "seen", "seer", "send", "sise", "stob", "stow", "teil", "vine", "viner", "vire", "wadna", "wave", "wene", "wots"), words);
    }
}
