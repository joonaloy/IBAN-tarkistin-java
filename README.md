# IBAN-tarkistin-java
--------tehtävänanto--------

Olet ohjelmoija suomalaisessa pankissa. Sinun tehtävänäsi on kirjoittaa funktio, joka tarkistaa annetun
tilinumeron aitouden. Kirjoita haluamallasi koodikielellä funktio, joka palauttaa True tai False arvon sen
perusteella, että onko argumenttina annettu tunnus mahdollisesti aito suomalaiseksi pankkitunnukseksi.
IBAN-muotoinen tilinumero koostuu seuraavista osista:
• Kaksikirjaiminen maatunnus: suomalaisilla tileillä FI
• Kaksinumeroinen tarkistenumero, joka lasketaan tilinumeron ja maatunnuksen avulla.
IBAN-tilinumeron tarkistamisessa voidaan noudattaa seuraavaa algoritmia:
1. Poista mahdolliset välilyönnit (tilinumero kirjoitetaan lukemisen helpottamiseksi usein
ryhmiteltynä neljän merkin jaksoin). Tarkista myös, että tilinumeron pituus täsmää
(suomalaisissa tileissä siis 18 merkkiä).
2. Siirrä maatunnus ja kaksinumeroinen tarkistenumero tilinumeron loppuun.
3. Korvaa kaikki kirjaimet numeroilla siten, että A=10, B=11, ..., Z=35.
4. Laske kokonaisluvuksi muunnetun tilinumeron jakojäännös, kun luku jaetaan luvulla 97.
Mikäli jakojäännökseksi saadaan luku 1, on kyseinen tilinumero muodollisesti kelvollinen IBANtilinumero. Tämä ei kuitenkaan takaa, että kyseessä olisi käytössä oleva tilinumero.[2]
Esimerkiksi tilinumeron FI42 5000 1510 0000 23 tarkistaminen tapahtuisi seuraavasti:
1. FI4250001510000023 (välilyönnit poistettu, pituus 18 merkkiä, kuten kuuluukin)
2. 50001510000023FI42 (maatunnus ja tarkiste siirretty loppuun)
3. 50001510000023151842 (kirjaimet korvattu numeroilla)
4. 50001510000023151842 mod 97 = 1
Jakojäännös on 1, joten tilinumero on muodollisesti kelvollinen IBAN-tilinumero.
Esimerkki tilinumerot:
FI42 5000 1510 0000 23  True
FI55 2515 8869 5718 65  False
FI95 1786 3769 6731 97  True
FI07 5762 9588 4181 13  False
FI52 8592 6874 8382 54  True
SE76 9449 8965 5115 5139 7733  False
