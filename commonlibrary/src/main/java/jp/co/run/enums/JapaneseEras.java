package jp.co.run.enums;

import java.util.Date;

import jp.co.run.util.DateUtil;

/**
 * The Enum EraNameJapan.
 */
public enum JapaneseEras {
    
    /** The heisei. */
    HEISEI("\u5E73\u6210", "\u3078\u3044\u305B\u3044", "1989-01-08", "now"),
    
    /** The showa. */
    SHOWA("\u662D\u548C", "\u3057\u3087\u3046\u308F", "1926-12-25", "1989-01-07"),
    
    /** The taisho. */
    TAISHO("\u5927\u6B63", "\u305F\u3044\u3057\u3087\u3046", "1912-07-30", "1926-12-25"),
    
    /** The meiji. */
    MEIJI("\u660E\u6CBB", "\u3081\u3044\u3058", "1868-10-23", "1912-07-30"),
    
    /** The keio. */
    KEIO("\u6176\u5FDC", "\u3051\u3044\u304A\u3046", "1865-05-01", "1868-10-23"),
    
    /** The genji. */
    GENJI("\u5143\u6CBB", "\u3052\u3093\u3058", "1864-03-27", "1865-05-01"),
    
    /** The bunkyu. */
    BUNKYU("\u6587\u4E45", "\u3076\u3093\u304D\u3085\u3046", "1861-03-29", "1864-03-27"),
    
    /** The manei. */
    MANEI("\u4E07\u5EF6", "\u307E\u3093\u3048\u3044", "1860-04-08", "1861-03-29"),
    
    /** The ansei. */
    ANSEI("\u5B89\u653F", "\u3042\u3093\u305B\u3044", "1855-01-15", "1860-04-08"),
    
    /** The kaei. */
    KAEI("\u5609\u6C38", "\u304B\u3048\u3044", "1848-04-01", "1855-01-15"),
    
    /** The koka. */
    KOKA("\u5F18\u5316", "\u3053\u3046\u304B", "1845-01-09", "1848-04-01"),
    
    /** The tempo. */
    TEMPO("\u5929\u4FDD", "\u3066\u3093\u307D\u3046", "1831-01-23", "1845-01-09"),
    
    /** The bunsei. */
    BUNSEI("\u6587\u653F", "\u3076\u3093\u305B\u3044", "1818-05-26", "1831-01-23"),
    
    /** The bunka. */
    BUNKA("\u6587\u5316", "\u3076\u3093\u304B", "1804-03-22", "1818-05-26"),
    
    /** The kyowa. */
    KYOWA("\u4EAB\u548C", "\u304D\u3087\u3046\u308F", "1801-03-19", "1804-03-22"),
    
    /** The kansei. */
    KANSEI("\u5BDB\u653F", "\u304B\u3093\u305B\u3044", "1789-02-19", "1801-03-19"),
    
    /** The temmei. */
    TEMMEI("\u5929\u660E", "\u3066\u3093\u3081\u3044", "1781-04-25", "1789-02-19"),
    
    /** The anei. */
    ANEI("\u5B89\u6C38", "\u3042\u3093\u3048\u3044", "1772-12-10", "1781-04-25"),
    
    /** The meiwa. */
    MEIWA("\u660E\u548C", "\u3081\u3044\u308F", "1764-06-30", "1772-12-10"),
    
    /** The horeki. */
    HOREKI("\u5B9D\u66A6", "\u307B\u3046\u308C\u304D", "1751-12-14", "1764-06-30"),
    
    /** The kanen. */
    KANEN("\u5BDB\u5EF6", "\u304B\u3093\u3048\u3093", "1748-08-05", "1751-12-14"),
    
    /** The enkyo. */
    ENKYO_II("\u5EF6\u4EAB", "\u3048\u3093\u304D\u3087\u3046", "1744-04-03", "1748-08-05"),
    
    /** The kampo. */
    KAMPO("\u5BDB\u4FDD", "\u304B\u3093\u307D\u3046", "1741-04-12", "1744-04-03"),
    
    /** The gembun. */
    GEMBUN("\u5143\u6587", "\u3052\u3093\u3076\u3093", "1736-06-07", "1741-04-12"),
    
    /** The kyoho. */
    KYOHO("\u4EAB\u4FDD", "\u304D\u3087\u3046\u307B\u3046", "1716-08-09", "1736-06-07"),
    
    /** The shotoku. */
    SHOTOKU("\u6B63\u5FB3", "\u3057\u3087\u3046\u3068\u304F", "1711-06-11", "1716-08-09"),
    
    /** The hoei. */
    HOEI("\u5B9D\u6C38", "\u307B\u3046\u3048\u3044", "1704-04-16", "1711-06-11"),
    
    /** The genroku. */
    GENROKU("\u5143\u7984", "\u3052\u3093\u308D\u304F", "1688-10-23", "1704-04-16"),
    
    /** The jokyo. */
    JOKYO("\u8C9E\u4EAB", "\u3058\u3087\u3046\u304D\u3087\u3046", "1684-04-05", "1688-10-23"),
    
    /** The tenna. */
    TENNA("\u5929\u548C", "\u3066\u3093\u306A", "1681-11-09", "1684-04-05"),
    
    /** The empo. */
    EMPO("\u5EF6\u5B9D", "\u3048\u3093\u307D\u3046", "1673-10-30", "1681-11-09"),
    
    /** The kanbum. */
    KANBUM("\u5BDB\u6587", "\u304B\u3093\u3076\u3093", "1661-05-23", "1673-10-30"),
    
