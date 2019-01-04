package jp.co.run.jperas.enums;

/**
 * The Enum Eras.
 * 
 * @author datnguyen
 */
public enum Eras {

    /** The all. */
    GREGORY("西暦", "西暦", -235251, 3416807, 1, 1),

    /** The heisei. */
    HEISEI("平成", "平成", 490858, 3416807, 1989, 1),

    /** The showa ii. */
    SHOWA_II("昭和", "昭和", 468198, 490857, 1926, 1),

    /** The taisho. */
    TAISHO("大正", "大正", 462937, 468198, 1912, 1),

    /** The meiji gregory. */
    MEIJI_GREGORY("明治", "明治(グレゴリオ暦)", 448483, 462937, 1868, 1),

    /** The meiji julius. */
    MEIJI_JULIUS("明治", "明治(旧暦)", 446952, 448482, 1, -1),

    /** The keio. */
    KEIO("慶応", "慶応", 445681, 446952, 1, -1),

    /** The genji. */
    GENJI("元治", "元治", 445281, 445681, 1, -1),

    /** The bunkyu. */
    BUNKYU("文久", "文久", 444187, 445281, 1, -1),

    /** The manei. */
    MANEI("万延", "万延", 443832, 444187, 1, -1),

    /** The ansei. */
    ANSEI("安政", "安政", 441922, 443832, 1, -1),

    /** The kaei. */
    KAEI("嘉永", "嘉永", 439442, 441922, 1, -1),

    /** The koka. */
    KOKA("弘化", "弘化", 438264, 439442, 1, -1),

    /** The tempo. */
    TEMPO("天保", "天保", 433164, 438264, 1, -1),

    /** The bunsei. */
    BUNSEI("文政", "文政", 428539, 433164, 1, -1),

    /** The bunka. */
    BUNKA("文化", "文化", 423361, 428539, 1, -1),

    /** The kyowa. */
    KYOWA("享和", "享和", 422262, 423361, 1, -1),

    /** The kansei. */
    KANSEI("寛政", "寛政", 417852, 422262, 1, -1),

    /** The temmei. */
    TEMMEI("天明", "天明", 414995, 417852, 1, -1),

    /** The anei. */
    ANEI("安永", "安永", 411937, 414995, 1, -1),

    /** The meiwa. */
    MEIWA("明和", "明和", 408852, 411937, 1, -1),

    /** The horeki. */
    HOREKI("宝暦", "宝暦", 404270, 408852, 1, -1),

    /** The kanen. */
    KANEN("寛延", "寛延", 403044, 404270, 1, -1),

    /** The enkyo ii. */
    ENKYO_II("延享", "延享", 401459, 403044, 1, -1),

    /** The kampo. */
    KAMPO("寛保", "寛保", 400372, 401459, 1, -1),

    /** The gembun. */
    GEMBUN("元文", "元文", 398602, 400372, 1, -1),

    /** The kyoho. */
    KYOHO("享保", "享保", 391360, 398602, 1, -1),

    /** The shotoku. */
    SHOTOKU("正徳", "正徳", 389474, 391360, 1, -1),

    /** The hoei. */
    HOEI("宝永", "宝永", 386862, 389474, 1, -1),

    /** The genroku. */
    GENROKU("元禄", "元禄", 381209, 386862, 1, -1),

    /** The jokyo. */
    JOKYO("貞享", "貞享", 379547, 381209, 1, -1),

    /** The tenna. */
    TENNA("天和", "天和", 378669, 379547, 1, -1),

    /** The empo. */
    EMPO("延宝", "延宝", 375737, 378669, 1, -1),

    /** The kanbum. */
    KANBUM("寛文", "寛文", 371194, 375737, 1, -1),

    /** The manji. */
    MANJI("万治", "万治", 370188, 371194, 1, -1),

    /** The meireki. */
    MEIREKI("明暦", "明暦", 368997, 370188, 1, -1),

    /** The joo ii. */
    JOO_II("承応", "承応", 368057, 368997, 1, -1),

