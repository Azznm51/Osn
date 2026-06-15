package com.example.data.model

data class Question(
    val id: Int,
    val category: String,
    val caseTitle: String,
    val scenario: String,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)

object QuestionProvider {
    val questions = listOf(
        // Topic 1: Cuaca dan Iklim
        Question(
            id = 1,
            category = "Cuaca dan Iklim",
            caseTitle = "Studi Kasus: Siklon Tropis Seroja (NTT)",
            scenario = "Pada tahun 2021, Siklon Tropis Seroja terbentuk di dekat daratan wilayah Nusa Tenggara Timur (NTT). Fenomena ini tidak biasa karena umumnya siklon tropis tumbuh di perairan laut dalam yang jauh dari ekuator (di atas 5-10 derajat LU/LS) karena membutuhkan efek gaya Coriolis yang cukup kuat untuk melahirkan pusaran spiral.",
            questionText = "Mengapa Siklon Seroja dapat terbentuk sangat dekat dengan ekuator di wilayah NTT dan memicu kerusakan masif?",
            options = listOf(
                "Suhu permukaan laut lokal yang sangat hangat (>29°C) memberikan pasokan energi laten yang melimpah.",
                "Efek Coriolis di wilayah NTT mendadak naik berkali-kali lipat akibat pergeseran magnet bumi.",
                "Adanya hembusan angin fohn kering yang sangat kencang dari daratan Australia.",
                "Interaksi angin monsun barat dengan sistem pegunungan tinggi di Pulau Timor."
            ),
            correctAnswerIndex = 0,
            explanation = "Siklon tropis membutuhkan suhu air laut minimal 26.5°C hingga kedalaman 50 meter. Peningkatan suhu permukaan laut akibat pemanasan global di perairan NTT memasok energi laten kondensasi dalam jumlah masif, mengatasi lemahnya gaya Coriolis di dekat ekuator sehingga sistem tekanan rendah berputar menjadi badai."
        ),
        Question(
            id = 2,
            category = "Cuaca dan Iklim",
            caseTitle = "Studi Kasus: Sirkulasi Walker & Fenomena El Niño",
            scenario = "Selama kondisi netral, angin pasat bertiup dari timur ke barat melintasi Samudra Pasifik, mendorong air hangat ke Pasifik Barat (Indonesia) dan menimbulkan area konvektif basah. Namun saat El Niño, angin pasat melemah, dan area kolam panas bergeser ke Pasifik Tengah/Timur.",
            questionText = "Apa dampak langsung dari pergeseran sirlukasi udara sel Walker selama El Niño ekstrem terhadap cuaca di Indonesia?",
            options = listOf(
                "Terjadi peningkatan curah hujan ekstrem karena massa udara basah berkumpul di atas pulau Sumatra.",
                "Terjadi subsidi udara (massa udara turun/downwelling udara) di atas Indonesia, memicu kemarau panjang.",
                "Angin monsun barat bertiup lebih lambat dan menghasilkan badai salju di puncak Jayawijaya.",
                "Laut Banda mengalami peningkatan kelembapan udara sehingga meningkatkan frekuensi awan konvektif."
            ),
            correctAnswerIndex = 1,
            explanation = "Saat El Niño, pusat tekanan rendah konvektif bergeser ke Pasifik tengah/timur. Di Indonesia, sel Walker berbalik arah menjadi area penurunan massa udara (subsidi udara). Udara yang turun menghangat secara adiabatis dan kelembapan berkurang, mencegah terbentuknya awan, memicu kekeringan parah."
        ),

        // Topic 2: Oseanografi
        Question(
            id = 3,
            category = "Oseanografi",
            caseTitle = "Studi Kasus: Fenomena Upwelling Laut Banda",
            scenario = "Pada bulan Juni hingga Agustus, nelayan di sekitar Laut Banda panen ikan pelagis dalam jumlah sangat besar. Pada saat yang sama, citra satelit mendeteksi suhu permukaan laut di wilayah tersebut turun signifikan dan kandungan klorofil-a melonjak tajam.",
            questionText = "Proses fisik oseanografi apa yang paling tepat menjelaskan fenomena kesuburan biologis musiman ini?",
            options = listOf(
                "Angin Monsun Barat mendorong air dingin yang kaya nutrien dari Samudra Pasifik masuk ke Laut Banda.",
                "Angin Monsun Tenggara berembus menjauhi garis kolam air, memicu transpor Ekman yang mengangkat massa air dalam dingin kaya nutrien ke permukaan.",
                "Terjadinya intrusi air tawar dari sungai-sungai besar di Papua Tengah menurunkan salinitas dasar laut.",
                "Adanya fenomena arus turbidit bawah laut yang mengaduk sedimen dasar hingga hancur."
            ),
            correctAnswerIndex = 1,
            explanation = "Selama Monsun Timur/Tenggara, angin berembus mantap dari Australia ke barat laut. Sesuai teori transpor Ekman di belahan bumi selatan, defleksi massa air bergerak ke kiri arah angin yang mengakibatkan air permukaan tersingkir menjauhi pantai/pulau, digantikan massa air dalam yang dingin dan kaya zat hara fosfat/nitrat (upwelling)."
        ),
        Question(
            id = 4,
            category = "Oseanografi",
            caseTitle = "Studi Kasus: Arus Lintas Indonesia (Arlindo)",
            scenario = "Arlindo adalah fenomena pergerakan massa air dari Samudra Pasifik menuju Samudra Hindia melalui selat-selat di Indonesia. Aliran air ini membawa pengaruh termal dan salinitas yang signifikan.",
            questionText = "Mengapa perpindahan massa air raksasa ini bergerak konstan dari Samudra Pasifik ke Samudra Hindia melintasi perairan Indonesia?",
            options = listOf(
                "Karena topografi perairan Indonesia yang menurun drastis dari arah selatan ke arah utara.",
                "Adanya perbedaan tinggi permukaan laut akibat penumpukan air hangat di Pasifik Barat yang lebih tinggi dibanding Samudra Hindia bagian timur.",
                "Karena hembusan konstan angin barat ekuatorial yang sangat kuat terjadi sepanjang tahun.",
                "Pengaruh aktivitas tektonik dari cincin api Pasifik yang menarik massa air lewat gaya hisap palung."
            ),
            correctAnswerIndex = 1,
            explanation = "Perbedaan tinggi permukaan air laut secara rata-rata (gradien pressure head) menjadi pendorong utama Arlindo. Penudungan air hangat oleh angin pasat di Samudra Pasifik Barat menciptakan muka laut yang sekitar 15-20 cm lebih tinggi daripada Samudra Hindia selatan Jawa, sehingga air mengalir melintasi selat-selat Indonesia."
        ),

        // Topic 3: Kebencanaan dan Manajemen Bencana
        Question(
            id = 5,
            category = "Kebencanaan dan Manajemen Bencana",
            caseTitle = "Studi Kasus: Analisis Risiko Gempa & Formula RB = (H x V)/C",
            scenario = "Sebuah gempa berkekuatan 6.2 Skala Richter mengguncang Kota A yang memiliki bangunan beton bertulang tanpa standar gempa (antiseismic) dan kesadaran mitigasi warganya rendah. Kota B diguncang gempa 6.2 SR dengan bangunan berstandar antiseismic, tata ruang ketat, dan latihan kebencanaan rutin.",
            questionText = "Berdasarkan prinsip manajemen bencana, perbandingan risiko bencana (RB) kedua kota tersebut adalah...",
            options = listOf(
                "Risiko Kota A sama dengan Kota B karena ancaman (Hazard) gempa bumi memiliki magnitudo yang identik.",
                "Risiko Kota A lebih rendah karena populasi Kota A lebih dinamis menyikapi bencana.",
                "Risiko Kota A jauh lebih tinggi karena memiliki kerentanan fisik/sosial (Vulnerability) yang tinggi dan kapasitas (Capacity) kelola yang minim.",
                "Risiko Kota B lebih tinggi karena struktur antiseismic membutuhkan biaya perawatan tinggi yang menambah beban ekonomi."
            ),
            correctAnswerIndex = 2,
            explanation = "Formula risiko bencana RB = (H * V) / C menunjukkan bahwa risiko berbanding lurus dengan Bahaya (H) dan Kerentanan (V), serta berbanding terbalik dengan Kapasitas (C). Meskipun fisik gempanya sama, minimnya standar konstruksi (kerentanan fisik tinggi) dan kurangnya latihan (kapasitas rendah) di Kota A menaikkan indeks risiko bencananya secara drastis."
        ),
        Question(
            id = 6,
            category = "Kebencanaan dan Manajemen Bencana",
            caseTitle = "Studi Kasus: Likuefaksi Palu 2018",
            scenario = "Setelah gempa kuat mengguncang Kota Palu tahun 2018, beberapa pemukiman seperti Balaroa dan Petobo mengalami fenomena tanah meleleh dan mengalir seperti lumpur cair, menenggelamkan ratusan rumah.",
            questionText = "Kombinasi kondisi geologis apa yang memicu terjadinya likuefaksi masif secara mekanis di daerah aliran tersebut?",
            options = listOf(
                "Batuan sedimen kapur yang larut dengan cepat akibat hujan asam ekstrem setelah gempa bumi.",
                "Adanya akumulasi gas metana bawah tanah yang bocor dan mengalami kompresi akibat getaran seismos.",
                "Tanah berupa sedimen pasir jenuh air yang longgar serta keberadaan muka air tanah dangkal yang tergoncang gempa, meningkatkan tekanan air pori hingga tanah kehilangan kekuatan gesernya.",
                "Semburan lumpur panas vulkanik dari sesar Palu-Koro aktif yang langsung melelehkan aspal pemukiman."
            ),
            correctAnswerIndex = 2,
            explanation = "Likuefaksi terjadi pada sedimen berbutir kasar-sedang (pasir) yang longgar, tidak terkonsolidasi, serta jenuh air. Getaran gempa memberikan guncangan cepat dan berulang, memaksa partikel air pori di celah butir pasir tertekan kencang. Ketika tekanan air pori menyamai berat beban di atasnya, butiran pasir mengapung bebas, kekuatan geser tanah jatuh ke nol, dan tanah berperilaku sebagai cairan."
        ),

        // Topic 4: Sumberdaya dan Manajemen Sumberdaya
        Question(
            id = 7,
            category = "Sumberdaya dan Manajemen Sumberdaya",
            caseTitle = "Studi Kasus: Pengembangan Energi Panas Bumi (Geothermal) Indonesia",
            scenario = "Indonesia memiliki potensi geothermal terbesar di dunia (mencapai 40% potensi dunia) karena dilewati jalur vulkanik aktif (Cincin Api Pasifik). Di sisi lain, biaya eksplorasi di hulu sangat mahal dan rentan menghadapi konflik lahan hutan konservasi.",
            questionText = "Langkah pengelolaan strategis berkelanjutan apa yang paling ramah ekologi untuk memaksimalkan energi panas bumi ini?",
            options = listOf(
                "Melakukan penebangan total hutan sekitar gunung demi perluasan turbin turbogenerator raksasa.",
                "Meminimalkan footprint proyek dengan teknologi pengeboran miring (directional drilling) agar kepala sumur berada di luar area sensitif ekologis hutan lindung.",
                "Mengganti bahan bakar fluida uap alami gunung dengan aliran solar agar pembakaran lebih hemat air.",
                "Melakukan eksploitasi di sisa-sisa gunungapi purba yang sama sekali tidak memiliki hutan lindung."
            ),
            correctAnswerIndex = 1,
            explanation = "Directional drilling (pengeboran miring) memungkinkan pengambilan cadangan uap panas bumi bermutu tinggi di bawah hutan lindung tanpa harus menebang atau menempatkan instalasi berat di dalam hutan sensitif. Hal ini mempertemukan aspek ketahanan energi dan konservasi lingkungan."
        ),
        Question(
            id = 8,
            category = "Sumberdaya dan Manajemen Sumberdaya",
            caseTitle = "Studi Kasus: Pengelompokan Bahan Galian Tambang Indonesia",
            scenario = "Berdasarkan rujukan UU No. 11 Tahun 1967 tentang Ketentuan Pokok Pertambangan bahan galian dikelompokkan menjadi Golongan A (Strategis), Golongan B (Vital), dan Golongan C (Industri).",
            questionText = "Mana dari klasifikasi berikut yang merupakan bahan galian Golongan A dan jelaskan kepentingannya bagi pertahanan negara?",
            options = listOf(
                "Emas, Perak, dan Tembaga; penting untuk perhiasan kelas tinggi.",
                "Pasir Kuarsa, Kaolin, dan Batu Kapur; penting untuk semen ekspor pertahanan pangkalan laut.",
                "Minyak Bumi, Batu Bara, dan Uranium; sangat krusial untuk menjaga kedaulatan energi serta pertahanan ekonomi negara.",
                "Gipsum, Marmer, dan Granit; penting untuk membangun benteng militer yang luar biasa kokoh."
            ),
            correctAnswerIndex = 2,
            explanation = "Bahan galian Golongan A (Strategis) adalah mineral/bahan tambang yang berperan strategis untuk pertahanan dan keamanan serta stabilitas ekonomi nasional (seperti energi: Minyak bumi, Batu Bara, Uranium, Gas Alam). Keberadaannya mengontrol hajat hidup operasional industri pertahanan bertenaga tinggi."
        ),

        // Topic 5: Geografi Lingkungan dan Pembangunan Berkelanjutan
        Question(
            id = 9,
            category = "Geografi Lingkungan dan Pembangunan",
            caseTitle = "Studi Kasus: Kebocoran Lapisan Ozon & Protokol Montreal",
            scenario = "Pada akhir abad ke-20, para ilmuwan mendeteksi adanya penipisan lapisan ozon (O3) di stratosfer, terutama di atas kutub selatan. Fenomena ini berbahaya karena membiarkan sinar UV-B masuk tanpa filter ke bumi, memicu kanker kulit dan kepunahan plankton laut.",
            questionText = "Perjanjian internasional dan agen kimia apa yang paling bertanggung jawab mengendalikan ancaman lingkungan global ini?",
            options = listOf(
                "Protokol Kyoto; mengontrol emisi sulfur dioksida dari asap cerobong pabrik batubara.",
                "Protokol Montreal; membatasi dan menghapus penggunaan Chlorofluorocarbon (CFC) yang mengatalisis penguraian ozon secara berantai.",
                "Konvensi Basel; mengatur perdagangan internasional logam berat sisa baterai elektronik.",
                "Protokol Paris; membatasi pelebaran deforestasi akibat alih fungsi lahan sawit."
            ),
            correctAnswerIndex = 1,
            explanation = "Protokol Montreal (1987) dirancang khusus untuk mengurangi produksi dan konsumsi bahan perusak ozon (BPO), terutama CFC yang melepaskan radikal klorin di stratosfer saat terpapar sinar matahari. Satu atom klorin mampu memecah puluhan ribu molekul ozon (O3) secara katalitis."
        ),
        Question(
            id = 10,
            category = "Geografi Lingkungan dan Pembangunan",
            caseTitle = "Studi Kasus: Siklus Hidrologi & Krisis Air Bersih di Jakarta",
            scenario = "Penurunan permukaan tanah (land subsidence) Jakarta terjadi hingga 10-15 cm per tahun akibat eksploitasi air air bawah tanah (aquifer) secara besar-besaran, diperparah betonirisasi lahan.",
            questionText = "Proses fisik siklus hidrologi apa yang mengalami gangguan terbesar akibat betonirisasi tersebut?",
            options = listOf(
                "Transpirasi; penguapan vegetasi taman kota terhenti total.",
                "Infiltrasi; air hujan tidak dapat meresap ke dalam pori tanah dan langsung mengalir sebagai limpasan permukaan (run-off).",
                "Evaporasi; penguapan sungai terhambat endapan sampah padat.",
                "Kondensasi; pembentukan awan kumulus terganggu polusi aerosol industri."
            ),
            correctAnswerIndex = 1,
            explanation = "Penutupan permukaan tanah oleh semen dan aspal (betonirisasi) memblokir proses infiltrasi air hujan menuju zona akuifer tanah. Air limpasan (run-off) langsung membanjiri saluran air permukaan mengalir kotor ke laut, sementara volume air bawah tanah menyusut memicu rongga kering kolaps yang mempercepat penurunan tanah."
        ),

        // Topic 6: Perubahan Roman Muka Bumi dan Bentangalam
        Question(
            id = 11,
            category = "Perubahan Roman Muka Bumi",
            caseTitle = "Studi Kasus: Karst Gunung Kidul (Bentangalam Karst)",
            scenario = "Wilayah Gunung Sewu di Gunung Kidul terbentuk dari batugamping (limestone) yang sangat luas. Di permukaan terlihat gersang dan sulit air, namun di bagian dalam tanah tersimpan aliran air sungai purba bawah tanah yang melimpah.",
            questionText = "Proses geomorfologis apa yang melatarbelakangi terbentuknya karakteristik bentangalam unik ini?",
            options = listOf(
                "Proses abrasi laut dalam yang melubangi tebing dasar daratan kapur secara bertahap.",
                "Sistem erosi glasial purba yang memahat lembah gletser berbentuk U di celah retakan batuan.",
                "Proses pelarutan kimiawi (karstifikasi) oleh air meteorit bersenyawa CO2 asam, membentuk corong ponor/sinkhole dan diagenesis goa pelarutan bawah tanah.",
                "Semburan lava andesit yang melelehkan batugamping hingga menyisakan sisa lorong-lorong berlubang."
            ),
            correctAnswerIndex = 2,
            explanation = "Kawasan karst dicirikan oleh batuan karbonat yang mudah larut. Air hujan bereaksi dengan gas CO2 di atmosfer menciptakan asam karbonat lemah (H₂CO₃). Larutan asam ini mengalir ke celah batugamping (CaCO₃), melarutkannya menjadi kalsium bikarbonat terlarut, menciptakan lubang pembuangan (sinkhole/dolina) dan melahirkan jalur air drainase gua bawah tanah."
        ),
        Question(
            id = 12,
            category = "Perubahan Roman Muka Bumi",
            caseTitle = "Studi Kasus: Degradasi Danau Tapal Kuda (Oxbow Lake)",
            scenario = "Danau tapal kuda terbentuk dari sistem sungai meander yang meliuk-liuk di dataran rendah. Dalam kurun waktu ratusan tahun, danau ini dapat terputus sepenuhnya dari aliran induk sungai.",
            questionText = "Proses sedimentasi dan erosi mana yang bekerja aktif melahirkan fenomena sungai pemotongan leher meander ini?",
            options = listOf(
                "Erosi lateral di bagian tebing luar lekukan (cut-bank) dikombinasikan dengan deposisi di bagian tebing dalam lekukan (point-bar) hingga leher sungai menyempit dan jebol.",
                "Erosi vertikal di dasar sungai menggali parit yang tegak lurus lekuk air.",
                "Proses tiupan angin eolian menggeser gumuk pasir hingga menyumbat saluran utama sungai.",
                "Tektonik patahan naik yang mengangkat bagian hulu sungai secara mendadak."
            ),
            correctAnswerIndex = 0,
            explanation = "Air meander mengalir paling deras di bagian tebing luar karena gaya sentrifugal (mengakibatkan erosi cut-bank), sedangkan di bagian tebing dalam air mengalir lambat sehingga terjadi pengendapan material lumpur-pasir (point-bar). Lekukan luar yang terus terkikis lambat laun menyatu, memotong aliran dan membuat sungai mengalir lurus saat debit air banjir besar, menyisakan danau melengkung (oxbow lake)."
        ),

        // Topic 7: Pertanian dan Permasalahan Pangan
        Question(
            id = 13,
            category = "Pertanian dan Permasalahan Pangan",
            caseTitle = "Studi Kasus: Konservasi Lahan Lereng Pegunungan (Terasering)",
            scenario = "Para petani di lereng terjal Gunung Merbabu menanam sayuran dengan metode sengkedan/teraserisasi bertingkat dilengkapi tanggul pemotong air, alih-alih mencangkul lurus dari atas ke bawah lereng.",
            questionText = "Mengapa metode konservasi mekanis ini terbukti efektif mencegah terjadinya tanah longsor dan erosi parah saat musim hujan lebat?",
            options = listOf(
                "Karena terasering menghentikan seluruh penguapan air tanah di lapisan tipis humus sayuran.",
                "Terasering memperpendek panjang lereng, mengurangi kecepatan aliran limpasan permukaan (run-off), serta memberi waktu air berinfiltrasi ke dalam tanah.",
                "Struktur tangga sengkedan meningkatkan gaya kohesi molekul humus kapur menjadi sangat pejal.",
                "Terasering menarik cacing tanah dalam jumlah masif untuk memadatkan kerikil lereng secara biologis."
            ),
            correctAnswerIndex = 1,
            explanation = "Erosivitas tanah akibat hujan berbanding lurus dengan panjang dan kemiringan lereng. Terasering memotong lereng yang panjang menjadi bagian-bagian datar pendek, mereduksi energi kinetik air run-off (mencegah erosi alur/gully erosion), dan menstimulasi infiltrasi tertib di setiap petak."
        ),
        Question(
            id = 14,
            category = "Pertanian dan Permasalahan Pangan",
            caseTitle = "Studi Kasus: Masalah Keasaman Tanah Ultisol (Tanah Merah)",
            scenario = "Di Sumatra dan Kalimantan, banyak ditemui tanah Ultisol (tanah podsolik merah kuning) yang kurang subur untuk jenis tanaman pangan semusim karena rentan bersifat sangat asam (pH < 5) dan miskin kandungan unsur hara makro akibat pencucian (leaching) intensif.",
            questionText = "Tindakan perbaikan tanah (soil amandemen) apa yang paling tepat untuk menaikkan produktivitas sayuran di tanah Ultisol tersebut?",
            options = listOf(
                "Melakukan pembakaran gulma kering secara serentak sebelum penanaman.",
                "Pemberian kapur pertanian (kalsit/dolomit) untuk menaikkan pH tanah serta menetralisasi toksisitas aluminium terlarut.",
                "Menyiram air garam jenuh secara merata untuk mengikat partikel silikon tanah.",
                "Memasukkan asam belerang murni demi melepaskan ikatan fosfor terperangkap."
            ),
            correctAnswerIndex = 1,
            explanation = "Tanah masam memiliki konsentrasi H⁺ yang tinggi dan kelarutan Aluminium (Al³⁺) yang meracuni akar tanaman. Penambahan kapur (CaCO₃ atau CaMg(CO₃)₂) melepaskan ion Ca²⁺ yang akan menukar ion H⁺ dan mengendapkan aluminium menjadi senyawa tidak larut mendisplay pH tanah mendekati netral (6 - 7)."
        ),

        // Topic 8: Kependudukan dan Dinamika Penduduk
        Question(
            id = 15,
            category = "Kependudukan dan Dinamika Penduduk",
            caseTitle = "Studi Kasus: Bonus Demografi & Rasio Ketergantungan (Dependency Ratio)",
            scenario = "Berdasarkan rilis proyeksi BPS, Indonesia diprediksi menikmati puncak Bonus Demografi pada periode 2025-2035, ditandai dengan angka Rasio Ketergantungan (Dependency Ratio) yang sangat rendah.",
            questionText = "Apa implikasi ekonomis-demografis dari rendahnya Rasio Ketergantungan tersebut bagi kesejahteraan masyarakat?",
            options = listOf(
                "Jumlah penduduk usia lanjut (lansia) melonjak naik tanpa ada jaminan perawatan jaminan sosial.",
                "Setiap 100 orang penduduk produktif (usia 15-64 tahun) menanggung beban beban hidup sedikit penduduk non-produktif (usia <15 tahun dan 65+ tahun), membuka ruang investasi tabungan keluarga yang tinggi.",
                "Angka kelahiran bayi melesat tinggi mendorong pemenuhan susu impor secara radikal.",
                "Migrasi penduduk ke luar negeri meningkat ekstrem akibat minimnya lapangan pekerjaan konstruktif di dalam negeri."
            ),
            correctAnswerIndex = 1,
            explanation = "Rasio ketergantungan dihitung dari persentase penduduk non-produktif (anak-anak dan lansia) dibagi penduduk usia produktif dikali 100. Rasio yang rendah berarti beban bagi kelompok produktif ringan. Jika kelompok produktif diserap lapangan kerja secara produktif, tabungan keluarga dan negara melimpah untuk melecut pertumbuhan ekonomi makro."
        ),
        Question(
            id = 16,
            category = "Kependudukan dan Dinamika Penduduk",
            caseTitle = "Studi Kasus: Pertumbuhan Penduduk Menurut Teori Thomas Malthus",
            scenario = "Thomas Malthus mengemukakan tesis terkenalnya bahwa pertumbuhan penduduk cenderung mengikuti deret ukur (1, 2, 4, 8, 16...), sedangkan pertumbuhan bahan makanan mengikuti deret hitung (1, 2, 3, 4, 5...).",
            questionText = "Apa kritik terbesar dari para ahli geografi ekonomi modern terhadap keabsahan teori pesimistis Malthus ini?",
            options = listOf(
                "Malthus mengabaikan faktor peperangan masif yang menurunkan populasi secara cepat.",
                "Malthus meremehkan lompatan teknologi pertanian (Revolusi Hijau, Bioteknologi) yang melipatgandakan produksi pangan melewati batas deret hitung konvensional.",
                "Malthus tidak memperhitungkan pergeseran pola makan vegetarian global.",
                "Malthus mengira bumi tidak memiliki lahan kosong tersisa di gurun pasir Afrika."
            ),
            correctAnswerIndex = 1,
            explanation = "Kelemahan utama analisis Malthus (1798) adalah ketidakmampuannya memprediksi lompatan teknologi ilmiah yang pesat di bidang pertanian, seperti mekanisasi, varietas hibrida unggul hasil rekayasa genetik, irigasi elektrik, dan pupuk sintetis yang melipatgandakan pasokan pangan secara dinamis."
        ),

        // Topic 9: Geografi Ekonomi
        Question(
            id = 17,
            category = "Geografi Ekonomi",
            caseTitle = "Studi Kasus: Relokasi Industri Semen (Teori Lokasi Alfred Weber)",
            scenario = "Berdasarkan Teori Lokasi Industri Alfred Weber, penentuan lokasi pabrik didasarkan pada minimalisasi biaya transportasi. Industri semen membutuhkan bahan baku batu gamping dan lempung tanah liat yang sangat berat untuk digiling, sedangkan produk akhirnya (semen) mengalami penurunan berat yang masif dibanding bahan mentahnya.",
            questionText = "Menurut teori Weber, pabrik semen tersebut idealnya didirikan di mana?",
            options = listOf(
                "Di dekat pasar konsumen perkotaan guna menghemat ongkos distribusi sak semen.",
                "Di dekat sumber bahan baku batu gamping karena indeks material (IM) > 1 (material penyusutan berat besar).",
                "Tepat di tengah-tengah antara lokasi tambang dan perkotaan pelabuhan logistik.",
                "Di dekat perumahan buruh murah agar biaya tenaga upah buruh serendah mungkin."
            ),
            correctAnswerIndex = 1,
            explanation = "Semen merupakan industri yang mengalami penyusutan berat bahan tambang (weight-losing industry). Sesuai teori Weber, jika berat bahan mentah lebih besar dari berat produk jadi, maka Indeks Material (IM) > 1, yang berarti penentuan lokasi industri harus berorientasi ke arah sumber bahan baku (raw-material oriented) untuk memangkas membengkaknya biaya angkut material berat di awal."
        ),
        Question(
            id = 18,
            category = "Geografi Ekonomi",
            caseTitle = "Studi Kasus: Zonasi Pola Pertanian Teori Johann Heinrich von Thünen",
            scenario = "Teori lokasional von Thünen membagi pemanfaatan lahan pertanian dalam cincin konsentris mengelilingi pasar terpusat. Cincin pertama ditempati oleh pertanian hortikultura sayuran dan peternakan susu segar.",
            questionText = "Mengapa komoditas hortikultura sayuran ditempatkan di cincin paling dekat dengan pasar pusat?",
            options = listOf(
                "Karena sayuran membutuhkan perlindungan polusi asap kota yang padat.",
                "Karena sayuran sangat ringkih (cepat rusak/busuk) dan memiliki biaya angkut per kilometer yang relatif tinggi sehingga harus dikirim secepatnya.",
                "Pemerintah kota melarang sayuran ditanam dekat hutan hutan liar terpencil.",
                "Sewa tanah sayur di pinggiran jauh bernilai sangat mahal."
            ),
            correctAnswerIndex = 1,
            explanation = "Kombinasi antara kerentanan barang busuk (perishability) dan tingginya biaya transportasi komoditas segar menentukan letak hortikultura di cincin pertama. Karena keuntungannya per unit tinggi dan biaya transport per km mahal, penanaman di dekat kota memaksakan sewa lahan yang kompetitif."
        ),

        // Topic 10: Pariwisata dan Manajemen Pariwisata
        Question(
            id = 19,
            category = "Pariwisata dan Manajemen Pariwisata",
            caseTitle = "Studi Kasus: Ekoturisme di Taman Nasional Komodo",
            scenario = "Taman Nasional Komodo dinobatkan sebagai situs warisan dunia UNESCO. Di sisi lain, peningkatan wisatawan massal (mass-tourism) mengancam kerusakan terumbu karang dan mengganggu perilaku berburu komodo akibat polusi suara sampah plastik.",
            questionText = "Kebijakan pariwisata berkelanjutan apa yang paling selaras dengan prinsip daya dukung (carrying capacity) ekologi?",
            options = listOf(
                "Meningkatkan penerbangan komersial langsung tanpa menyaring profil wisatawan yang datang.",
                "Penerapan kuota kunjungan harian yang ketat lewat sistem pendaftaran digital dikawinkan dengan tarif retribusi khusus untuk dana konservasi alam liar.",
                "Membangun resor bertingkat tinggi di bibir habitat pantai bersarang komodo demi kenyamanan absolut.",
                "Memindahkan seluruh komodo ke kandang-kandang sirkus tertib di luar pulau NTT."
            ),
            correctAnswerIndex = 1,
            explanation = "Konsep carrying capacity (daya dukung) mengasumsikan batas maksimal pemakaian lingkungan oleh manusia sebelum ekosistem kolaps. Pembatasan kuota pengunjung, mitigasi reservasi digital, dan retribusi konservasi menekan laju degradasi flora-fauna endemik tropis."
        ),
        Question(
            id = 20,
            category = "Pariwisata dan Manajemen Pariwisata",
            caseTitle = "Studi Kasus: Implementasi Sapta Pesona di Desa Wisata",
            scenario = "Sapta Pesona adalah tujuh kondisi kepariwisataan di Indonesia yang wajib diimplementasikan, meliputi Aman, Tertib, Bersih, Sejuk, Indah, Ramah, dan Kenangan.",
            questionText = "Manakah tindakan berikut yang menggambarkan penerapan Sapta Pesona unsur 'Ramah' sekaligus 'Kenangan' secara integratif?",
            options = listOf(
                "Menjual cinderamata unik buatan tangan penduduk lokal yang disertai senyum hangat serta penjelasan filosofis sejarah desa wisata tersebut.",
                "Membangun pintu gerbang pengamanan berlapis baja dengan pemeriksaan ketat militeristik.",
                "Memasang lampu hias disko warna-warni di sepanjang jalan rindang pepohonan desa wisata.",
                "Mematok tarif foto bersama hewan langka desa setinggi-tingginya agar turis mengingat harganya."
            ),
            correctAnswerIndex = 0,
            explanation = "Unsur 'Ramah' ditunjukkan lewat sikap keramahan dan keterbukaan penduduk lokal menyambut turis, sementara 'Kenangan' diciptakan dari pengalaman mendalam bernilai estetis yang dibawakan lewat cinderamata lokal otentik berisikan cerita khas desa."
        )
    )
}