    /** The manji. */
    MANJI("\u4E07\u6CBB", "\u307E\u3093\u3058", "1658-08-21", "1661-05-23"),
    
    /** The meireki. */
    MEIREKI("\u660E\u66A6", "\u3081\u3044\u308C\u304D", "1655-05-18", "1658-08-21"),
    
    /** The joo 2. */
    JOO_II("\u627F\u5FDC", "\u3058\u3087\u3046\u304A\u3046", "1652-10-20", "1655-05-18"),
    
    /** The keian. */
    KEIAN("\u6176\u5B89", "\u3051\u3044\u3042\u3093", "1648-04-07", "1652-10-20"),
    
    /** The shoho. */
    SHOHO("\u6B63\u4FDD", "\u3057\u3087\u3046\u307B\u3046", "1645-01-13", "1648-04-07"),
    
    /** The kanei. */
    KANEI("\u5BDB\u6C38", "\u304B\u3093\u3048\u3044", "1624-04-17", "1645-01-13"),
    
    /** The genna. */
    GENNA("\u5143\u548C", "\u3052\u3093\u306A", "1615-09-05", "1624-04-17"),
    
    /** The keicho. */
    KEICHO("\u6176\u9577", "\u3051\u3044\u3061\u3087\u3046", "1596-12-16", "1615-09-05"),
    
    /** The bunroku. */
    BUNROKU("\u6587\u7984", "\u3076\u3093\u308D\u304F", "1593-01-10", "1596-12-16"),
    
    /** The tensho. */
    TENSHO_II("\u5929\u6B63", "\u3066\u3093\u3057\u3087\u3046", "1573-08-25", "1593-01-10"),
    
    /** The genki. */
    GENKI("\u5143\u4E80", "\u3052\u3093\u304D", "1570-05-27", "1573-08-25"),
    
    /** The eiroku. */
    EIROKU("\u6C38\u7984", "\u3048\u3044\u308D\u304F", "1558-03-18", "1570-05-27"),
    
    /** The koji. */
    KOJI_II("\u5F18\u6CBB", "\u3053\u3046\u3058", "1555-11-07", "1558-03-18"),
    
    /** The tembun. */
    TEMBUN("\u5929\u6587", "\u3066\u3093\u3076\u3093", "1532-08-29", "1555-11-07"),
    
    /** The kyoroku. */
    KYOROKU("\u4EAB\u7984", "\u304D\u3087\u3046\u308D\u304F", "1528-09-03", "1532-08-29"),
    
    /** The daiei. */
    DAIEI("\u5927\u6C38", "\u3060\u3044\u3048\u3044", "1521-09-23", "1528-09-03"),
    
    /** The eisho. */
    EISHO_II("\u6C38\u6B63", "\u3048\u3044\u3057\u3087\u3046", "1504-03-16", "1521-09-23"),
    
    /** The bunki. */
    BUNKI("\u6587\u4E80", "\u3076\u3093\u304D", "1501-03-18", "1504-03-16"),
    
    /** The meio. */
    MEIO("\u660E\u5FDC", "\u3081\u3044\u304A\u3046", "1492-08-12", "1501-03-18"),
    
    /** The entoku. */
    ENTOKU("\u5EF6\u5FB3", "\u3048\u3093\u3068\u304F", "1489-09-16", "1492-08-12"),
    
    /** The chokyo. */
    CHOKYO("\u9577\u4EAB", "\u3061\u3087\u3046\u304D\u3087\u3046", "1487-08-09", "1489-09-16"),
    
    /** The bummei. */
    BUMMEI("\u6587\u660E", "\u3076\u3093\u3081\u3044", "1469-06-08", "1487-08-09"),
    
    /** The onin. */
    ONIN("\u5FDC\u4EC1", "\u304A\u3046\u306B\u3093", "1467-04-09", "1469-06-08"),
    
    /** The bunsho. */
    BUNSHO("\u6587\u6B63", "\u3076\u3093\u3057\u3087\u3046", "1466-03-14", "1467-04-09"),
    
    /** The kansho. */
    KANSHO("\u5BDB\u6B63", "\u304B\u3093\u3057\u3087\u3046", "1461-02-01", "1466-03-14"),
    
    /** The choroku. */
    CHOROKU("\u9577\u7984", "\u3061\u3087\u3046\u308D\u304F", "1457-10-16", "1461-02-01"),
    
    /** The kosho. */
    KOSHO("\u5EB7\u6B63", "\u3053\u3046\u3057\u3087\u3046", "1455-09-06", "1457-10-16"),
    
    /** The kyotoku. */
    KYOTOKU("\u4EAB\u5FB3", "\u304D\u3087\u3046\u3068\u304F", "1452-08-10", "1455-09-06"),
    
    /** The hotoku. */
    HOTOKU("\u5B9D\u5FB3", "\u307B\u3046\u3068\u304F", "1449-08-16", "1452-08-10"),
    
    /** The bunan. */
    BUNAN("\u6587\u5B89", "\u3076\u3093\u3042\u3093", "1444-02-23", "1449-08-16"),
    
    /** The kakitsu. */
    KAKITSU("\u5609\u5409", "\u304B\u304D\u3064", "1441-03-10", "1444-02-23"),
    
    /** The eikyo. */
    EIKYO("\u6C38\u4EAB", "\u3048\u3044\u304D\u3087\u3046", "1429-10-03", "1441-03-10"),
    
    /** The shocho. */
    SHOCHO("\u6B63\u9577", "\u3057\u3087\u3046\u3061\u3087\u3046", "1428-06-10", "1429-10-03"),
    