    /** The keian. */
    KEIAN("慶安", "慶安", 366400, 368057, 1, -1),

    /** The shoho. */
    SHOHO("正保", "正保", 365220, 366400, 1, -1),

    /** The kanei. */
    KANEI("寛永", "寛永", 357644, 365220, 1, -1),

    /** The genna. */
    GENNA("元和", "元和", 354497, 357644, 1, -1),

    /** The keicho. */
    KEICHO("慶長", "慶長", 347660, 354497, 1, -1),

    /** The bunroku. */
    BUNROKU("文禄", "文禄", 346224, 347660, 1, -1),

    /** The tensho ii. */
    TENSHO_II("天正", "天正", 339146, 346224, 1, -1),

    /** The genki. */
    GENKI("元亀", "元亀", 337960, 339146, 1, -1),

    /** The eiroku. */
    EIROKU("永禄", "永禄", 333507, 337960, 1, -1),

    /** The koji ii. */
    KOJI_II("弘治", "弘治", 332645, 333507, 1, -1),

    /** The tembun. */
    TEMBUN("天文", "天文", 324175, 332645, 1, -1),

    /** The kyoroku. */
    KYOROKU("享禄", "享禄", 322719, 324175, 1, -1),

    /** The daiei. */
    DAIEI("大永", "大永", 320182, 322719, 1, -1),

    /** The eisho ii. */
    EISHO_II("永正", "永正", 313782, 320182, 1, -1),

    /** The bunki. */
    BUNKI("文亀", "文亀", 312688, 313782, 1, -1),

    /** The meio. */
    MEIO("明応", "明応", 309549, 312688, 1, -1),

    /** The entoku. */
    ENTOKU("延徳", "延徳", 308488, 309549, 1, -1),

    /** The chokyo. */
    CHOKYO("長享", "長享", 307719, 308488, 1, -1),

    /** The bummei. */
    BUMMEI("文明", "文明", 301083, 307719, 1, -1),

    /** The onin. */
    ONIN("応仁", "応仁", 300292, 301083, 1, -1),

    /** The bunsho. */
    BUNSHO("文正", "文正", 299901, 300292, 1, -1),

    /** The kansho. */
    KANSHO("寛正", "寛正", 298034, 299901, 1, -1),

    /** The choroku. */
    CHOROKU("長禄", "長禄", 296830, 298034, 1, -1),

    /** The kosho. */
    KOSHO("康正", "康正", 296059, 296830, 1, -1),

    /** The kyotoku. */
    KYOTOKU("享徳", "享徳", 294937, 296059, 1, -1),

    /** The hotoku. */
    HOTOKU("宝徳", "宝徳", 293847, 294937, 1, -1),

    /** The bunan. */
    BUNAN("文安", "文安", 291846, 293847, 1, -1),

    /** The kakitsu. */
    KAKITSU("嘉吉", "嘉吉", 290766, 291846, 1, -1),

    /** The eikyo. */
    EIKYO("永享", "永享", 286590, 290766, 1, -1),

    /** The shocho. */
    SHOCHO("正長", "正長", 286110, 286590, 1, -1),

    /** The oei. */
    OEI("応永", "応永", 273745, 286110, 1, -1),

    /** The meitoku northern. */
    MEITOKU_NORTHERN("明徳", "明徳(北朝)", 272172, 273745, 1, -1),

    /** The koo northern. */
    KOO_NORTHERN("康応", "康応(北朝)", 271771, 272172, 1, -1),

    /** The kakei northern. */
    KAKEI_NORTHERN("嘉慶", "嘉慶(北朝)", 271252, 271771, 1, -1),

    /** The shitoku northern. */
    SHITOKU_NORTHERN("至徳", "至徳(北朝)", 269957, 271252, 1, -1),

    /** The eitoku northern. */
    EITOKU_NORTHERN("永徳", "永徳(北朝)", 268862, 269957, 1, -1),

    /** The koryaku northern. */
    KORYAKU_NORTHERN("康暦", "康暦(北朝)", 268151, 268862, 1, -1),

