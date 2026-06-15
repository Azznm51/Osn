package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.local.UserScore
import com.example.data.model.QuestionProvider
import com.example.data.model.StudyTopic
import com.example.data.model.StudyTopicProvider
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.ui.theme.*
import com.example.ui.viewmodel.Badge
import com.example.ui.viewmodel.QuizViewModel
import com.example.ui.viewmodel.Screen
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MainQuizApp(viewModel: QuizViewModel) {
    val scores by viewModel.allScores.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            if (viewModel.currentScreen != Screen.QuizActive) {
                GeosnBottomBar(currentScreen = viewModel.currentScreen, onNavigate = { viewModel.navigateTo(it) })
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (viewModel.currentScreen) {
                Screen.Dashboard -> DashboardScreen(viewModel = viewModel, scores = scores)
                Screen.MateriList -> MateriListScreen(viewModel = viewModel)
                Screen.MateriDetail -> {
                    viewModel.selectedTopic?.let { topic ->
                        MateriDetailScreen(viewModel = viewModel, topic = topic)
                    }
                }
                Screen.QuizPrep -> QuizPrepScreen(viewModel = viewModel)
                Screen.QuizActive -> QuizActiveScreen(viewModel = viewModel)
                Screen.QuizSummary -> QuizSummaryScreen(viewModel = viewModel)
                Screen.Stats -> StatsScreen(viewModel = viewModel, scores = scores)
            }
        }
    }
}

@Composable
fun GeosnBottomBar(currentScreen: Screen, onNavigate: (Screen) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        tonalElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomTabItem(
                icon = Icons.Default.Home,
                label = "Dasbor",
                isActive = currentScreen == Screen.Dashboard || currentScreen == Screen.MateriDetail,
                onClick = { onNavigate(Screen.Dashboard) },
                testTag = "tab_dashboard"
            )
            BottomTabItem(
                icon = Icons.Default.Book,
                label = "Materi",
                isActive = currentScreen == Screen.MateriList,
                onClick = { onNavigate(Screen.MateriList) },
                testTag = "tab_materi"
            )
            BottomTabItem(
                icon = Icons.Default.PlayArrow,
                label = "Latihan",
                isActive = currentScreen == Screen.QuizPrep,
                onClick = { onNavigate(Screen.QuizPrep) },
                testTag = "tab_quiz"
            )
            BottomTabItem(
                icon = Icons.Default.Assessment,
                label = "Progres",
                isActive = currentScreen == Screen.Stats,
                onClick = { onNavigate(Screen.Stats) },
                testTag = "tab_stats"
            )
        }
    }
}

@Composable
fun BottomTabItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    isActive: Boolean,
    onClick: () -> Unit,
    testTag: String
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .testTag(testTag)
            .minimumInteractiveComponentSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (isActive) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = 0.5f),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                color = if (isActive) MaterialTheme.colorScheme.primary else Color.Gray
            )
        }
    }
}