    /** The oei. */
    OEI("\u5FDC\u6C38", "\u304A\u3046\u3048\u3044", "1394-08-02", "1428-06-10"),
    
    /** The meitoku northern. */
    MEITOKU_NORTHERN("\u660E\u5FB3", "\u3081\u3044\u3068\u304F", "1390-04-12", "1394-08-02"),
    
    /** The koo northern. */
    KOO_NORTHERN("\u5EB7\u5FDC", "\u3053\u3046\u304A\u3046", "1389-03-07", "1390-04-12"),
    
    /** The kakei northern. */
    KAKEI_NORTHERN("\u5609\u6176", "\u304B\u3051\u3044", "1387-10-05", "1389-03-07"),
    
    /** The shitoku northern. */
    SHITOKU_NORTHERN("\u81F3\u5FB3", "\u3057\u3068\u304F", "1384-03-19", "1387-10-05"),
    
    /** The eitoku northern. */
    EITOKU_NORTHERN("\u6C38\u5FB3", "\u3048\u3044\u3068\u304F", "1381-03-20", "1384-03-19"),
    
    /** The koryaku northern. */
    KORYAKU_NORTHERN("\u5EB7\u66A6", "\u3053\u3046\u308A\u3083\u304F", "1379-04-09", "1381-03-20"),
    
    /** The eiwa northern. */
    EIWA_NORTHERN("\u6C38\u548C", "\u3048\u3044\u308F", "1375-03-29", "1379-04-09"),
    
    /** The oan northern. */
    OAN_NORTHERN("\u5FDC\u5B89", "\u304A\u3046\u3042\u3093", "1368-03-07", "1375-03-29"),
    
    /** The joji northern. */
    JOJI_NORTHERN("\u8C9E\u6CBB", "\u3058\u3087\u3046\u3058", "1362-10-11", "1368-03-07"),
    
    /** The koan northern. */
    KOAN_NORTHERN("\u5EB7\u5B89", "\u3053\u3046\u3042\u3093", "1361-05-04", "1362-10-11"),
    
    /** The embun northern. */
    EMBUN_NORTHERN("\u5EF6\u6587", "\u3048\u3093\u3076\u3093", "1356-04-29", "1361-05-04"),
    
    /** The bunna northern. */
    BUNNA_NORTHERN("\u6587\u548C", "\u3076\u3093\u306A", "1352-11-04", "1356-04-29"),
    
    /** The kano northern. */
    KANO_NORTHERN("\u89B3\u5FDC", "\u304B\u3093\u304A\u3046", "1350-04-04", "1352-11-04"),
    
    /** The jowa northern. */
    JOWA_NORTHERN("\u8C9E\u548C", "\u3058\u3087\u3046\u308F", "1345-11-15", "1350-04-04"),
    
    /** The koei northern. */
    KOEI_NORTHERN("\u5EB7\u6C38", "\u3053\u3046\u3048\u3044", "1342-06-01", "1345-11-15"),
    
    /** The ryakuo northern. */
    RYAKUO_NORTHERN("\u66A6\u5FDC", "\u308A\u3083\u304F\u304A\u3046", "1338-10-11", "1342-06-01"),
    
    /** The kemmu northern. */
    KEMMU_NORTHERN("\u5EFA\u6B66", "\u3051\u3093\u3080", "1334-03-05", "1338-10-11"),
    
    /** The genchu southern. */
    GENCHU_SOUTHERN("\u5143\u4E2D", "\u3052\u3093\u3061\u3085\u3046", "1384-05-18", "1392-11-19"),
    
    /** The kowa southern. */
    KOWA_SOUTHERN("\u5F18\u548C", "\u3053\u3046\u308F", "1381-03-06", "1384-05-18"),
    
    /** The tenjiu southern. */
    TENJIU_SOUTHERN("\u5929\u6388", "\u3066\u3093\u3058\u3085", "1375-06-26", "1381-03-06"),
    
    /** The bunchu southern. */
    BUNCHU_SOUTHERN("\u6587\u4E2D", "\u3076\u3093\u3061\u3085\u3046", "1372-04-26", "1375-06-26"),
    
    /** The kentoku southern. */
    KENTOKU_SOUTHERN("\u5EFA\u5FB3", "\u3051\u3093\u3068\u304F", "1370-08-16", "1372-04-26"),
    
    /** The shohei southern. */
    SHOHEI_SOUTHERN("\u6B63\u5E73", "\u3057\u3087\u3046\u3078\u3044", "1347-01-20", "1370-08-16"),
    
    /** The kokoku southern. */
    KOKOKU_SOUTHERN("\u8208\u56FD", "\u3053\u3046\u3053\u304F", "1340-05-25", "1347-01-20"),
    
    /** The eigen southern. */
    EIGEN_SOUTHERN("\u5EF6\u5143", "\u3048\u3044\u3052\u3093", "1336-04-11", "1340-05-25"),
    
    /** The kemmu southern. */
    KEMMU_SOUTHERN("\u5EFA\u6B66", "\u3051\u3093\u3080", "1334-03-05", "1336-04-11"),
    
    /** The shokei. */
    SHOKEI("\u6B63\u6176", "\u3057\u3087\u3046\u3051\u3044", "1332-05-23", "1333-07-07"),
    
    /** The genko shouthern. */
    GENKO_SHOUTHERN("\u5143\u5F18", "\u3052\u3093\u3053\u3046", "1331-09-01", "1334-03-05"),
    