    /** The eiwa northern. */
    EIWA_NORTHERN("永和", "永和(北朝)", 266679, 268151, 1, -1),

    /** The oan northern. */
    OAN_NORTHERN("応安", "応安(北朝)", 264101, 266679, 1, -1),

    /** The joji northern. */
    JOJI_NORTHERN("貞治", "貞治(北朝)", 262127, 264101, 1, -1),

    /** The koan northern. */
    KOAN_NORTHERN("康安", "康安(北朝)", 261602, 262127, 1, -1),

    /** The embun northern. */
    EMBUN_NORTHERN("延文", "延文(北朝)", 259771, 261602, 1, -1),

    /** The bunna northern. */
    BUNNA_NORTHERN("文和", "文和(北朝)", 258499, 259771, 1, -1),

    /** The kano northern. */
    KANO_NORTHERN("観応", "観応(北朝)", 257554, 258499, 1, -1),

    /** The jowa northern. */
    JOWA_NORTHERN("貞和", "貞和(北朝)", 255953, 257554, 1, -1),

    /** The koei northern. */
    KOEI_NORTHERN("康永", "康永(北朝)", 254690, 255953, 1, -1),

    /** The ryakuo northern. */
    RYAKUO_NORTHERN("暦応", "暦応(北朝)", 253361, 254690, 1, -1),

    /** The genchu southern. */
    GENCHU_SOUTHERN("元中", "元中(南朝)", 270017, 273124, 1, -1),

    /** The kowa southern. */
    KOWA_SOUTHERN("弘和", "弘和(南朝)", 268848, 270017, 1, -1),

    /** The tenjiu southern. */
    TENJIU_SOUTHERN("天授", "天授(南朝)", 266768, 268848, 1, -1),

    /** The bunchu southern. */
    BUNCHU_SOUTHERN("文中", "文中(南朝)", 265612, 266768, 1, -1),

    /** The kentoku southern. */
    KENTOKU_SOUTHERN("建徳", "建徳(南朝)", 264993, 265612, 1, -1),

    /** The shohei southern. */
    SHOHEI_SOUTHERN("正平", "正平(南朝)", 256384, 264993, 1, -1),

    /** The kokoku southern. */
    KOKOKU_SOUTHERN("興国", "興国(南朝)", 253953, 256384, 1, -1),

    /** The eigen southern. */
    EIGEN_SOUTHERN("延元", "延元(南朝)", 252448, 253953, 1, -1),

    /** The kemmu northern. */
    KEMMU_NORTHERN("建武", "建武(北朝)", 251680, 253361, 1, -1),

    /** The kemmu southern. */
    KEMMU_SOUTHERN("建武", "建武(南朝)", 251680, 252448, 1, -1),

    /** The shokei. */
    SHOKEI("正慶", "正慶(持明院統)", 251029, 251439, 1, -1),

    /** The genko southern. */
    GENKO_SOUTHERN("元弘", "元弘(大覚寺統)", 250764, 251680, 1, -1),

    /** The gentoku i. */
    GENTOKU_I("元徳", "元徳(持明院統)", 250055, 251029, 1, -1),

    /** The gentoku ii. */
    GENTOKU_II("元徳", "元徳(大覚寺統)", 250055, 250764, 1, -1),

    /** The karyaku. */
    KARYAKU("嘉暦", "嘉暦", 248842, 250055, 1, -1),

    /** The shochu. */
    SHOCHU("正中", "正中", 248323, 248842, 1, -1),

    /** The genko. */
    GENKO("元亨", "元亨", 246949, 248323, 1, -1),

    /** The geno. */
    GENO("元応", "元応", 246275, 246949, 1, -1),

    /** The bumpo. */
    BUMPO("文保", "文保", 245482, 246275, 1, -1),

    /** The showa i. */
    SHOWA_I("正和", "正和", 243698, 245482, 1, -1),

    /** The ocho. */
    OCHO("応長", "応長", 243352, 243698, 1, -1),

    /** The enkyo i. */
    ENKYO_I("延慶", "延慶", 242446, 243352, 1, -1),