// ----------------------------------------------------
// GEOGRAPHY CUSTOM DRAWN ILLUSTRATIONS
// ----------------------------------------------------
@Composable
fun GeographyIllustration(topicName: String, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(width, height) * 0.4f

        when (topicName) {
            "Cuaca dan Iklim" -> {
                // Draw Sun
                drawCircle(color = AccentClay, radius = radius * 0.6f, center = Offset(centerX - 10f, centerY - 10f))
                // Draw Cloud
                val path = Path().apply {
                    moveTo(centerX - 30f, centerY + 30f)
                    cubicTo(centerX - 60f, centerY + 10f, centerX - 50f, centerY - 30f, centerX - 20f, centerY - 20f)
                    cubicTo(centerX - 10f, centerY - 45f, centerX + 30f, centerY - 45f, centerX + 40f, centerY - 20f)
                    cubicTo(centerX + 70f, centerY - 20f, centerX + 70f, centerY + 15f, centerX + 50f, centerY + 30f)
                    close()
                }
                drawPath(path = path, color = SecondarySky.copy(alpha = 0.85f))
            }
            "Oseanografi" -> {
                // Wave paths
                val wavePath1 = Path().apply {
                    moveTo(0f, centerY)
                    cubicTo(width * 0.25f, centerY - 30f, width * 0.5f, centerY + 30f, width, centerY - 10f)
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                }
                drawPath(path = wavePath1, color = PrimaryNavy.copy(alpha = 0.8f))
                val wavePath2 = Path().apply {
                    moveTo(0f, centerY + 15f)
                    cubicTo(width * 0.25f, centerY + 35f, width * 0.5f, centerY - 15f, width, centerY + 20f)
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                }
                drawPath(path = wavePath2, color = SecondarySky.copy(alpha = 0.6f))
            }
            "Kebencanaan dan Manajemen Bencana" -> {
                // Volcano Triangle
                val mtPath = Path().apply {
                    moveTo(centerX, centerY - 45f)
                    lineTo(centerX - 60f, centerY + 50f)
                    lineTo(centerX + 60f, centerY + 50f)
                    close()
                }
                drawPath(path = mtPath, color = Color(0xFF4A5568)) // Mountain Slate
                
                // Crater fire
                drawCircle(color = AccentClay, radius = 15f, center = Offset(centerX, centerY - 40f))
                drawCircle(color = Color.Yellow, radius = 8f, center = Offset(centerX, centerY - 40f))
            }
            "Sumberdaya dan Manajemen Sumberdaya" -> {
                // Solar panel + coal lines diagram
                drawRoundRect(
                    color = ForestGreen,
                    topLeft = Offset(centerX - 40f, centerY - 40f),
                    size = Size(80f, 80f),
                    cornerRadius = CornerRadius(8f, 8f)
                )
                // Grid lines (Solar look)
                drawLine(color = Color.White, start = Offset(centerX - 40f, centerY), end = Offset(centerX + 40f, centerY), strokeWidth = 2f)
                drawLine(color = Color.White, start = Offset(centerX, centerY - 40f), end = Offset(centerX, centerY + 40f), strokeWidth = 2f)
                // Diamond star
                drawCircle(color = Color.Yellow, radius = 10f, center = Offset(centerX, centerY))
            }
            "Geografi Lingkungan dan Pembangun" -> {
                // Earth Globe silhouette
                drawCircle(color = SecondarySky.copy(alpha = 0.2f), radius = radius, center = Offset(centerX, centerY))
                drawCircle(color = ForestGreen.copy(alpha = 0.7f), radius = radius * 0.6f, center = Offset(centerX - 10f, centerY - 5f))
                drawCircle(color = ForestGreen.copy(alpha = 0.7f), radius = radius * 0.5f, center = Offset(centerX + 15f, centerY + 10f))
                drawCircle(
                    color = PrimaryNavy,
                    radius = radius,
                    center = Offset(centerX, centerY),
                    style = Stroke(width = 4f)
                )
            }
            "Perubahan Roman Muka Bumi" -> {
                // Winding meander curves
                val stream = Path().apply {
                    moveTo(0f, centerY - 30f)
                    cubicTo(width * 0.3f, centerY - 60f, width * 0.3f, centerY + 40f, width * 0.6f, centerY)
                    cubicTo(width * 0.8f, centerY - 25f, width * 0.9f, centerY + 30f, width, centerY - 10f)
                }
                drawPath(path = stream, color = SecondarySky, style = Stroke(width = 12f))
            }
            "Pertanian dan Permasalahan Pangan" -> {
                // Ground soil layers with green plant
                drawRoundRect(color = AccentClay, topLeft = Offset(centerX - 50f, centerY + 10f), size = Size(100f, 35f), cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx()))
                // Stem
                val leafStem = Path().apply {
                    moveTo(centerX, centerY + 10f)
                    quadraticTo(centerX - 15f, centerY - 15f, centerX - 10f, centerY - 30f)
                }
                drawPath(path = leafStem, color = ForestGreen, style = Stroke(width = 5f))
                // Leaves
                drawCircle(color = ForestGreen, radius = 10f, center = Offset(centerX - 15f, centerY - 25f))
                drawCircle(color = ForestGreen, radius = 10f, center = Offset(centerX + 5f, centerY - 15f))
            }
            "Kependudukan dan Dinamika Penduduk" -> {
                // Pyramid graph blocks
                drawRoundRect(color = SecondarySky, topLeft = Offset(centerX - 50f, centerY - 25f), size = Size(40f, 15f))
                drawRoundRect(color = AccentClay, topLeft = Offset(centerX + 10f, centerY - 25f), size = Size(40f, 15f))

                drawRoundRect(color = SecondarySky, topLeft = Offset(centerX - 60f, centerY), size = Size(50f, 15f))
                drawRoundRect(color = AccentClay, topLeft = Offset(centerX + 10f, centerY), size = Size(50f, 15f))

                drawRoundRect(color = SecondarySky, topLeft = Offset(centerX - 35f, centerY + 25f), size = Size(25f, 15f))
                drawRoundRect(color = AccentClay, topLeft = Offset(centerX + 10f, centerY + 25f), size = Size(25f, 15f))
            }
            "Geografi Ekonomi" -> {
                // Growing Bars + Stack of Coins
                drawRoundRect(color = ForestGreen, topLeft = Offset(centerX - 35f, centerY + 10f), size = Size(15f, 30f))
                drawRoundRect(color = ForestGreen, topLeft = Offset(centerX - 12f, centerY - 10f), size = Size(15f, 50f))
                drawRoundRect(color = AccentClay, topLeft = Offset(centerX + 12f, centerY - 30f), size = Size(15f, 70f))
            }
            "Pariwisata dan Manajemen Pariwisata" -> {
                // Compass Rose
                drawCircle(color = PrimaryNavy, radius = radius * 0.8f, center = Offset(centerX, centerY), style = Stroke(width = 3f))
                // Compass Needle
                val needle = Path().apply {
                    moveTo(centerX, centerY - radius)
                    lineTo(centerX + 12f, centerY)
                    lineTo(centerX, centerY + radius)
                    lineTo(centerX - 12f, centerY)
                    close()
                }
                drawPath(path = needle, color = AccentClay)
                // Center point
                drawCircle(color = Color.White, radius = 6f, center = Offset(centerX, centerY))
            }
            else -> {
                // Fallback earth globe icon
                drawCircle(color = SecondarySky, radius = radius, center = Offset(centerX, centerY))
            }
        }
    }
}