    /** The gentoku. */
    GENTOKU("\u5143\u5FB3", "\u3052\u3093\u3068\u304F", "1329-09-22", "1331-09-01"),
    
    /** The karyaku. */
    KARYAKU("\u5609\u66A6", "\u304B\u308A\u3083\u304F", "1326-05-28", "1329-09-22"),
    
    /** The shochu. */
    SHOCHU("\u6B63\u4E2D", "\u3057\u3087\u3046\u3061\u3085", "1324-12-25", "1326-05-28"),
    
    /** The genko. */
    GENKO("\u5143\u4EA8", "\u3052\u3093\u3053\u3046", "1321-03-22", "1324-12-25"),
    
    /** The geno. */
    GENO("\u5143\u5FDC", "\u3052\u3093\u304A\u3046", "1319-05-18", "1321-03-22"),
    
    /** The bumpo. */
    BUMPO("\u6587\u4FDD", "\u3076\u3093\u307D\u3046", "1317-03-16", "1319-05-18"),
    
    /** The showa i. */
    SHOWA_I("\u6B63\u548C", "\u3057\u3087\u3046\u308F", "1312-04-27", "1317-03-16"),
    
    /** The ocho. */
    OCHO("\u5FDC\u9577", "\u304A\u3046\u3061\u3087\u3046", "1311-05-17", "1312-04-27"),
    
    /** The enkyo. */
    ENKYO_I("\u5EF6\u6176", "\u3048\u3093\u304D\u3087\u3046", "1308-11-22", "1311-05-17"),
    
    /** The tokuji. */
    TOKUJI("\u5FB3\u6CBB", "\u3068\u304F\u3058", "1307-01-18", "1308-11-22"),
    
    /** The kagen. */
    KAGEN("\u5609\u5143", "\u304B\u3052\u3093", "1303-09-16", "1307-01-18"),
    
    /** The kengen. */
    KENGEN("\u4E7E\u5143", "\u3051\u3093\u3052\u3093", "1302-12-10", "1303-09-16"),
    
    /** The shoan. */
    SHOAN_II("\u6B63\u5B89", "\u3057\u3087\u3046\u3042\u3093", "1299-05-25", "1302-12-10"),
    
    /** The einin. */
    EININ("\u6C38\u4EC1", "\u3048\u3044\u306B\u3093", "1293-09-06", "1299-05-25"),
    
    /** The shoo. */
    SHOO("\u6B63\u5FDC", "\u3057\u3087\u3046\u304A\u3046", "1288-05-29", "1293-09-06"),
    
    /** The koan. */
    KOAN("\u5F18\u5B89", "\u3053\u3046\u3042\u3093", "1278-03-23", "1288-05-29"),
    
    /** The kenji. */
    KENJI("\u5EFA\u6CBB", "\u3051\u3093\u3058", "1275-05-22", "1278-03-23"),
    
    /** The bunei. */
    BUNEI("\u6587\u6C38", "\u3076\u3093\u3048\u3044", "1264-03-27", "1275-05-22"),
    
    /** The kocho. */
    KOCHO("\u5F18\u9577", "\u3053\u3046\u3061\u3087\u3046", "1261-03-22", "1264-03-27"),
    
    /** The buno. */
    BUNO("\u6587\u5FDC", "\u3076\u3093\u304A\u3046", "1260-05-24", "1261-03-22"),
    
    /** The shogen. */
    SHOGEN("\u6B63\u5143", "\u3057\u3087\u3046\u3052\u3093", "1259-04-20", "1260-05-24"),
    
    /** The shoka. */
    SHOKA("\u6B63\u5609", "\u3057\u3087\u3046\u304B", "1257-03-31", "1259-04-20"),
    
    /** The kogen. */
    KOGEN("\u5EB7\u5143", "\u3053\u3046\u3052\u3093", "1256-10-24", "1257-03-31"),
    
    /** The kencho. */
    KENCHO("\u5EFA\u9577", "\u3051\u3093\u3061\u3087\u3046", "1249-05-02", "1256-10-24"),
    
    /** The hoji. */
    HOJI("\u5B9D\u6CBB", "\u307B\u3046\u3058", "1247-04-05", "1249-05-02"),
    
    /** The kangen. */
    KANGEN("\u5BDB\u5143", "\u304B\u3093\u3052\u3093", "1243-03-18", "1247-04-05"),
    
    /** The ninji. */
    NINJI("\u4EC1\u6CBB", "\u306B\u3093\u3058", "1240-08-05", "1243-03-18"),
    
    /** The eno. */
    ENO("\u5EF6\u5FDC", "\u3048\u3093\u304A\u3046", "1239-03-13", "1240-08-05"),
    
    /** The ryakunin. */
    RYAKUNIN("\u66A6\u4EC1", "\u308A\u3083\u304F\u306B\u3093", "1238-12-30", "1239-03-13"),
    
    /** The katei. */
    KATEI("\u5609\u798E", "\u304B\u3066\u3044", "1235-11-01", "1238-12-30"),
    
    /** The bunryaku. */
    BUNRYAKU("\u6587\u66A6", "\u3076\u3093\u308A\u3083\u304F", "1234-11-27", "1235-11-01"),
    
    /** The tempuku. */
    TEMPUKU("\u5929\u798F", "\u3066\u3093\u3077\u304F", "1233-05-25", "1234-11-27"),
    
    /** The joei. */
    JOEI("\u8C9E\u6C38", "\u3058\u3087\u3046\u3048\u3044", "1232-04-23", "1233-05-25"),
    