    /** The tokuji. */
    TOKUJI("徳治", "徳治", 241772, 242446, 1, -1),

    /** The kagen. */
    KAGEN("嘉元", "嘉元", 240552, 241772, 1, -1),

    /** The kengen. */
    KENGEN("乾元", "乾元", 240272, 240552, 1, -1),

    /** The shoan ii. */
    SHOAN_II("正安", "正安", 238978, 240272, 1, -1),

    /** The einin. */
    EININ("永仁", "永仁", 236891, 238978, 1, -1),

    /** The shoo. */
    SHOO("正応", "正応", 234965, 236891, 1, -1),

    /** The koan. */
    KOAN("弘安", "弘安", 231245, 234965, 1, -1),

    /** The kenji. */
    KENJI("建治", "建治", 230209, 231245, 1, -1),

    /** The bunei. */
    BUNEI("文永", "文永", 226136, 230209, 1, -1),

    /** The kocho. */
    KOCHO("弘長", "弘長", 225035, 226136, 1, -1),

    /** The buno. */
    BUNO("文応", "文応", 224733, 225035, 1, -1),

    /** The shogen. */
    SHOGEN("正元", "正元", 224333, 224733, 1, -1),

    /** The shoka. */
    SHOKA("正嘉", "正嘉", 223583, 224333, 1, -1),

    /** The kogen. */
    KOGEN("康元", "康元", 223425, 223583, 1, -1),

    /** The kencho. */
    KENCHO("建長", "建長", 220693, 223425, 1, -1),

    /** The hoji. */
    HOJI("宝治", "宝治", 219935, 220693, 1, -1),

    /** The kangen. */
    KANGEN("寛元", "寛元", 218456, 219935, 1, -1),

    /** The ninji. */
    NINJI("仁治", "仁治", 217501, 218456, 1, -1),

    /** The eno. */
    ENO("延応", "延応", 216990, 217501, 1, -1),

    /** The ryakunin. */
    RYAKUNIN("暦仁", "暦仁", 216917, 216990, 1, -1),

    /** The katei. */
    KATEI("嘉禎", "嘉禎", 215762, 216917, 1, -1),

    /** The bunryaku. */
    BUNRYAKU("文暦", "文暦", 215423, 215762, 1, -1),

    /** The tempuku. */
    TEMPUKU("天福", "天福", 214872, 215423, 1, -1),

    /** The joei. */
    JOEI("貞永", "貞永", 214475, 214872, 1, -1),

    /** The kanki. */
    KANKI("寛喜", "寛喜", 213356, 214475, 1, -1),

    /** The antei. */
    ANTEI("安貞", "安貞", 212918, 213356, 1, -1),

    /** The karoku. */
    KAROKU("嘉禄", "嘉禄", 211953, 212918, 1, -1),

    /** The gennin. */
    GENNIN("元仁", "元仁", 211805, 211953, 1, -1),

    /** The joo i. */
    JOO_I("貞応", "貞応", 210854, 211805, 1, -1),

    /** The jokyu. */
    JOKYU("承久", "承久", 209760, 210854, 1, -1),

    /** The kempo. */
    KEMPO("建保", "建保", 207805, 209760, 1, -1),

    /** The kenryaku. */
    KENRYAKU("建暦", "建暦", 206804, 207805, 1, -1),

    /** The jogen ii. */
    JOGEN_II("承元", "承元", 205550, 206804, 1, -1),

    /** The kenei. */
    KENEI("建永", "建永", 205021, 205550, 1, -1),

    /** The genkyu. */
    GENKYU("元久", "元久", 204217, 205021, 1, -1),

    /** The kennin. */
    KENNIN("建仁", "建仁", 203117, 204217, 1, -1),

    /** The shoji. */
    SHOJI("正治", "正治", 202451, 203117, 1, -1),

    /** The kenkyku. */
    KENKYKU("建久", "建久", 199157, 202451, 1, -1),

    /** The bunji. */
    BUNJI("文治", "文治", 197447, 199157, 1, -1),

    /** The genryaku. */
    GENRYAKU("元暦", "元暦", 196977, 197447, 1, -1),

