package com.example.data.model

data class StudyTopic(
    val title: String,
    val description: String,
    val iconName: String, // ID or description of key icon
    val summaries: List<String>,
    val detailSections: List<DetailSection>
)

data class DetailSection(
    val heading: String,
    val content: String
)

object StudyTopicProvider {
    val topics = listOf(
        StudyTopic(
            title = "Cuaca dan Iklim",
            description = "Atmosfer, Sirkulasi Udara Global, Angin Dunia, Klasifikasi Iklim, dan Awan.",
            iconName = "WbSunny",
            summaries = listOf(
                "Atmosfer kering tersusun atas Nitrogen (78%) dan Oksigen (21%) sebagai gas permanen, serta gas variabel penting seperti CO2, Ozon, dan Uap Air.",
                "Struktur atmosfer vertikal berdasarkan suhu terdiri dari Troposfer (penurunan suhu adiabatik), Stratosfer (adanya lapisan Ozon hangat), Mesosfer (paling dingin), dan Termosfer/Eksosfer.",
                "Sirkulasi umum meridional atmosfer bumi dibagi menjadi Sel Hadley (tropis), Sel Ferrel (sedang), dan Sel Kutub.",
                "Sirkulasi Walker adalah sirkulasi udara zonal di sepanjang ekuator Pasifik yang ditenagai oleh perbedaan suhu laut timur dan barat.",
                "Klasifikasi Iklim yang populer meliputi Koppen (berdasarkan suhu dan curah hujan harian), Schmidt-Ferguson (perbandingan bulan kering dan bulan basah), serta Junghuhn (berdasarkan batas ketinggian vertikal vegetasi di Indonesia)."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Komposisi & Lapisan Atmosfer",
                    content = "Atmosfer melindungi kehidupan dengan menyerap radiasi UV berbahaya. Lapisan troposfer adalah lapisan terbawah di mana seluruh proses cuaca (hujan, badai, awan) bergulir. Di atasnya terdapat stratosfer yang bersuhu stabil kemudian memanas akibat penyerapan radiasi ultraviolet oleh molekul Ozon (O3)."
                ),
                DetailSection(
                    heading = "2. Sirkulasi Sel Hadley & Angin Pasat",
                    content = "Suhu panas di ekuator menyebabkan udara mengembang dan naik ke atas secara konvektif. Hal ini menciptakan area tekanan rendah konstan di ekuator bernama ITCZ (Intertropical Convergence Zone) atau DKAT (Daerah Konvergensi Antar Tropis). Udara yang naik mendingin, berbelok ke lintang 30° Utara dan Selatan, lalu turun (subsiden) memicu gurun-gurun kering dunia, lalu mengalir kembali ke ekuator sebagai angin Pasat Timur Laut dan Pasat Tenggara."
                ),
                DetailSection(
                    heading = "3. Metode Klasifikasi Iklim Terkenal",
                    content = "• KOPPEN: Menggunakan huruf kapital A (Tropis), B (Kering/Arid), C (Sedang hangat), D (Dingin mikro), E (Kutub). Di Indonesia, Af melambangkan Hutan Hujan Tropis Basah, Am melambangkan Monsun/Musim, dan Aw melambangkan Sabana Tropis kering.\n• SCHMIDT-FERGUSON: Menggunakan nilai Q = (Rata-rata Bulan Kering / Rata-rata Bulan Basah) x 100%. Bulan Basah memiliki curah >100mm, sedangkan Bulan Kering <60mm.\n• JUNGHUHN: Zona Panas (0-600m; padi, kelapa, tebu), Zona Sedang (600-1500m; kopi, teh, sayuran), Zona Sejuk (1500-2500m; pinus, kinang), Zona Dingin (>2500m; hampir tidak ada tanaman budidaya)."
                )
            )
        ),
        StudyTopic(
            title = "Oseanografi",
            description = "Sifat Fisik-Kimia Air Laut, Arus Laut, Pasang Surut Laut, Transpor Ekman, dan Morfologi.",
            iconName = "Water",
            summaries = listOf(
                "Air laut memiliki salinitas rata-rata sebesar 35‰ (35 gram garam terlarut per 1 kg air laut), didominasi garam NaCl.",
                "Suhu air laut vertikal terbagi atas lapisan termoklin (penurunan suhu tajam ekstrem), memisahkan air permukaan hangat dan air dalam dingin.",
                "Gelombang laut digerakkan oleh tiupan angin permukaan, tinggi gelombang dikontrol oleh kecepatan, durasi, dan jarak hembus angin (fetch).",
                "Arus laut digerakkan oleh tiga faktor: Tiupan angin konstan (arus permukaan), perbedaan salinitas-suhu (sirkulasi termohalin global), dan gaya Coriolis.",
                "Pasang Surut air laut dipicu gaya gravitasi bulan dan matahari. Terdiri dari pasang purnama (spring tide) dan pasang perbani (neap tide)."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Salinitas & Sifat Kimia Air Laut",
                    content = "Salinitas dipengaruhi penguapan (evaporasi), curah hujan (presipitasi), pencairan es, dan aliran debit sungai tawar. Daerah tropis yang basah seperti Indonesia memiliki salinitas cenderung moderat hingga rendah karena curah hujan basah tinggi mengencerkan kandungan garam permukaan laut."
                ),
                DetailSection(
                    heading = "2. Sirkulasi Termohalin (The Conveyor Belt)",
                    content = "Sirkulasi laut dalam ditenagai oleh densitas air yang dipengaruhi suhu dingin dan salinitas tinggi. Di Atlantik Utara, proses pembekuan es laut memeras garam masuk kembali ke air cair sisa, menjadikannya sangat bersalinitas tinggi dan dingin ekstrem. Air ini tenggelam ke dasar laut samudra dan mengalir mengitari seluruh dunia sebagai sabuk raksasa arus dingin bawah laut."
                ),
                DetailSection(
                    heading = "3. Pasang Surut Laut (Tide)",
                    content = "• Pasang Purnama (Spring Tide): Terjadi saat bulan, bumi, dan matahari berada dalam garis lurus (Bulan Baru dan Bulan Purnama). Gaya tarik menyatu menghasilkan pasang tertinggi dan surut terendah.\n• Pasang Perbani (Neap Tide): Terjadi saat posisi bulan membentuk sudut 90° dengan bumi dan matahari (Bulan Seperempat). Gaya tarik saling meniadakan menghasilkan pasang rendah tingkat fluktuasinya."
                )
            )
        ),
        StudyTopic(
            title = "Kebencanaan dan Manajemen Bencana",
            description = "Siklus Penanggulangan, Penilaian Risiko Bencana, Mitigasi Gempa, Tsunami, dan Gunungapi.",
            iconName = "Warning",
            summaries = listOf(
                "Bencana adalah gangguan serius ekosistem yang melampaui kemampuan masyarakat mengatasinya sendiri.",
                "Risiko Bencana dihitung lewat interaksi Bahaya (Hazard), Kerentanan (Vulnerability), dan Kapasitas (Capacity).",
                "Bencana Geologis utama di Indonesia adalah Gempa Bumi, Tsunami, Letusan Gunungapi, dan Longsor.",
                "Likuefaksi adalah pencairan material pasir jenuh air akibat shock/guncangan getaran seismik.",
                "Langkah mitigasi terbagi menjadi mitigasi struktural (pembangunan dinding tsunami, jalur evakuasi) dan non-struktural (edukasi, tata ruang ketat)."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Risiko Bencana dan Formula Pengurangan",
                    content = "Rumus dasar yang digunakan dalam kebencanaan adalah:\nRisiko Bencana = (Bahaya x Kerentanan) / Kapasitas\n\nUntuk mengurangi risiko, kita harus menurunkan kerentanan (misal: membangun rumah tahan gempa) dan meningkatkan kapasitas (misal: simulasi evakuasi warga dan sistem peringatan dini/EWS)."
                ),
                DetailSection(
                    heading = "2. Mekanisme Gempa Bumi & Tsunami",
                    content = "Gempa bumi tektonik disebabkan pelepasan energi akibat patahan lempeng bumi secara mendadak. Jika episentrum berada di dasar laut dangkal dengan patahan vertikal (naik/turun) bermagnitudo besar (>6.5 SR), kolam air laut terdisplacement secara total melahirkan gelombang tsunami yang melaju secepat pesawat terbang namun meninggi secara mekanis ketika mendekati perairan pantai yang dangkal."
                ),
                DetailSection(
                    heading = "3. Mitigasi Letusan Gunungapi",
                    content = "Ciri letusan gunungapi meliputi gempa vulkanik berkala, mengeringnya mata air, peningkatan suhu kawah lokal, migrasi turun satwa liar (bio-indikator), dan kematian tumbuhan akibat emisi sulfur tinggi. Mitigasi dilakukan dengan pemetaan Kawasan Rawan Bencana (KRB) serta penentuan status level aktif (Normal, Waspada, Siaga, Awas)."
                )
            )
        ),
        StudyTopic(
            title = "Sumberdaya dan Manajemen Sumberdaya",
            description = "Sumberdaya Alam (SDA), Strategi Energi Terbarukan, dan Pengelolaan Berkelanjutan.",
            iconName = "Grass",
            summaries = listOf(
                "Sumberdaya alam diklasifikasikan menjadi SDA Hayati (biotis) dan Non-Hayati (abiotis), serta SDA yang dapat diperbarui (renewable) dan tidak dapat diperbarui (non-renewable).",
                "Energi Terbarukan ramah lingkungan meliputi Energi Surya/Solar, Tenaga Angin, Panas Bumi (Geothermal), Mikrohidro, Biomassa, dan pasang surut laut.",
                "UU No. 11 tahun 1976 membagi bahan tambang galian menjadi tiga golongan utama: A (Strategis), B (Vital), dan C (Industri).",
                "Krisis kayu bakar dan ketergantungan sumberdaya menceritakan timpangnya pemakaian antara negara maju (MEDCs) dan negara berkembang (LEDCs).",
                "Pengelolaan berkelanjutan menerapkan prinsip menjaga ekologi tanpa mengorbankan pemenuhan ekonomi lintas generasi."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Klasifikasi Bahan Galian Tambang",
                    content = "• GOLONGAN A (Strategis): Krusial untuk keamanan benteng pertahanan eksternal dan kedaulatan negara (minyak bumi, uranium, batu bara, gas alam).\n• GOLONGAN B (Vital): Mengontrol hajat kebutuhan hidup orang banyak (emas, perak, besi, tembaga, nikel).\n• GOLONGAN C (Industri): Bahan galian yang langsung digunakan untuk pembangunan infrastruktur fisik dan industri (batu gamping, pasir kuarsa, tanah liat, marmer)."
                ),
                DetailSection(
                    heading = "2. Transisi Energi Masa Depan Indonesia",
                    content = "Sebagai negara Ring of Fire, Indonesia unggul dengan deposit potensi energi panas bumi (geothermal) terbanyak di lintasan ekuator. Keuntungannya adalah emisi rendah dan stabilitas suplai tinggi karena tidak bergantung fluktuasi cuaca harian seperti kincir angin atau panel surya."
                ),
                DetailSection(
                    heading = "3. Prinsip Berkelanjutan (Sustainability)",
                    content = "Prinsip konservasi mewajibkan manusia memproses pemanfaatan sumberdaya alam secara efisien, melakukan penanaman kembali hutan yang gundul, mencari bahan bakar alternatif ramah lingkungan, dan meminimalkan eksploitasi terbuka (open-pit mining) yang merusak tanah air permukaan."
                )
            )
        ),
        StudyTopic(
            title = "Geografi Lingkungan dan Pembangunan",
            description = "Ekosistem Dunia, Siklus Biogeokimia Bumi, Air & Udara, Kebijakan Hukum Global.",
            iconName = "Eco",
            summaries = listOf(
                "Ekosistem adalah kesatuan hubungan timbal balik utuh antara komponen abiotik (tanah, iklim) dan komponen biotik (flora, fauna).",
                "Sistem bumi digerakkan oleh siklus materi biogeokimia tidak berujung meliputi siklus Batuan, Hidrologi, Karbon, Nitrogen, Fosfor, dsb.",
                "Pencemaran air disebabkan oleh pupuk sisa pertanuan (memincu eutrofikasi), patogen bakteri, limbah nikel industri, dan logam berat (timbal).",
                "Polutan udara dibedakan menjadi polutan primer (CO, SO2, Nitrogen Oksida, debu PM) dan sekunder (smog, kabut asam).",
                "Hukum lingkungan global disinergikan melalui berbagai protokol perubahan iklim internasional."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Siklus Biogeokimia Bumi",
                    content = "• SIKLUS NITROGEN: Sangat bergantung pada bakteri penambat di akar tanaman polong (seperti Rhizobium) yang mengubah gas Nitrogen beku (N₂ atmosfer) menjadi amonium (NH₄⁺) dan nitrat (NO₃⁻) yang subur diserap akar sayuran secara biologis.\n• SIKLUS KARBON: Dipercepat oleh proses respirasi organisme and pembakaran fosil, sementara diserap lambat oleh fotosintesis pepohonan serta proses sedimentasi karbonat di terumbu karang dasar laut."
                ),
                DetailSection(
                    heading = "2. Masalah Lingkungan Air & Udara",
                    content = "Eutrofikasi adalah penumpukan senyawa fosfat/nitrat berlebih di danau akibat pencemaran sisa pupuk urea/pestisida. Hal ini merangsang tumbuhnya tanaman eceng gondok sangat subur mekar (blooming) liar meluas, memblokir sinar matahari, menguras pasokan oksigen terlarut dalam air (BOD naik), hingga mematikan seluruh fauna ikan lokal."
                ),
                DetailSection(
                    heading = "3. Protokol & Amandemen Perubahan Iklim",
                    content = "• PROTOKOL KYOTO (1997): Menuntut komitmen negara maju untuk memotong emisi gas rumah kaca (GRK).\n• PROTOKOL MONTREAL (1987): Fokus mengendalikan zat penghancur ozon (BPO/CFC).\n• DANA IKLIM HIJAU (Cancun): Dana bantuan negara kaya US$ 100 miliar per tahun untuk menunjang adaptasi iklim negara miskin."
                )
            )
        ),
        StudyTopic(
            title = "Perubahan Roman Muka Bumi dan Bentangalam",
            description = "Pengantar Geomorfologi, Bentangalam Vulkanik, Fluvial, Karst, Eolian, Pantai, dan Glasial.",
            iconName = "Landscape",
            summaries = listOf(
                "Geomorfologi mempelajari bentuk dan rupa fisik pemukaan bumi beserta asal-usul pembentukannya.",
                "Tenaga pembentuk terdiri dari Tenaga Endogen (bersifat membangun bentuklahan lewat vulkanis/tektonis) dan Ekogen (bersifat merusak lewat pelapukan/erosi).",
                "Bentangalam Vulkanik dikontrol oleh pembekuan magma (morfologi strato, perisai, maar, kaldera).",
                "Bentangalam Fluvial dipicu aliran air sungai (morfologi kipas aluvial, oxbow lake, delta, pola aliran sungai).",
                "Bentangalam Eolian digerakkan oleh tiupan angin kencang di daerah arid (morfologi barchan, sand dunes, playa, loess)."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Bentangalam Fluvial & Pola Aliran",
                    content = "Sungai mengikis tebing lateral meander menciptakan kelokan tajam. Pola aliran sungai bervariasi sesuai litologi tanah:\n• DENDRITIK: Seperti cabang pohon buah gembur, berkembang di batuan homogen seragam.\n• RADIAL SENTRIFUGAL: Memancar menjauhi pusat puncak gunungapi aktif.\n• TRELLIS: Sejajar patahan sinklin-antiklin berselang-seling batuan resisten hancur."
                ),
                DetailSection(
                    heading = "2. Bentangalam Pantai & Delta",
                    content = "Abrasi menghasilkan pilar karang keras berdiri tegak (Sea Stacks / Sea Arches). Sedimentasi arus menyusur pantai menghasilkan lidah pasir (Spit), gundukan lumpur penghubung pulau (Tombolo), serta danau pantai asin tertutup (Lagoon). Di muara sungai, sedimen tawar menumpuk membentuk Delta (morfologi kaki burung / Birdfoot Delta dan Delta Kipas)."
                ),
                DetailSection(
                    heading = "3. Bentangalam Glasial (Morfologi Gletser)",
                    content = "Massa es bergerak turun meluncur mengikis bukit membentuk lembah curam berpenampang huruf U (U-shaped valley). Di sisa goresan es, menyisakan danau kecil sirk (Tarn), benteng kerikil sisa es mencair (Moraine), serta teluk fjord bukit pasir yang menjorok indah ke dalam."
                )
            )
        ),
        StudyTopic(
            title = "Pertanian dan Permasalahan Pangan",
            description = "Konsep Tanah, Faktor Pembentuk Tanah, Kerusakan Tanah, Konservasi Tanah, dan Revolusi Hijau.",
            iconName = "Agriculture",
            summaries = listOf(
                "Tanah dibentuk dari pencampuran mineral lapuk, bahan organik humik, air, udara, serta jasad biota mikro.",
                "Profil tanah vertikal menunjukkan perkembangan horizon: O (humus permukaan), A (topsoil subur), E (eluviasi tercuci), B (iluviasi pengendapan), C (pelapukan batuan), D/R (bedrock keras).",
                "Faktor pembentuk tanah meliputi Iklim (suhu & curah hujan), Batuan Induk, Topografi kemiringan, Organisme lokal, dan faktor Waktu.",
                "Konservasi Lahan lereng terbagi menjadi Vegetatif (penanaman kontur, cover crop, reboisasi) dan Mekanis (terasering, cek-dam, drainase).",
                "Revolusi Hijau merupakan lompatan produksi pangan yang diawali dengan bibit unggul hibri, pupuk masif, pestisida kimiawi, dan mekanisasi traktor."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Sifat Fisik & Kimia Tanah",
                    content = "• TEKSTUR TANAH: Menunjukkan proporsi relatif fraksi pasir (sand), debu (silt), dan liat (clay). Tanah liat tinggi menahan air kuat tapi berventilasi buruk.\n• pH TANAH: Ideal untuk sayuran gizi subur berkisar 6.5 - 7.5. Pengapuran pertanian menggunakan batu kamping/dolomit mutlak diperlukan di lahan masam gambut asam Kalimantan."
                ),
                DetailSection(
                    heading = "2. Konservasi Lahan Cara Vegetatif vs Mekanis",
                    content = "Sistem konservasi lahan terjal miring sangat penting mencegah tanah longsor:\n• VEGETATIF: Menanam barisan rumput searah contour (contour strip cropping), menutupi tanah kosong basah dengan leguminosa menjalar (cover crop).\n• MEKANIS: Memahat tanah berteras-teras (terrasering) bertingkat melambat run-off, membuat guludan bersaluran melintir."
                ),
                DetailSection(
                    heading = "3. Pertanian Organik (Organik Sinergis)",
                    content = "Meningkatnya efek degradasi humus dan kekebalan hama tahan bahan kimia (resustensi hama baru) memicu lahirnya gerakan pertanian organik. Sistem ini mengutamakan pemakaian pupuk hijau alami kompos cair, pemotong tumpang-sari beragam, dan penyerahan pembersih serangga predator ramah lingkungan."
                )
            )
        ),
        StudyTopic(
            title = "Kependudukan dan Dinamika Penduduk",
            description = "Variabel Demografi, Piramida Penduduk, Dependency Ratio, Teori Kependudukan.",
            iconName = "People",
            summaries = listOf(
                "Dinamika perubahan populasi penduduk dipengaruhi langsung oleh Fertilitas (Kelahiran), Mortalitas (Kematian), dan Migrasi.",
                "Piramida penduduk memberikan struktur visual komposisi umur: Ekspansif (muda dominan), Stasioner (proporsinya seimbang sehat), Konstruktif (tua kencang).",
                "Rasio Ketergantungan didefinisikan sebagai rasio umur non-produktif terhadap umur pekerja produktif dalam persen.",
                "Teori Kependudukan Malthus memitigasi bahaya ledakan deret ukur penduduk, sedangkan Karl Marx menentangnya lewat keadilan sosialis kesempatan kerja.",
                "Teori Transisi Demografi menerangkan pergeseran kestabilan kelahiran tinggi-kematian tinggi menuju kelahiran rendah-kematian rendah."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Jenis Piramida Penduduk",
                    content = "• EKSPANSIF (Segitiga): Terjadi di negara berkembang (seperti Indonesia lama, Kenya). Angka kelahiran tinggi dan kematian anak mulai turun.\n• STASIONER (Granat): Terjadi di negara maju stabil (USA, Swedia). Angka kelahiran dan kematian rendah mantap.\n• KONSTRUKTIF (Guci terbalik): Terjadi di negara maju menurun (Jepang, Jerman). Kematian mengangkangi kelahiran, jumlah pekerja melungsur turun."
                ),
                DetailSection(
                    heading = "2. Faktor Pro & Anti Natalitas-Mortalitas",
                    content = "• PRO-NATALITAS: Menikah dini usia muda, jaminan keagamaan, anggapan banyak anak melimpahkan rejeki ekonomi.\n• ANTI-NATALITAS: Keberhasilan program KB nasional, penggunaan alat kontrasepsi, karir pekerjaan wanita mandiri tinggi.\n• PRO-MORTALITAS: Sistem sanitasi kumuh buruk, penyebaran wabah patogen, bencana perang, kelaparan."
                ),
                DetailSection(
                    heading = "3. Migrasi Penduduk Komprehensif",
                    content = "Menurut Teori Everett Lee, migrasi dikontrol oleh adanya Faktor Pendorong di daerah asal (degradasi lahan, miskin upah kerja, kerusuhan) dan Faktor Penarik di daerah tujuan (fasilitas medis lengkap, pendidikan unggul, gemerlap kota). Hambatan antara (jarak bermiles-miles, perijinan visa paspor ketat) menyaring jumlah aktual pelaku yang berpindah."
                )
            )
        ),
        StudyTopic(
            title = "Geografi Ekonomi",
            description = "Tingkatan Aktivitas Ekonomi, Ideologi Ekonomi, Teori Lokasi Strategis Dunia.",
            iconName = "TrendingUp",
            summaries = listOf(
                "Aktivitas ekonomi dikelompokkan menjadi: Primer (menguras SDA; tani/tambang), Sekunder (manufaktur pabrik), Tersier (jasa ritel), Kuartener (informasi IT & riset).",
                "Ideologi ekonomi dunia bervariasi dari Kapitalis Kebebasan Pasar (Adam Smith) hingga Sosialis Terencana Terpusat (Karl Marx).",
                "Teori Lokasi Pertanian von Thunen memprediksi tata sewa tanah konsentris berdasarkan ongkos antar ke pasar kota.",
                "Teori Lokasi Industri Alfred Weber mensyaratkan biaya minimalisasi transportasi pengangkutan bahan baku berbanding produk.",
                "Teori Losch menekankan batas wilayah pemasaran melingkar heksagonal menguntungkan produsen."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Pembagian Kelas Sektor Ekonomi",
                    content = "• PRIMER: Pengambilan bahan baku mentah langsung (pertanian padi, penangkapan tuna, penambangan batu bara).\n• SEKUNDER: Proses fabrikasi perakitan bahan mentah menjadi barang bernilai jual tinggi (peleburan besi baja, pabrik garmen, tekstil).\n• TERSIER: Penjualan produk/jasa ke pelanggan (distributor barang dagang, supir busway, jaminan asuransi perbankan).\n• KUARTENER: Sektor berteknologi tinggi mutakhir (ilmuwan riset vaksin bio-gen, arsitek sistem server database AI)."
                ),
                DetailSection(
                    heading = "2. Teori Lokasi Alfred Weber",
                    content = "Weber merumuskan kerangka 'Segitiga Weber' untuk menaruh lokasi pabrik di titik biaya transport terendah (Least Cost Location). Faktor yang diperhitungkan adalah Indeks Material (IM) = Berat Bahan Baku / Berat Produk Akhir. Jika bahan baku mentahnya jauh lebih berat, pabrik harus ditaruh dekat lokasi galian tambang."
                ),
                DetailSection(
                    heading = "3. Teori Tahapan Perkembangan Rostow",
                    content = "W.W. Rostow merumuskan 5 tahap gerak laju perekonomian suatu bangsa:\n1. Masyarakat Tradisional (tani subsisten kasar, dogma kencang).\n2. Prasyarat Lepas Landas (adanya modal investasi masuk, inovasi awal).\n3. Lepas Landas (Take Off; industri manufaktur mekar pesat).\n4. Dorongan Menuju Kedewasaan (penguasaan teknologi meluas).\n5. Era Konsumsi Massa Tinggi (dominasi industri tersier & kesejahteraan)."
                )
            )
        ),
        StudyTopic(
            title = "Pariwisata dan Manajemen Pariwisata",
            description = "Definisi, Faktor Permintaan Wisata, Konsep Sapta Pesona, dan Perencanaan Daerah Tujuan.",
            iconName = "Flight",
            summaries = listOf(
                "Pariwisata merupakan kunjungan perjalanan sementara yang dilakukan untuk rekreasi atau mempelajari keunikan alam budaya.",
                "Menurut Michel Hall, wisata beririsan erat dengan alokasi waktu luang (leisure), rekreasi non-bisnis, dan perjalanan komersial.",
                "Faktor penentu pariwisata adalah ketersediaan Atraksi (sesuatu yang dilihat/dilakukan), Fasilitas Akomodasi (tempat tinggal/restoran), dan Aksesibilitas (kemudahan transportasi berkendara).",
                "Sapta Pesona adalah 7 pilar kondisi kepariwisataan Indonesia yang melahirkan kesan mendalam bagi tamu pelancong.",
                "Ekoturisme melahirkan perlindungan alam satwa langka liar sejalan dengan mendulang kesejahteraan ekonomi lokal berkelanjutan."
            ),
            detailSections = listOf(
                DetailSection(
                    heading = "1. Komponen Penawaran Daerah Wisata (4A)",
                    content = "• ATTRACTION (Atraksi): Kekhasan alam kuno atau keunikan upacara adat yang memikat.\n• AMENITIES (Fasilitas): Kenyamanan kasur hotel, penginapan guesthouse, serta kelengkapan kuliner lezat.\n• ACCESSIBILITY (Aksesibilitas): Kondisi mulusnya aspal jalanan, kehematan ongkos tiket, serta kedekatan rel/bandara.\n• ANCILLARY (Kelembagaan): Organisasi lokal pramuwisata yang tertata mengawasi keselamatan turis."
                ),
                DetailSection(
                    heading = "2. Tujuh Unsur Sapta Pesona Nasional",
                    content = "Sapta Pesona meliputi:\n1. AMAN: Bebas rasa cemas dari premanisme.\n2. TERTIB: Budaya antri bersih beraturan.\n3. BERSIH: Sehat tanpa cemaran sampah plastis.\n4. SEJUK: Teduh rindang pepohonan hijau.\n5. INDAH: Pemandangan alam tertata eksotis.\n6. RAMAH: Senyum hangat penuh kesopanan warga.\n7. KENANGAN: Memori manis membawa cinderamata."
                ),
                DetailSection(
                    heading = "3. Dampak Negatif Kunjungan Massal (Mass Tourism)",
                    content = "Jika tidak dikoordinasikan dengan baik, wisata dapat mencemari ekosistem pantai, merusak struktur batu candi kuno, menaikkan tingkat kejahatan prostitusi/perjudian di kota resor pantai, serta memicu inflasi tinggi barang pangan kebutuhan lokal karena dialihkan melayani suplai hotel asing."
                )
            )
        )
    )
}