    /** The kanki. */
    KANKI("\u5BDB\u559C", "\u304B\u3093\u304D", "1229-03-31", "1232-04-23"),
    
    /** The antei. */
    ANTEI("\u5B89\u8C9E", "\u3042\u3093\u3066\u3044", "1228-01-18", "1229-03-31"),
    
    /** The karoku. */
    KAROKU("\u5609\u7984", "\u304B\u308D\u304F", "1225-05-28", "1228-01-18"),
    
    /** The gennin. */
    GENNIN("\u5143\u4EC1", "\u3052\u3093\u306B\u3093", "1224-12-31", "1225-05-28"),
    
    /** The joo 1. */
    JOO_I("\u8C9E\u5FDC", "\u3058\u3087\u3046\u304A\u3046", "1222-05-25", "1224-12-31"),
    
    /** The jokyu. */
    JOKYU("\u627F\u4E45", "\u3058\u3087\u3046\u304D\u3085\u3046", "1219-05-27", "1222-05-25"),
    
    /** The kempo. */
    KEMPO("\u5EFA\u4FDD", "\u3051\u3093\u307D\u3046", "1214-01-18", "1219-05-27"),
    
    /** The kenryaku. */
    KENRYAKU("\u5EFA\u66A6", "\u3051\u3093\u308A\u3083\u304F", "1211-04-23", "1214-01-18"),
    
    /** The jogen 2. */
    JOGEN_II("\u627F\u5143", "\u3058\u3087\u3046\u3052\u3093", "1207-11-16", "1211-04-23"),
    
    /** The kenei. */
    KENEI("\u5EFA\u6C38", "\u3051\u3093\u3048\u3044", "1206-06-05", "1207-11-16"),
    
    /** The genkyu. */
    GENKYU("\u5143\u4E45", "\u3052\u3093\u304D\u3085\u3046", "1204-03-23", "1206-06-05"),
    
    /** The kennin. */
    KENNIN("\u5EFA\u4EC1", "\u3051\u3093\u306B\u3093", "1201-03-19", "1204-03-23"),
    
    /** The shoji. */
    SHOJI("\u6B63\u6CBB", "\u3057\u3087\u3046\u3058", "1199-05-23", "1201-03-19"),
    
    /** The kenkyku. */
    KENKYKU("\u5EFA\u4E45", "\u3051\u3093\u304D\u3085\u3046", "1190-05-16", "1199-05-23"),
    
    /** The bunji. */
    BUNJI("\u6587\u6CBB", "\u3076\u3093\u3058", "1185-09-09", "1190-05-16"),
    
    /** The genryaku. */
    GENRYAKU("\u5143\u66A6", "\u3052\u3093\u308A\u3083\u304F", "1184-05-27", "1185-09-09"),
    
    /** The juei. */
    JUEI("\u5BFF\u6C38", "\u3058\u3085\u3048\u3044", "1182-06-29", "1184-05-27"),
    
    /** The yowa. */
    YOWA("\u990A\u548C", "\u3088\u3046\u308F", "1181-08-25", "1182-06-29"),
    
    /** The jisho. */
    JISHO("\u6CBB\u627F", "\u3058\u3057\u3087\u3046", "1177-08-29", "1181-08-25"),
    
    /** The angen. */
    ANGEN("\u5B89\u5143", "\u3042\u3093\u3052\u3093", "1175-08-16", "1177-08-29"),
    
    /** The shoan. */
    SHOAN_I("\u627F\u5B89", "\u3057\u3087\u3046\u3042\u3093", "1171-05-27", "1175-08-16"),
    
    /** The kao. */
    KAO("\u5609\u5FDC", "\u304B\u304A\u3046", "1169-05-06", "1171-05-27"),
    
    /** The ninan. */
    NINAN("\u4EC1\u5B89", "\u306B\u3093\u3042\u3093", "1166-09-23", "1169-05-06"),
    
    /** The eiman. */
    EIMAN("\u6C38\u4E07", "\u3048\u3044\u307E\u3093", "1165-07-14", "1166-09-23"),
    
    /** The chokan. */
    CHOKAN("\u9577\u5BDB", "\u3061\u3087\u3046\u304B\u3093", "1163-05-04", "1165-07-14"),
    
    /** The oho. */
    OHO("\u5FDC\u4FDD", "\u304A\u3046\u307B\u3046", "1161-09-24", "1163-05-04"),
    
    /** The eiryaku. */
    EIRYAKU("\u6C38\u66A6", "\u3048\u3044\u308A\u3083\u304F", "1160-02-18", "1161-09-24"),
    
    /** The heiji. */
    HEIJI("\u5E73\u6CBB", "\u3078\u3044\u3058", "1159-05-09", "1160-02-18"),
    
    /** The hogen. */
    HOGEN("\u4FDD\u5143", "\u307B\u3046\u3052\u3093", "1156-05-18", "1159-05-09"),
    
    /** The kyuju. */
    KYUJU("\u4E45\u5BFF", "\u304D\u3085\u3046\u3058\u3085", "1154-12-04", "1156-05-18"),
    
    /** The nimpei. */
    NIMPEI("\u4EC1\u5E73", "\u306B\u3093\u307A\u3044", "1151-02-14", "1154-12-04"),
    
    /** The kyuan. */
    KYUAN("\u4E45\u5B89", "\u304D\u3085\u3046\u3042\u3093", "1145-08-12", "1151-02-14"),
    
    /** The tenyo. */
    TENYO("\u5929\u990A", "\u3066\u3093\u3088\u3046", "1144-03-28", "1145-08-12"),
    