    /** The juei. */
    JUEI("寿永", "寿永", 196279, 196977, 1, -1),

    /** The yowa. */
    YOWA("養和", "養和", 195971, 196279, 1, -1),

    /** The jisho. */
    JISHO("治承", "治承", 194514, 195971, 1, -1),

    /** The angen. */
    ANGEN("安元", "安元", 193770, 194514, 1, -1),

    /** The shoan i. */
    SHOAN_I("承安", "承安", 192228, 193770, 1, -1),

    /** The kao. */
    KAO("嘉応", "嘉応", 191477, 192228, 1, -1),

    /** The ninan. */
    NINAN("仁安", "仁安", 190521, 191477, 1, -1),

    /** The eiman. */
    EIMAN("永万", "永万", 190085, 190521, 1, -1),

    /** The chokan. */
    CHOKAN("長寛", "長寛", 189283, 190085, 1, -1),

    /** The oho. */
    OHO("応保", "応保", 188696, 189283, 1, -1),

    /** The eiryaku. */
    EIRYAKU("永暦", "永暦", 188112, 188696, 1, -1),

    /** The heiji. */
    HEIJI("平治", "平治", 187827, 188112, 1, -1),

    /** The hogen. */
    HOGEN("保元", "保元", 186741, 187827, 1, -1),

    /** The kyuju. */
    KYUJU("久寿", "久寿", 186210, 186741, 1, -1),

    /** The nimpei. */
    NIMPEI("仁平", "仁平", 184821, 186210, 1, -1),

    /** The kyuan. */
    KYUAN("久安", "久安", 182809, 184821, 1, -1),

    /** The tenyo. */
    TENYO("天養", "天養", 182307, 182809, 1, -1),

    /** The koji i. */
    KOJI_I("康治", "康治", 181634, 182307, 1, -1),

    /** The eiji. */
    EIJI("永治", "永治", 181349, 181634, 1, -1),

    /** The hoen. */
    HOEN("保延", "保延", 179093, 181349, 1, -1),

    /** The chosho. */
    CHOSHO("長承", "長承", 178101, 179093, 1, -1),

    /** The tensho i. */
    TENSHO_I("天承", "天承", 177530, 178101, 1, -1),

    /** The daiji. */
    DAIJI("大治", "大治", 175691, 177530, 1, -1),

    /** The tenji. */
    TENJI("天治", "天治", 175053, 175691, 1, -1),

    /** The hoan. */
    HOAN("保安", "保安", 173583, 175053, 1, -1),

    /** The genei. */
    GENEI("元永", "元永", 172838, 173583, 1, -1),

    /** The eikyu. */
    EIKYU("永久", "永久", 171134, 172838, 1, -1),

    /** The tennei. */
    TENNEI("天永", "天永", 170013, 171134, 1, -1),

    /** The tennin. */
    TENNIN("天仁", "天仁", 169323, 170013, 1, -1),

    /** The kajo. */
    KAJO("嘉承", "嘉承", 168473, 169323, 1, -1),

    /** The choji. */
    CHOJI("長治", "長治", 167677, 168473, 1, -1),

    /** The kowa. */
    KOWA("康和", "康和", 166042, 167677, 1, -1),

    /** The jotoku. */
    JOTOKU("承徳", "承徳", 165415, 166042, 1, -1),

    /** The eicho. */
    EICHO("永長", "永長", 165057, 165415, 1, -1),

    /** The kaho. */
    KAHO("嘉保", "嘉保", 164346, 165057, 1, -1),

    /** The kanji. */
    KANJI("寛治", "寛治", 161532, 164346, 1, -1),

    /** The otoku. */
    OTOKU("応徳", "応徳", 160380, 161532, 1, -1),

    /** The eiho. */
    EIHO("永保", "永保", 159291, 160380, 1, -1),

    /** The joryaku. */
    JORYAKU("承暦", "承暦", 158088, 159291, 1, -1),

    /** The joho. */
    JOHO("承保", "承保", 156912, 158088, 1, -1),

