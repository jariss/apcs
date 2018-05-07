import java.util.ArrayList;


public class Dictionary {

    private String[] twoLetterWords;                            // 1-D array of Strings
    private String[][] threeLetterWords = new String[26][];        // 2-D staggered array of Strings
    private ArrayList<String> found = new ArrayList<String>();

    public Dictionary() {

        String twoLetterWordsString = "AA AB AD AE AG AH AI AL AM AN AR AS AT AW AX AY " +
                "BA BE BI BO BY DE DO ED EF EH EL EM EN ER ES ET EX FA GO HA HE HI " +
                "HM HO ID IF IN IS IT JO KA LA LI LO MA ME MI MM MO MU MY NA NE NO " +
                "NU OD OE OF OH OM ON OP OR OS OW OX OY PA PE PI RE SH SI SO TA TI " +
                "TO UH UM UN UP US UT WE WO XI XU YA YE YO ";

        twoLetterWords = twoLetterWordsString.split(" ");

        String[] threeLetterWordsString = new String[26];

        threeLetterWordsString[0] = "AAH AAL AAS ABA ABO ABS ABY ACE ACT ADD ADO ADS ADZ AFF AFT AGA AGE AGO AHA AID " +
                "AIL AIM AIN AIR AIS AIT ALA ALB ALE ALL ALP ALS ALT AMA AMI AMP AMU ANA AND ANE " +
                "ANI ANT ANY APE APT ARB ARC ARE ARF ARK ARM ARS ART ASH ASK ASP ASS ATE ATT AUK " +
                "AVA AVE AVO AWA AWE AWL AWN AXE AYE AYS AZO ";

        threeLetterWordsString[1] = "BAA BAD BAG BAH BAL BAM BAN BAP BAR BAS BAT BAY BED BEE BEG BEL BEN BET BEY BIB " +
                "BID BIG BIN BIO BIS BIT BIZ BOA BOB BOD BOG BOO BOP BOS BOT BOW BOX BOY BRA BRO " +
                "BRR BUB BUD BUG BUM BUN BUR BUS BUT BUY BYE BYS";

        threeLetterWordsString[2] = "CAB CAD CAM CAN CAP CAR CAT CAW CAY CEE CEL CEP CHI CIS COB COD COG COL CON COO " +
                "COP COR COS COT COW COX COY COZ CRY CUB CUD CUE CUM CUP CUR CUT CWM";

        threeLetterWordsString[3] = "DAB DAD DAG DAH DAK DAL DAM DAP DAW DAY DEB DEE DEL DEN DEV DEW DEX DEY DIB DID " +
                "DIE DIG DIM DIN DIP DIS DIT DOC DOE DOG DOL DOM DON DOR DOS DOT DOW DRY DUB DUD " +
                "DUE DUG DUI DUN DUO DUP DYE";

        threeLetterWordsString[4] = "EAR EAT EAU EBB ECU EDH EEL EFF EFS EFT EGG EGO EKE ELD ELF ELK ELL ELM ELS EME " +
                "EMF EMS EMU END ENG ENS EON ERA ERE ERG ERN ERR ERS ESS ETA ETH EVE EWE EYE";

        threeLetterWordsString[5] = "FAD FAG FAN FAR FAS FAT FAX FAY FED FEE FEH FEM FEN FER FET FEU FEW FEY FEZ FIB " +
                "FID FIE FIG FIL FIN FIR FIT FIX FIZ FLU FLY FOB FOE FOG FOH FON FOP FOR FOU FOX " +
                "FOY FRO FRY FUB FUD FUG FUN FUR";

        threeLetterWordsString[6] = "GAB GAD GAE GAG GAL GAM GAN GAP GAR GAS GAT GAY GED GEE GEL GEM GEN GET GEY GHI " +
                "GIB GID GIE GIG GIN GIP GIT GNU GOA GOB GOD GOO GOR GOT GOX GOY GUL GUM GUN GUT " +
                "GUV GUY GYM GYP";

        threeLetterWordsString[7] = "HAD HAE HAG HAH HAJ HAM HAO HAP HAS HAT HAW HAY HEH HEM HEN HEP HER HES HET HEW " +
                "HEX HEY HIC HID HIE HIM HIN HIP HIS HIT HMM HOB HOD HOE HOG HON HOP HOT HOW HOY " +
                "HUB HUE HUG HUH HUM HUN HUP HUT HYP";

        threeLetterWordsString[8] = "ICE ICH ICK ICY IDS IFF IFS ILK ILL IMP INK INN INS ION IRE IRK ISM ITS IVY";

        threeLetterWordsString[9] = "JAB JAG JAM JAR JAW JAY JEE JET JEU JEW JIB JIG JIN JOB JOE JOG JOT JOW JOY JUG " +
                "JUN JUS JUT";

        threeLetterWordsString[10] = "KAB KAE KAF KAS KAT KAY KEA KEF KEG KEN KEP KEX KEY KHI KID KIF KIN KIP KIR KIT " +
                "KOA KOB KOI KOP KOR KOS KUE";

        threeLetterWordsString[11] = "LAB LAC LAD LAG LAM LAP LAR LAS LAT LAV LAW LAX LAY LEA LED LEE LEG LEI LEK LET " +
                "LEU LEV LEX LEY LEZ LIB LID LIE LIN LIP LIS LIT LOB LOG LOO LOP LOT LOW LOX LUG " +
                "LUM LUV LUX LYE";

        threeLetterWordsString[12] = "MAC MAD MAE MAG MAN MAP MAR MAS MAT MAW MAX MAY MED MEL MEM MEN MET MEW MHO MIB " +
                "MID MIG MIL MIM MIR MIS MIX MOA MOB MOC MOD MOG MOL MOM MON MOO MOP MOR MOS MOT " +
                "MOW MUD MUG MUM MUN MUS MUT";

        threeLetterWordsString[13] = "NAB NAE NAG NAH NAM NAN NAP NAW NAY NEB NEE NET NEW NIB NIL NIM NIP NIT NIX NOB " +
                "NOD NOG NOH NOM NOO NOR NOS NOT NOW NTH NUB NUN NUS NUT";

        threeLetterWordsString[14] = "OAF OAK OAR OAT OBE OBI OCA ODD ODE ODS OES OFF OFT OHM OHO OHS OIL OKA OKE OLD " +
                "OLE OMS ONE ONS OOH OOT OPE OPS OPT ORA ORB ORC ORE ORS ORT OSE OUD OUR OUT OVA " +
                "OWE OWL OWN OXO OXY";

        threeLetterWordsString[15] = "PAC PAD PAH PAL PAM PAN PAP PAR PAS PAT PAW PAX PAY PEA PEC PED PEE PEG PEH PEN " +
                "PEP PER PES PET PEW PHI PHT PIA PIC PIE PIG PIN PIP PIS PIT PIU PIX PLY POD POH " +
                "POI POL POM POP POT POW POX PRO PRY PSI PUB PUD PUG PUL PUN PUP PUR PUS PUT PYA " +
                "PYE PYX";

        threeLetterWordsString[16] = "QAT QUA";

        threeLetterWordsString[17] = "RAD RAG RAH RAJ RAM RAN RAP RAS RAT RAW RAX RAY REB REC RED REE REF REG REI REM " +
                "REP RES RET REV REX RHO RIA RIB RID RIF RIG RIM RIN RIP ROB ROC ROD ROE ROM ROT " +
                "ROW RUB RUE RUG RUM RUN RUT RYA RYE";

        threeLetterWordsString[18] = "SAB SAC SAD SAE SAG SAL SAP SAT SAU SAW SAX SAY SEA SEC SEE SEG SEI SEL SEN SER " +
                "SET SEW SEX SHA SHE SHH SHY SIB SIC SIM SIN SIP SIR SIS SIT SIX SKA SKI SKY SLY " +
                "SOB SOD SOL SON SOP SOS SOT SOU SOW SOX SOY SPA SPY SRI STY SUB SUE SUM SUN SUP " +
                "SUQ SYN";

        threeLetterWordsString[19] = "TAB TAD TAE TAG TAJ TAM TAN TAO TAP TAR TAS TAT TAU TAV TAW TAX TEA TED TEE TEG " +
                "TEL TEN TET TEW THE THO THY TIC TIE TIL TIN TIP TIS TIT TOD TOE TOG TOM TON TOO " +
                "TOP TOR TOT TOW TOY TRY TSK TUB TUG TUI TUN TUP TUT TUX TWA TWO TYE";

        threeLetterWordsString[20] = "UDO UGH UKE ULU UMM UMP UNS UPO UPS URB URD URN USE UTA UTS";

        threeLetterWordsString[21] = "VAC VAN VAR VAS VAT VAU VAV VAW VEE VEG VET VEX VIA VIE VIG VIM VIS VOE VOW VOX VUG";

        threeLetterWordsString[22] = "WAB WAD WAE WAG WAN WAP WAR WAS WAT WAW WAX WAY WEB WED WEE WEN WET WHA WHO WHY " +
                "WIG WIN WIS WIT WIZ WOE WOG WOK WON WOO WOP WOS WOT WOW WRY WUD WYE WYN";

        threeLetterWordsString[23] = "XIS";

        threeLetterWordsString[24] = "YAH YAK YAM YAP YAR YAW YAY YEA YEH YEN YEP YES YET YEW YID YIN YIP YOB YOD YOK " +
                "YOM YON YOU YOW YUK YUM YUP";

        threeLetterWordsString[25] = "ZAG ZAP ZAX ZED ZEE ZEK ZIG ZIN ZIP ZIT ZOA ZOO";

        for (int i = 0; i < threeLetterWordsString.length; i++) {
            threeLetterWords[i] = threeLetterWordsString[i].split(" ");
        }
    }