// ----------------------------------------------------
// SCREEN 1: DASHBOARD
// ----------------------------------------------------
@Composable
fun DashboardScreen(viewModel: QuizViewModel, scores: List<UserScore>) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        // Welcome and Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Halo Geografer Muda! 🌍",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Persiapan OSN Geografi Terbaik",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🎓", fontSize = 24.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // READINESS GAUGE CARD
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Radial readiness draw
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val progress = viewModel.getReadinessProgress(scores)
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawArc(
                                color = Color.White.copy(alpha = 0.25f),
                                startAngle = 0f,
                                sweepAngle = 360f,
                                useCenter = false,
                                style = Stroke(width = 10f)
                            )
                            drawArc(
                                color = Color.White,
                                startAngle = -90f,
                                sweepAngle = progress * 360f,
                                useCenter = false,
                                style = Stroke(width = 10f)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "${(progress * 100).toInt()}%",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = "Kesiapan",
                                color = Color.White.copy(alpha = 0.8f),
                                fontSize = 9.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Tingkat Kesiapan OSN",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        val textFeedback = if (scores.isEmpty()) {
                            "Belum ada data kuis. Selesaikan minimal 1 kuis untuk melacak kesiapan OSN-mu secara real-time!"
                        } else {
                            val accuracy = viewModel.getAccuracyPercent(scores)
                            when {
                                accuracy >= 80 -> "Luar biasa! Akurasi belajarmu sangat tinggi. Kamu siap merebut medali emas!"
                                accuracy >= 60 -> "Bagus! Terus asah materi geografimu untuk menyempurnakan kesiapan bertanding."
                                else -> "Ayo tingkatkan porsi belajar! Luangkan lebih banyak waktu membaca modul rangkuman kami."
                            }
                        }
                        Text(
                            text = textFeedback,
                            color = Color.White.copy(alpha = 0.9f),
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // QUICK LINKS / SUBJECT COUNT STATE
        Text(
            text = "Kompilasi Materi OSN",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WidgetCounter(title = "Topik Materi", count = "10 Cabang", icon = "📚", onClick = { viewModel.navigateTo(Screen.MateriList) })
            WidgetCounter(
                title = "Total Soal HOTS",
                count = "${QuestionProvider.questions.size} Soal",
                icon = "🔥",
                onClick = { viewModel.navigateTo(Screen.QuizPrep) }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // ACHIEVEMENTS / BADGES
        Text(
            text = "Pencapaian & Medali Belajar",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(10.dp))

        val badges = viewModel.getEarnedBadges(scores)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            badges.forEach { badge ->
                BadgeItem(badge = badge)
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // DAILY MOTIVATION
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color(0xFFEADDFF)), RoundedCornerShape(28.dp)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "💡", fontSize = 28.sp)
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "Trivia Hari Ini",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "\"Geografi bukanlah sekadar menghafal nama kota atau peta; geografi adalah pemahaman mendalam tentang bagaimana sistem kehidupan bumi berinteraksi secara spasial.\"",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        color = Color.DarkGray,
                        lineHeight = 18.sp
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun WidgetCounter(title: String, count: String, icon: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .clickable { onClick() }
            .border(BorderStroke(1.dp, Color(0xFFEADDFF)), RoundedCornerShape(28.dp)),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = icon, fontSize = 28.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = count, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = title, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun BadgeItem(badge: Badge) {
    val opacity = if (badge.isEarned) 1.0f else 0.35f
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(
                        if (badge.isEarned) MaterialTheme.colorScheme.tertiary.copy(alpha = 0.15f)
                        else Color.LightGray.copy(alpha = 0.2f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (badge.isEarned) "🏅" else "🔒",
                    fontSize = 26.sp,
                    modifier = Modifier.drawBehind {
                        // draw indicator circle
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = badge.name,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = if (badge.isEarned) MaterialTheme.colorScheme.primary else Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = badge.description,
                fontSize = 9.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                lineHeight = 11.sp,
                modifier = Modifier.height(24.dp)
            )
        }
    }
}

// ----------------------------------------------------
// SCREEN 2: MATERI LIST
// ----------------------------------------------------
@Composable
fun MateriListScreen(viewModel: QuizViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Eksplorasi Modul Pembelajaran",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Pilih salah satu dari 10 bab navigasi geografi fisik, sosial, dan ekonomi untuk dibaca.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(StudyTopicProvider.topics.size) { index ->
                val topic = StudyTopicProvider.topics[index]
                MateriTopicCard(topic = topic, onClick = { viewModel.selectTopic(topic) }, index = index)
            }
        }
    }
}