    /** The koji. */
    KOJI_I("\u5EB7\u6CBB", "\u3053\u3046\u3058", "1142-05-25", "1144-03-28"),
    
    /** The eiji. */
    EIJI("\u6C38\u6CBB", "\u3048\u3044\u3058", "1141-08-13", "1142-05-25"),
    
    /** The hoen. */
    HOEN("\u4FDD\u5EF6", "\u307B\u3046\u3048\u3093", "1135-06-10", "1141-08-13"),
    
    /** The chosho. */
    CHOSHO("\u9577\u627F", "\u3061\u3087\u3046\u3057\u3087\u3046", "1132-09-21", "1135-06-10"),
    
    /** The tensho. */
    TENSHO_I("\u5929\u627F", "\u3066\u3093\u3057\u3087\u3046", "1131-02-28", "1132-09-21"),
    
    /** The daiji. */
    DAIJI("\u5927\u6CBB", "\u3060\u3044\u3058", "1126-02-15", "1131-02-28"),
    
    /** The tenji. */
    TENJI("\u5929\u6CBB", "\u3066\u3093\u3058", "1124-05-18", "1126-02-15"),
    
    /** The hoan. */
    HOAN("\u4FDD\u5B89", "\u307B\u3046\u3042\u3093", "1120-05-09", "1124-05-18"),
    
    /** The genei. */
    GENEI("\u5143\u6C38", "\u3052\u3093\u3048\u3044", "1118-04-25", "1120-05-09"),
    
    /** The eikyu. */
    EIKYU("\u6C38\u4E45", "\u3048\u3044\u304D\u3085\u3046", "1113-08-25", "1118-04-25"),
    
    /** The tennei. */
    TENNEI("\u5929\u6C38", "\u3066\u3093\u306D\u3044", "1110-07-31", "1113-08-25"),
    
    /** The tennin. */
    TENNIN("\u5929\u4EC1", "\u3066\u3093\u306B\u3093", "1108-09-09", "1110-07-31"),
    
    /** The kajo. */
    KAJO("\u5609\u627F", "\u304B\u3058\u3087\u3046", "1106-05-13", "1108-09-09"),
    
    /** The choji. */
    CHOJI("\u9577\u6CBB", "\u3061\u3087\u3046\u3058", "1104-03-08", "1106-05-13"),
    
    /** The kowa. */
    KOWA("\u5EB7\u548C", "\u3053\u3046\u308F", "1099-09-15", "1104-03-08"),
    
    /** The jotoku. */
    JOTOKU("\u627F\u5FB3", "\u3058\u3087\u3046\u3068\u304F", "1097-12-27", "1099-09-15"),
    
    /** The eicho. */
    EICHO("\u6C38\u9577", "\u3048\u3044\u3061\u3087\u3046", "1097-01-03", "1097-12-27"),
    
    /** The kaho. */
    KAHO("\u5609\u4FDD", "\u304B\u307B\u3046", "1095-01-23", "1097-01-03"),
    
    /** The kanji. */
    KANJI("\u5BDB\u6CBB", "\u304B\u3093\u3058", "1087-05-11", "1095-01-23"),
    
    /** The otoku. */
    OTOKU("\u5FDC\u5FB3", "\u304A\u3046\u3068\u304F", "1084-03-15", "1087-05-11"),
    
    /** The eiho. */
    EIHO("\u6C38\u4FDD", "\u3048\u3044\u307B\u3046", "1081-03-22", "1084-03-15"),
    
    /** The joryaku. */
    JORYAKU("\u627F\u66A6", "\u3058\u3087\u3046\u308A\u3083\u304F", "1077-12-05", "1081-03-22"),
    
    /** The joho. */
    JOHO("\u627F\u4FDD", "\u3058\u3087\u3046\u307B\u3046", "1074-09-16", "1077-12-05"),
    
    /** The enkyu. */
    ENKYU("\u5EF6\u4E45", "\u3048\u3093\u304D\u3085\u3046", "1069-05-06", "1074-09-16"),
    
    /** The jiryaku. */
    JIRYAKU("\u6CBB\u66A6", "\u3058\u308A\u3083\u304F", "1065-09-04", "1069-05-06"),
    
    /** The kohei. */
    KOHEI("\u5EB7\u5E73", "\u3053\u3046\u3078\u3044", "1058-09-19", "1065-09-04"),
    
    /** The tengi. */
    TENGI("\u5929\u559C", "\u3066\u3093\u304E", "1053-02-02", "1058-09-19"),
    
    /** The eisho. */
    EISHO_I("\u6C38\u627F", "\u3048\u3044\u3057\u3087\u3046", "1046-05-22", "1053-02-02"),
    
    /** The kantoku. */
    KANTOKU("\u5BDB\u5FB3", "\u304B\u3093\u3068\u304F", "1044-12-16", "1046-05-22"),
    
    /** The chokyu. */
    CHOKYU("\u9577\u4E45", "\u3061\u3087\u3046\u304D\u3085\u3046", "1040-12-16", "1044-12-16"),
    
    /** The choryaku. */
    CHORYAKU("\u9577\u66A6", "\u3061\u3087\u3046\u308A\u3083\u304F", "1037-05-09", "1040-12-16"),
    
    /** The chogen. */
    CHOGEN("\u9577\u5143", "\u3061\u3087\u3046\u3052\u3093", "1028-08-18", "1037-05-09"),
    
    /** The manju. */
    MANJU("\u4E07\u5BFF", "\u307E\u3093\u3058\u3085", "1024-08-23", "1028-08-18"),
    