    /** The enkyu. */
    ENKYU("延久", "延久", 154953, 156912, 1, -1),

    /** The jiryaku. */
    JIRYAKU("治暦", "治暦", 153613, 154953, 1, -1),

    /** The kohei. */
    KOHEI("康平", "康平", 151071, 153613, 1, -1),

    /** The tengi. */
    TENGI("天喜", "天喜", 149016, 151071, 1, -1),

    /** The eisho i. */
    EISHO_I("永承", "永承", 146568, 149016, 1, -1),

    /** The kantoku. */
    KANTOKU("寛徳", "寛徳", 146046, 146568, 1, -1),

    /** The chokyu. */
    CHOKYU("長久", "長久", 144585, 146046, 1, -1),

    /** The choryaku. */
    CHORYAKU("長暦", "長暦", 143268, 144585, 1, -1),

    /** The chogen. */
    CHOGEN("長元", "長元", 140082, 143268, 1, -1),

    /** The manju. */
    MANJU("万寿", "万寿", 138626, 140082, 1, -1),

    /** The jian. */
    JIAN("治安", "治安", 137371, 138626, 1, -1),

    /** The kannin. */
    KANNIN("寛仁", "寛仁", 135975, 137371, 1, -1),

    /** The chowa. */
    CHOWA("長和", "長和", 134412, 135975, 1, -1),

    /** The kanko. */
    KANKO("寛弘", "寛弘", 131306, 134412, 1, -1),

    /** The choho. */
    CHOHO("長保", "長保", 129292, 131306, 1, -1),

    /** The chotoku. */
    CHOTOKU("長徳", "長徳", 127883, 129292, 1, -1),

    /** The shoryaku. */
    SHORYAKU("正暦", "正暦", 126303, 127883, 1, -1),

    /** The eiso. */
    EISO("永祚", "永祚", 125861, 126303, 1, -1),

    /** The eien. */
    EIEN("永延", "永延", 125002, 125861, 1, -1),

    /** The kanna. */
    KANNA("寛和", "寛和", 124286, 125002, 1, -1),

    /** The eikan. */
    EIKAN("永観", "永観", 123565, 124286, 1, -1),

    /** The tengen. */
    TENGEN("天元", "天元", 121955, 123565, 1, -1),

    /** The jogen i. */
    JOGEN_I("貞元", "貞元", 121083, 121955, 1, -1),

    /** The tenen. */
    TENEN("天延", "天延", 120145, 121083, 1, -1),

    /** The tenroku. */
    TENROKU("天禄", "天禄", 118791, 120145, 1, -1),

    /** The anna. */
    ANNA("安和", "安和", 118189, 118791, 1, -1),

    /** The koho. */
    KOHO("康保", "康保", 116708, 118189, 1, -1),

    /** The owa. */
    OWA("応和", "応和", 115445, 116708, 1, -1),

    /** The tentoku. */
    TENTOKU("天徳", "天徳", 114245, 115445, 1, -1),

    /** The tenryaku. */
    TENRYAKU("天暦", "天暦", 110402, 114245, 1, -1),

    /** The tengyo. */
    TENGYO("天慶", "天慶", 107153, 110402, 1, -1),

    /** The johei. */
    JOHEI("承平", "承平", 104559, 107153, 1, -1),

    /** The encho. */
    ENCHO("延長", "延長", 101650, 104559, 1, -1),

    /** The engi. */
    ENGI("延喜", "延喜", 93709, 101650, 1, -1),

    /** The shotai. */
    SHOTAI("昌泰", "昌泰", 92511, 93709, 1, -1),

    /** The kampyo. */
    KAMPYO("寛平", "寛平", 89234, 92511, 1, -1),

    /** The ninna. */
    NINNA("仁和", "仁和", 87693, 89234, 1, -1),

    /** The gangyo. */
    GANGYO("元慶", "元慶", 84853, 87693, 1, -1),

    /** The jogan. */
    JOGAN("貞観", "貞観", 78266, 84853, 1, -1),