@Composable
fun MateriTopicCard(topic: StudyTopic, onClick: () -> Unit, index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(BorderStroke(1.dp, Color(0xFFEADDFF)), RoundedCornerShape(28.dp))
            .testTag("materi_card_${index + 1}"),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(65.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
            ) {
                GeographyIllustration(
                    topicName = topic.title,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${index + 1}. ${topic.title}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = topic.description,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Buka",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(20.dp).drawBehind {
                    // rotate arrow to point right
                }
            )
        }
    }
}

// ----------------------------------------------------
// SCREEN 3: MATERI DETAIL
// ----------------------------------------------------
@Composable
fun MateriDetailScreen(viewModel: QuizViewModel, topic: StudyTopic) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        // Back Navigation
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { viewModel.navigateTo(Screen.MateriList) }
                .padding(bottom = 15.dp)
                .testTag("materi_back_btn")
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Kembali ke Modul",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Kembali ke Modul",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        // Title and Big Illustration
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
            ) {
                GeographyIllustration(
                    topicName = topic.title,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Summary & Analisis Pembelajaran",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SECTION: RANGKUMAN (Points)
        Text(
            text = "Rangkuman Inti (Syllabus)",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                topic.summaries.forEachIndexed { i, summary ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "•",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = summary,
                            fontSize = 13.sp,
                            lineHeight = 18.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SECTION: DETAILED EXPLANATION Sections
        topic.detailSections.forEach { section ->
            Text(
                text = section.heading,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 10.dp, bottom = 4.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = section.content,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // DIRECT COMPENTENCY TEST FOR THIS TOPIC
        Button(
            onClick = {
                viewModel.selectedQuizCategory = topic.title
                viewModel.selectedQuestionCount = 5 // shorter quiz for topic-level check
                viewModel.startQuiz()
            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("materi_start_kuis_btn"),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "🔥", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Uji Kompetensi: Kuis Khusus ${topic.title}", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

// ----------------------------------------------------
// SCREEN 4: QUIZ PREPARATION
// ----------------------------------------------------
@Composable
fun QuizPrepScreen(viewModel: QuizViewModel) {
    var expandedCategory by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Latihan Kuis Sistem GeOSN",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Pilih kategori olimpiade yang ingin dilatih dan tentukan batasan jumlah pertanyaan.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(25.dp))

        // CATEGORY PICKER
        Text(
            text = "Pilih Kategori Pembelajaran :",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        val categories = listOf(
            "Semua Kategori",
            "Cuaca dan Iklim",
            "Oseanografi",
            "Kebencanaan dan Manajemen Bencana",
            "Sumberdaya dan Manajemen Sumberdaya",
            "Geografi Lingkungan dan Pembangun",
            "Perubahan Roman Muka Bumi",
            "Pertanian dan Permasalahan Pangan",
            "Kependudukan dan Dinamika Penduduk",
            "Geografi Ekonomi",
            "Pariwisata dan Manajemen Pariwisata"
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { expandedCategory = !expandedCategory },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_category_dropdown"),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = viewModel.selectedQuizCategory, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Text(text = "▼", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                }
            }

            DropdownMenu(
                expanded = expandedCategory,
                onDismissRequest = { expandedCategory = false },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                categories.forEach { cat ->
                    DropdownMenuItem(
                        text = { Text(cat) },
                        onClick = {
                            viewModel.selectedQuizCategory = cat
                            expandedCategory = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // QUESTION COUNT PICKER
        Text(
            text = "Jumlah Pertanyaan Kuis :",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val counts = listOf(5, 10, 20)
            counts.forEach { count ->
                val isSelected = viewModel.selectedQuestionCount == count
                OutlinedButton(
                    onClick = { viewModel.selectedQuestionCount = count },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quiz_count_${count}"),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
                    ),
                    border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = "$count Soal",
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // ILLUSTRATION CARD INSIDE PREP
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier.size(100.dp)) {
                    GeographyIllustration(
                        topicName = viewModel.selectedQuizCategory,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Mode Evaluasi HOTS-OSN",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp
                )
                Text(
                    text = "Soal diramu menggunakan indikator studi kasus aktual di Indonesia untuk melatih ketajaman spasial penemu hipotesis secara komparatif.",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // START TRIGGER
        Button(
            onClick = { viewModel.startQuiz() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .testTag("quiz_start_button"),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "MULAI KUIS LATIHAN", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

// ----------------------------------------------------
// SCREEN 5: REAL-TIME QUIZ ACTIVE INTERACTIVE
// ----------------------------------------------------
@Composable
fun QuizActiveScreen(viewModel: QuizViewModel) {
    if (viewModel.activeQuestions.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Mohon tunggu, kuiz sedang diproses...")
        }
        return
    }

    val question = viewModel.activeQuestions[viewModel.currentQuestionIndex]
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        // TOP HEADER BAR (TIMER & PROGRESS)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Pertanyaan ${viewModel.currentQuestionIndex + 1} / ${viewModel.activeQuestions.size}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp
                )
                Text(
                    text = viewModel.selectedQuizCategory,
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }

            // Real-time Timer Label
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = String.format("⏱️ %02d:%02d", viewModel.quizSecondsElapsed / 60, viewModel.quizSecondsElapsed % 60),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Progress bar indicators
        LinearProgressIndicator(
            progress = { (viewModel.currentQuestionIndex + 1).toFloat() / viewModel.activeQuestions.size },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = Color.LightGray.copy(alpha = 0.25f)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // STUDY CASE STYLED BOX
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "📂", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = question.caseTitle,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 13.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = question.scenario,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = Color.DarkGray
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // THE TARGET CRITICAL QUESTION
        Text(
            text = question.questionText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        // INTERACTIVE MULTIPLE CHOICE BUTTONS
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            question.options.forEachIndexed { index, option ->
                val isSelected = viewModel.selectedAnswerIndex == index
                val isSubmitted = viewModel.isAnswerSubmitted
                val isCorrectAnswer = index == question.correctAnswerIndex

                // Determine border and background colors dynamically after evaluation
                val colorSet = if (isSubmitted) {
                    when {
                        isCorrectAnswer -> Pair(ForestGreen.copy(alpha = 0.15f), ForestGreen)
                        isSelected -> Pair(AccentClay.copy(alpha = 0.1f), AccentClay)
                        else -> Pair(Color.White, Color.LightGray)
                    }
                } else {
                    if (isSelected) Pair(MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f), MaterialTheme.colorScheme.secondary)
                    else Pair(Color.White, Color.LightGray.copy(alpha = 0.4f))
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.selectOption(index) }
                        .testTag("quiz_option_${index + 1}"),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = colorSet.first),
                    border = BorderStroke(1.5.dp, colorSet.second)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Letter A, B, C, D circles
                        val letter = ('A' + index).toString()
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected || (isSubmitted && isCorrectAnswer)) colorSet.second
                                    else Color.LightGray.copy(alpha = 0.25f)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = letter,
                                color = if (isSelected || (isSubmitted && isCorrectAnswer)) Color.White else Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(15.dp))

                        // Text choice
                        Text(
                            text = option,
                            fontSize = 13.sp,
                            lineHeight = 17.sp,
                            modifier = Modifier.weight(1f)
                        )
                        
                        // Icon indicators
                        if (isSubmitted) {
                            if (isCorrectAnswer) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = "Benar", tint = ForestGreen)
                            } else if (isSelected) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Salah", tint = AccentClay)
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // REAL-TIME EXPLANATION SLIDEOUT PANEL
        AnimatedVisibility(
            visible = viewModel.isAnswerSubmitted,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = LightGreenBack)
            ) {
                Column(modifier = Modifier.padding(15.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "💡", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Kunci Pembahasan Sains & Fisik:",
                            fontWeight = FontWeight.Bold,
                            color = ForestGreen,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = question.explanation,
                        fontSize = 12.sp,
                        lineHeight = 17.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // MAIN ACTION BUTTON (SUBMIT VS NEXT)
        if (!viewModel.isAnswerSubmitted) {
            Button(
                onClick = { viewModel.submitAnswer() },
                enabled = viewModel.selectedAnswerIndex != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("quiz_submit_btn"),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "KIRIM JAWABAN", color = Color.White, fontWeight = FontWeight.Bold)
            }
        } else {
            Button(
                onClick = { viewModel.nextQuestion() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("quiz_next_btn"),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                val btnText = if (viewModel.currentQuestionIndex == viewModel.activeQuestions.size - 1) {
                    "SELESAIKAN KUIS LATIHAN"
                } else {
                    "PERTANYAAN BERIKUTNYA"
                }
                Text(text = btnText, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

// ----------------------------------------------------
// SCREEN 6: QUIZ SUMMARY RESULTS
// ----------------------------------------------------
@Composable
fun QuizSummaryScreen(viewModel: QuizViewModel) {
    val scorePercent = ((viewModel.correctAnswersCount.toFloat() / viewModel.activeQuestions.size) * 100).toInt()
    val isPerfectValue = scorePercent == 100

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.size(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawArc(
                    color = Color.LightGray.copy(alpha = 0.2f),
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 15f)
                )
                drawArc(
                    color = if (scorePercent >= 60) ForestGreen else AccentClay,
                    startAngle = -90f,
                    sweepAngle = (scorePercent / 100f) * 360f,
                    useCenter = false,
                    style = Stroke(width = 15f)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "$scorePercent",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(text = "Total Skor", fontSize = 11.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (scorePercent >= 80) "Kinerja Luar Biasa! 🏆" else if (scorePercent >= 60) "Akurasi Bagus! 👍" else "Terus Berlinatih! 📚",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Kategori: ${viewModel.selectedQuizCategory}\nJumlah Benar: ${viewModel.correctAnswersCount} dari ${viewModel.activeQuestions.size} soal",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // METRICS CARD
        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(28.dp),
            border = BorderStroke(1.dp, Color(0xFFEADDFF)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "⏱️ Waktu Kelar:", fontSize = 12.sp, color = Color.Gray)
                    Text(
                        text = String.format("%02d Menit %02d Detik", viewModel.quizSecondsElapsed / 60, viewModel.quizSecondsElapsed % 60),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "🎯 Akurasi Rata-rata:", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "$scorePercent%", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // NAVIGATION TRIGGERS
        Button(
            onClick = { viewModel.restartQuizFromSummary() },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(46.dp)
                .testTag("summary_restart_btn"),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "ULANG KUIS SAMA", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = { viewModel.navigateTo(Screen.Dashboard) },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(46.dp)
                .testTag("summary_done_btn"),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "KEMBALI KE DASBOR", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        }
    }
}

// ----------------------------------------------------
// SCREEN 7: REAL-TIME SCORES & HISTORY CHART
// ----------------------------------------------------
@Composable
fun StatsScreen(viewModel: QuizViewModel, scores: List<UserScore>) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        Text(
            text = "Kajian Progres Belajar Real-Time",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Pantau statistik kemajuan evaluasi mandiri secara spasial dan berkala.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (scores.isEmpty()) {
            // EMPTY STATE PLACEHOLDER
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "📊", fontSize = 42.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Data Belajar Kosong",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Belum ada skor kuis terekam. Ayo mulai latihan pertamamu di tab kuis untuk memetakan keahlian geografimu!",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        lineHeight = 16.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }
            }
        } else {
            // METRICS GRID Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = "Jumlah Kuis", fontSize = 11.sp, color = Color.Gray)
                        Text(text = "${scores.size}", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                }
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = "Skor Rerata", fontSize = 11.sp, color = Color.Gray)
                        Text(text = "${viewModel.getAverageScore(scores)}%", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // LINE GRAPH / SCORE CHART (NATIVE DRAWING WITH CANVAS)
            Text(
                text = "Tren Skor Evaluasi Terakhir",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize().padding(15.dp)) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val canvasW = size.width
                        val canvasH = size.height
                        
                        // Draw grid lines
                        val gridLines = 4
                        for (i in 0..gridLines) {
                            val y = (canvasH / gridLines) * i
                            drawLine(
                                color = Color.LightGray.copy(alpha = 0.4f),
                                start = Offset(0f, y),
                                end = Offset(canvasW, y),
                                strokeWidth = 1f
                            )
                        }

                        // Take and reverse top 8 scores to draw chronologically
                        val maxPoints = 8
                        val chartScores = scores.take(maxPoints).reversed()
                        if (chartScores.size >= 1) {
                            val dx = if (chartScores.size > 1) canvasW / (chartScores.size - 1) else canvasW
                            val points = chartScores.mapIndexed { idx, item ->
                                val x = dx * idx
                                val y = canvasH - ((item.score.toFloat() / 100f) * canvasH)
                                Offset(x, y)
                            }

                            // Draw continuous path line
                            val chartPath = Path().apply {
                                points.forEachIndexed { i, pt ->
                                    if (i == 0) moveTo(pt.x, pt.y) else lineTo(pt.x, pt.y)
                                }
                            }
                            drawPath(path = chartPath, color = SecondarySky, style = Stroke(width = 4f))

                            // Draw point circles
                            points.forEach { pt ->
                                drawCircle(color = AccentClay, radius = 5f, center = pt)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // REVELATION STRENGTH CHART (Topic Diagnostics Profile)
            Text(
                text = "Profil Keahlian Spasial",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))

            val topicStats = viewModel.getDiagnosticStrengths(scores)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(15.dp)) {
                    topicStats.forEach { (topic, score) ->
                        Column(modifier = Modifier.padding(vertical = 4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = topic, fontSize = 11.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                                Text(text = if (score > 0) "$score%" else "Belum Belajar", fontSize = 10.sp, color = if (score >= 60) ForestGreen else Color.Gray)
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            LinearProgressIndicator(
                                progress = { score.toFloat() / 100f },
                                modifier = Modifier.fillMaxWidth(),
                                color = if (score >= 80) ForestGreen else if (score >= 50) SecondarySky else AccentClay,
                                trackColor = Color.LightGray.copy(alpha = 0.2f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            // RECENT LOGS LIST
            Text(
                text = "Log Riwayat Penyelesaian Kuis",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))

            scores.forEach { session ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (session.score >= 80) "🟢" else if (session.score >= 50) "🟡" else "🔴",
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = session.category, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            val fDate = SimpleDateFormat("dd MMM, HH:mm", Locale.getDefault()).format(Date(session.timestamp))
                            Text(text = fDate, fontSize = 10.sp, color = Color.Gray)
                        }
                        Text(
                            text = "Score: ${session.score}%",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // RESET LOG TRINGGER
            OutlinedButton(
                onClick = { viewModel.clearHistory() },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("stats_reset_btn"),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.5.dp, AccentClay.copy(alpha = 0.5f))
            ) {
                Text(text = "Riset Riwayat Belajar ⚠️", color = AccentClay, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}