    /** The jian. */
    JIAN("\u6CBB\u5B89", "\u3058\u3042\u3093", "1021-03-17", "1024-08-23"),
    
    /** The kannin. */
    KANNIN("\u5BDB\u4EC1", "\u304B\u3093\u306B\u3093", "1017-05-21", "1021-03-17"),
    
    /** The chowa. */
    CHOWA("\u9577\u548C", "\u3061\u3087\u3046\u308F", "1013-02-08", "1017-05-21"),
    
    /** The kanko. */
    KANKO("\u5BDB\u5F18", "\u304B\u3093\u3053\u3046", "1004-08-08", "1013-02-08"),
    
    /** The choho. */
    CHOHO("\u9577\u4FDD", "\u3061\u3087\u3046\u307B\u3046", "0999-02-01", "1004-08-08"),
    
    /** The chotoku. */
    CHOTOKU("\u9577\u5FB3", "\u3061\u3087\u3046\u3068\u304F", "0995-03-25", "0999-02-01"),
    
    /** The shoryaku. */
    SHORYAKU("\u6B63\u66A6", "\u3057\u3087\u3046\u308A\u3083\u304F", "0990-11-26", "0995-03-25"),
    
    /** The eiso. */
    EISO("\u6C38\u795A", "\u3048\u3044\u305D", "0989-09-10", "0990-11-26"),
    
    /** The eien. */
    EIEN("\u6C38\u5EF6", "\u3048\u3044\u3048\u3093", "0987-05-05", "0989-09-10"),
    
    /** The kanna. */
    KANNA("\u5BDB\u548C", "\u304B\u3093\u306A", "0985-05-19", "0987-05-05"),
    
    /** The eikan. */
    EIKAN("\u6C38\u89B3", "\u3048\u3044\u304B\u3093", "0983-05-29", "0985-05-19"),
    
    /** The tengen. */
    TENGEN("\u5929\u5143", "\u3066\u3093\u3052\u3093", "0978-12-31", "0983-05-29"),
    
    /** The jogen. */
    JOGEN_I("\u8C9E\u5143", "\u3058\u3087\u3046\u3052\u3093", "0976-08-11", "0978-12-31"),
    
    /** The tenen. */
    TENEN("\u5929\u5EF6", "\u3066\u3093\u3048\u3093", "0974-01-16", "0976-08-11"),
    
    /** The tenroku. */
    TENROKU("\u5929\u7984", "\u3066\u3093\u308D\u304F", "0970-05-03", "0974-01-16"),
    
    /** The anna. */
    ANNA("\u5B89\u548C", "\u3042\u3093\u306A", "0968-09-08", "0970-05-03"),
    
    /** The koho. */
    KOHO("\u5EB7\u4FDD", "\u3053\u3046\u307B\u3046", "0964-08-19", "0968-09-08"),
    
    /** The owa. */
    OWA("\u5FDC\u548C", "\u304A\u3046\u308F", "0961-03-05", "0964-08-19"),
    
    /** The tentoku. */
    TENTOKU("\u5929\u5FB3", "\u3066\u3093\u3068\u304F", "0957-11-21", "0961-03-05"),
    
    /** The tenryaku. */
    TENRYAKU("\u5929\u66A6", "\u3066\u3093\u308A\u3083\u304F", "0947-05-15", "0957-11-21"),
    
    /** The tengyo. */
    TENGYO("\u5929\u6176", "\u3066\u3093\u304E\u3087\u3046", "0938-06-22", "0947-05-15"),
    
    /** The johei. */
    JOHEI("\u627F\u5E73", "\u3058\u3087\u3046\u3078\u3044", "0931-05-16", "0938-06-22"),
    
    /** The encho. */
    ENCHO("\u5EF6\u9577", "\u3048\u3093\u3061\u3087\u3046", "0923-05-29", "0931-05-16"),
    
    /** The engi. */
    ENGI("\u5EF6\u559C", "\u3048\u3093\u304E", "0901-08-31", "0923-05-29"),
    
    /** The shotai. */
    SHOTAI("\u660C\u6CF0", "\u3057\u3087\u3046\u305F\u3044", "0898-05-20", "0901-08-31"),
    
    /** The kampyo. */
    KAMPYO("\u5BDB\u5E73", "\u304B\u3093\u3074\u3087\u3046", "0889-05-30", "0898-05-20"),
    
    /** The ninna. */
    NINNA("\u4EC1\u548C", "\u306B\u3093\u306A", "0885-03-11", "0889-05-30"),
    
    /** The gangyo. */
    GANGYO("\u5143\u6176", "\u304C\u3093\u304E\u3087\u3046", "0877-06-01", "0885-03-11"),
    
    /** The jogan. */
    JOGAN("\u8C9E\u89B3", "\u3058\u3087\u3046\u304C\u3093", "0859-05-20", "0877-06-01"),
    
    /** The tenan. */
    TENAN("\u5929\u5B89", "\u3066\u3093\u3042\u3093", "0857-03-20", "0859-05-20"),
    
    /** The saiko. */
    SAIKO("\u6589\u8861", "\u3055\u3044\u3053\u3046", "0854-12-23", "0857-03-20"),
    
    /** The ninjiu. */
    NINJIU("\u4EC1\u5BFF", "\u306B\u3093\u3058\u3085", "0851-06-01", "0854-12-23"),
    
    /** The kasho. */
    KASHO("\u5609\u7965", "\u304B\u3057\u3087\u3046", "0848-07-16", "0851-06-01"),
    
