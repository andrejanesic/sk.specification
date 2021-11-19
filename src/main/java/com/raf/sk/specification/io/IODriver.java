package com.raf.sk.specification.io;

import com.raf.sk.specification.builders.DirectoryBuilder;
import com.raf.sk.specification.builders.FileBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Vrši interakciju sa okruženjem. Ovaj interfejs se koristi za implementaciju aplikacije na konkretnoj platformi.
 */
public interface IODriver {

    /**
     * Kreira novi direktorijum.
     *
     * @param path Putanja do čvora.
     */
    void makeDirectory(String path);

    /**
     * Kreira novi fajl.
     *
     * @param path Putanja do čvora.
     */
    void makeFile(String path);

    /**
     * Briše direktorijum.
     *
     * @param path Putanja do čvora.
     */
    void deleteDirectory(String path);

    /**
     * Briše fajl.
     *
     * @param path Putanja do čvora.
     */
    void deleteFile(String path);

    /**
     * Pomera direktorijum sa sourcePath na destPath.
     *
     * @param sourcePath Izvorna putanja.
     * @param destPath   Nova putanja.
     */
    void moveDirectory(String sourcePath, String destPath);

    /**
     * Pomera fajl sa sourcePath na destPath.
     *
     * @param sourcePath Izvorna putanja.
     * @param destPath   Nova putanja.
     */
    void moveFile(String sourcePath, String destPath);

    /**
     * Preuzima direktorijum sa izvorne na destinacionu putanju.
     *
     * @param sourcePath   Izvorna putanja.
     * @param downloadPath Destinaciona putanja.
     */
    void downloadDirectory(String sourcePath, String downloadPath);

    /**
     * Preuzima fajl sa izvorne na destinacionu putanju.
     *
     * @param destRelPath Putanja gde treba otpremiti fajl.
     * @param filePath    Putanja fajla.
     * @return Bilder do fajla {@link FileBuilder}.
     */
    FileBuilder uploadFile(String destRelPath, String filePath);

    /**
     * Preuzima fajl sa izvorne na destinacionu putanju.
     *
     * @param sourcePath   Izvorna putanja.
     * @param downloadPath Destinaciona putanja.
     */
    void downloadFile(String sourcePath, String downloadPath);

    /**
     * Čita konfiguracioni fajl. Vraća null ukoliko ne postoji.
     * <p>
     * Potrebno je da IODriver zapamti ovu lokaciju; svaki sledći poziv <i>(osim poziv koji inicijalizuje novi
     * direktorijum)</i> biće relativan u odnosu na njegovu putanju.
     * <p>
     * Drugim rečima:
     * <ul>
     *     <li>Neka se putanja nalazi na <pre>syspath = c:/com.raf.sk.specification.storage/</pre></li>
     *     <li>Konfiguracioni fajl je <pre>c:/com.raf.sk.specification.storage/com.raf.sk.specification.config.json</pre></li>
     *     <li>Neka treba da pristupimo direktorijumu čija je relativna putanja <pre>relpath = /photos/summer-2021</pre>
     *     </li>
     *     <li>Tada će puna putanja biti <pre>abspath = c:/com.raf.sk.specification.storage/photos/summer-2021</pre> pri čemu je na IOAdapter-u
     *     da zapamti deo syspath, odnosno poslednji korišteni path za inicijalizaciju direktorijuma.</li>
     * </ul>
     *
     * @param absPath Apsolutna putanja na kojoj treba pročitati ili inicijalizovati konfiguracioni fajl u OS okruženju.
     * @return Potrebno je vratiti sadržinu konfiguracionog fajla (u JSON formatu) ili null ukoliko konfiguracioni fajl
     * ne postoji.
     */
    String readConfig(String absPath);

    /**
     * Piše konfiguracioni fajl na zadatoj putanji.
     *
     * @param json    Sadržina konfiguracionog fajla u JSON formatu.
     * @param absPath Apsolutna putanja na kojoj treba pročitati ili inicijalizovati konfiguracioni fajl u OS okruženju.
     */
    void writeConfig(String json, String absPath);

    /**
     * Inicijalizuje strukturu skladišta na datoj putanji u korenski {@link DirectoryBuilder}. Ako je skladište prazno
     * (ne sadrži ni jedan fajl/direktorijum), potrebno je vratiti "prazni" {@link DirectoryBuilder}. Povratna vrednost
     * ne sme biti null.
     *
     * @return {@link DirectoryBuilder} koji sadrži podstablo čvorova {@link com.raf.sk.specification.builders.INodeBuilder}.
     */
    @NotNull
    DirectoryBuilder initStorage();
}