    /** The tenan. */
    TENAN("天安", "天安", 77475, 78266, 1, -1),

    /** The saiko. */
    SAIKO("斉衡", "斉衡", 76657, 77475, 1, -1),

    /** The ninjiu. */
    NINJIU("仁寿", "仁寿", 75356, 76657, 1, -1),

    /** The kasho. */
    KASHO("嘉祥", "嘉祥", 74306, 75356, 1, -1),

    /** The jowa. */
    JOWA("承和", "承和", 69040, 74306, 1, -1),

    /** The tencho. */
    TENCHO("天長", "天長", 65381, 69040, 1, -1),

    /** The konin. */
    KONIN("弘仁", "弘仁", 60522, 65381, 1, -1),

    /** The daido. */
    DAIDO("大同", "大同", 58927, 60522, 1, -1),

    /** The enryaku. */
    ENRYAKU("延暦", "延暦", 50275, 58927, 1, -1),

    /** The teno. */
    TENO("天応", "天応", 49667, 50275, 1, -1),

    /** The hoki. */
    HOKI("宝亀", "宝亀", 45915, 49667, 1, -1),

    /** The jingokeiun. */
    JINGOKEIUN("神護景雲", "神護景雲", 44779, 45915, 1, -1),

    /** The tempyojingo. */
    TEMPYOJINGO("天平神護", "天平神護", 43825, 44779, 1, -1),

    /** The tempyojoji. */
    TEMPYOJOJI("天平宝字", "天平宝字", 41120, 43825, 1, -1),

    /** The tempyoshoho. */
    TEMPYOSHOHO("天平勝宝", "天平勝宝", 38180, 41120, 1, -1),

    /** The tempyokampo. */
    TEMPYOKAMPO("天平感宝", "天平感宝", 38073, 38180, 1, -1),

    /** The tempyo. */
    TEMPYO("天平", "天平", 30889, 38073, 1, -1),

    /** The jinki. */
    JINKI("神亀", "神亀", 28880, 30889, 1, -1),

    /** The yoro. */
    YORO("養老", "養老", 26619, 28880, 1, -1),

    /** The reiki. */
    REIKI("霊亀", "霊亀", 25806, 26619, 1, -1),

    /** The wado. */
    WADO("和銅", "和銅", 23011, 25806, 1, -1),

    /** The keiun. */
    KEIUN("慶雲", "慶雲", 21680, 23011, 1, -1),

    /** The taiho. */
    TAIHO("大宝", "大宝", 20540, 21680, 1, -1),

    /** The shucho. */
    SHUCHO("朱鳥", "朱鳥", 15165, 15213, 1, -1),

    /** The hakuchi. */
    HAKUCHI("白雉", "白雉", 1871, 3579, 1, -1),

    /** The taika. */
    TAIKA("大化", "大化", 162, 1871, 1, -1),

    /** The julius. */
    JULIUS("旧暦", "旧暦", 0, 506921, 645, -1),

    /** The julian. */
    JULIAN("ユリウス暦", "ユリウス暦", -235251, 3416807, 1, 0)

    ;

    public static final int START_POSITION = 235251;

    /** The name. */
    private String name;

    /** The caption. */
    private String caption;

    /** The start. */
    private int start;

    /** The end. */
    private int end;

    /** The delta. */
    private int delta;

    /** The calendar. */
    private int calendar;

    /**
     * Instantiates a new eras.
     *
     * @param name the name
     * @param caption the caption
     * @param start the start
     * @param end the end
     * @param delta the delta
     * @param calendar the calendar
     */
    private Eras(String name, String caption, int start, int end, int delta, int calendar) {
        this.name = name;
        this.caption = caption;
        this.start = start;
        this.end = end;
        this.delta = delta;
        this.calendar = calendar;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the caption.
     *
     * @return the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Gets the start.
     *
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * Gets the end.
     *
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * Gets the delta.
     *
     * @return the delta
     */
    public int getDelta() {
        return delta;
    }

    /**
     * Gets the calendar.
     *
     * @return the calendar
     */
    public int getCalendar() {
        return calendar;
    }
}