    /** The jowa. */
    JOWA("\u627F\u548C", "\u3058\u3087\u3046\u308F", "0834-02-14", "0848-07-16"),
    
    /** The tencho. */
    TENCHO("\u5929\u9577", "\u3066\u3093\u3061\u3087\u3046", "0824-02-08", "0834-02-14"),
    
    /** The konin. */
    KONIN("\u5F18\u4EC1", "\u3053\u3046\u306B\u3093", "0810-10-20", "0824-02-08"),
    
    /** The daido. */
    DAIDO("\u5927\u540C", "\u3060\u3044\u3069\u3046", "0806-06-08", "0810-10-20"),
    
    /** The enryaku. */
    ENRYAKU("\u5EF6\u66A6", "\u3048\u3093\u308A\u3083\u304F", "0782-09-30", "0806-06-08"),
    
    /** The teno. */
    TENO("\u5929\u5FDC", "\u3066\u3093\u304A\u3046", "0781-01-30", "0782-09-30"),
    
    /** The hoki. */
    HOKI("\u5B9D\u4E80", "\u307B\u3046\u304D", "0770-10-23", "0781-01-30"),
    
    /** The jingokeiun. */
    JINGOKEIUN("\u795E\u8B77\u666F\u96F2", "\u3058\u3093\u3054\u3051\u3044\u3046\u3093", "0767-09-13", "0770-10-23"),
    
    /** The tempyojingo. */
    TEMPYOJINGO("\u5929\u5E73\u795E\u8B77", "\u3066\u3093\u3074\u3087\u3046\u3058\u3093\u3054", "0765-02-01", "0767-09-13"),
    
    /** The tempyojoji. */
    TEMPYOJOJI("\u5929\u5E73\u5B9D\u5B57", "\u3066\u3093\u3074\u3087\u3046\u3058\u3087\u3046\u3058", "0757-09-06", "0765-02-01"),
    
    /** The tempyoshoho. */
    TEMPYOSHOHO("\u5929\u5E73\u52DD\u5B9D", "\u3066\u3093\u3074\u3087\u3046\u3057\u3087\u3046\u307B\u3046", "0749-08-19", "0757-09-06"),
    
    /** The tempyokampo. */
    TEMPYOKAMPO("\u5929\u5E73\u611F\u5B9D", "\u3066\u3093\u3074\u3087\u3046\u304B\u3093\u307D\u3046", "0749-05-04", "0749-08-19"),
    
    /** The tempyo. */
    TEMPYO("\u5929\u5E73", "\u3066\u3093\u3074\u3087\u3046", "0729-09-02", "0749-05-04"),
    
    /** The jinki. */
    JINKI("\u795E\u4E80", "\u3058\u3093\u304D", "0724-03-03", "0729-09-02"),
    
    /** The yoro. */
    YORO("\u990A\u8001", "\u3088\u3046\u308D\u3046", "0717-12-24", "0724-03-03"),
    
    /** The reiki. */
    REIKI("\u970A\u4E80", "\u308C\u3044\u304D", "0715-10-03", "0717-12-24"),
    
    /** The wado. */
    WADO("\u548C\u9285", "\u308F\u3069\u3046", "0708-02-07", "0715-10-03"),
    
    /** The keiun. */
    KEIUN("\u6176\u96F2","\u3051\u3044\u3046\u3093", "0704-06-16", "0708-02-07"),
    
    /** The taiho. */
    TAIHO("\u5927\u5B9D", "\u305F\u3044\u307B\u3046", "0701-05-03", "0704-06-16"),
    
    /** The shucho. */
    SHUCHO("\u6731\u9CE5", "\u3057\u3085\u3061\u3087\u3046", "0686-08-14", "0686-10-01"),
    
    /** The hakuchi. */
    HAKUCHI("\u767D\u96C9", "\u306F\u304F\u3061", "0650-03-22", "0654-11-24"),
    
    /** The taika. */
    TAIKA("\u5927\u5316", "\u305F\u3044\u304B", "0645-07-17", "0650-03-22")
    
    ;
    
    /** The Constant sad. */
    private static final String sad = "";
    
    /** The kanji name. */
    private String kanjiName;
    
    /** The hira name. */
    private String hiraName;
    
    /** The start date. */
    private String startDate;
    
    /** The end date. */
    private String endDate;
    
    /**
     * Instantiates a new japanese eras.
     *
     * @param kanjiName the kanji name
     * @param hiraName the hira name
     * @param startDate the start date
     * @param endDate the end date
     */
    private JapaneseEras(String kanjiName, String hiraName,
                         String startDate, String endDate) {
                             
        this.kanjiName = kanjiName;
        this.hiraName = hiraName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Checks if is eras.
     *
     * @param date the date
     * @param pattern the pattern
     * @return true, if is eras
     */
    public boolean isEras(String str, String pattern) {
        
        Date date = DateUtil.parseDate(str, pattern);
        
        Date startDate = DateUtil.parseDate(this.startDate, "yyyy-MM-dd");
        Date endDate = this.endDate.equalsIgnoreCase("now") ? DateUtil.getCurrentDate("Asia/Tokyo") 
                                                            : DateUtil.parseDate(this.endDate, "yyyy-MM-dd");
        
        if (date == null) {
            return false;
        }
        
        return date.getTime() >= startDate.getTime() && date.getTime() < endDate.getTime();
    }

    public String getKanjiName() {
        return kanjiName;
    }

    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    public String getHiraName() {
        return hiraName;
    }

    public void setHiraName(String hiraName) {
        this.hiraName = hiraName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