    public ArrayList<String> findWords(String hand) {
        ArrayList<String> hands = new ArrayList<String>(hand.length());
        for (int a = 0; a < hand.length(); a++) {
            hands.add("" + hand.charAt(a));
        }
        for (int i = 0; i < hand.length(); i++) {
            for (int j = 0; j < hand.length(); j++) {
                if (i != j) {
                    String string = hand.substring(i, i + 1) + hand.substring(j, j + 1);
                    for (String validWord : twoLetterWords) {
                        if (validWord.equalsIgnoreCase(string)) {
                            found.add(string);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < hand.length(); i++) {
            for (int j = 0; j < hand.length(); j++) {
                if (i != j) {
                    for (int k = 0; k < hand.length(); k++) {
                        if (k != i && k != j) {
                            String[] validWords = sameThreeLetterWord(hand.charAt(i));
                            String letters = hand.substring(i, i + 1) + hand.substring(j, j + 1) + hand.substring(k, k + 1);
                            for (String validWord : validWords) {
                                if (validWord.equals(letters))
                                    found.add(letters);
                            }
                        }
                    }
                }
            }
        }
        return found;
    }

    private String[] sameThreeLetterWord(char input) {
        return threeLetterWords[input - 'A'];
    }

    public String[] getTwoLetterWords() {
        return twoLetterWords;
    }

    public String[][] getThreeLetterWords() {
        return threeLetterWords;
    }
}
