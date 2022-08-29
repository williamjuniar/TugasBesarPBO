-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 25, 2020 at 03:27 AM
-- Server version: 5.7.32-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

CREATE DATABASE IF NOT EXISTS `tubespbo` /*!40100 DEFAULT CHARACTER SET utf8 */;
Use `tubespbo`;

-- --------------------------------------------------------

--
-- Table structure for table `daak`
--

CREATE TABLE `daak` (
  `NIK` char(10) NOT NULL,
  `ID_User` char(32) NOT NULL,
  `Jabatan` varchar(256) NOT NULL,
  `Hak_Akses_Keuangan` tinyint(1) NOT NULL,
  `Hak_Akses_Matakuliah` tinyint(1) NOT NULL,
  `Hak_Akses_JadwalPerkuliahan` tinyint(1) NOT NULL,
  `Hak_Akses_RencanaStudi` tinyint(1) NOT NULL,
  `Hak_Akses_User` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `daak`
--

INSERT INTO `daak` (`NIK`, `ID_User`, `Jabatan`, `Hak_Akses_Keuangan`, `Hak_Akses_Matakuliah`, `Hak_Akses_JadwalPerkuliahan`, `Hak_Akses_RencanaStudi`, `Hak_Akses_User`) VALUES
('001', '0d7ad2bddb28fb852bd7f990b327f9c3', 'Administrasi', 1, 0, 0, 0, 1),
('002', 'f3fa607eda8a8b3790a96ddf81df0f62', 'Admin', 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `daftar_hadir_mahasiswa`
--

CREATE TABLE `daftar_hadir_mahasiswa` (
  `ID_Kehadiran` int(11) NOT NULL,
  `NIM` char(8) NOT NULL,
  `ID_MK` int(11) NOT NULL,
  `ID_Roster` int(11) NOT NULL,
  `Status` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `daftar_hadir_mahasiswa`
--

INSERT INTO `daftar_hadir_mahasiswa` (`ID_Kehadiran`, `NIM`, `ID_MK`, `ID_Roster`, `Status`) VALUES
(5, '1119002', 22, 10, NULL),
(6, '1219001', 22, 10, NULL),
(9, '1118003', 3, 12, NULL),
(10, '1118003', 3, 13, NULL),
(11, '1118003', 3, 14, NULL),
(12, '1118003', 3, 15, NULL),
(13, '1118003', 9, 16, NULL),
(14, '1119004', 9, 16, NULL),
(15, '1118003', 9, 17, NULL),
(16, '1119004', 9, 17, NULL),
(17, '1118003', 9, 18, NULL),
(18, '1119004', 9, 18, NULL),
(19, '1118003', 9, 19, NULL),
(20, '1119004', 9, 19, NULL),
(21, '1119004', 12, 20, NULL),
(22, '1119004', 12, 21, NULL),
(23, '1119004', 12, 22, NULL),
(24, '1119004', 12, 23, NULL),
(25, '1119004', 13, 24, NULL),
(26, '1119004', 13, 25, NULL),
(27, '1119004', 13, 26, NULL),
(28, '1119004', 13, 27, NULL),
(29, '1119004', 4, 28, NULL),
(30, '1119004', 4, 29, 'Hadir'),
(31, '1119004', 4, 30, NULL),
(32, '1119004', 4, 31, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `daftar_roster_matakuliah`
--

CREATE TABLE `daftar_roster_matakuliah` (
  `ID_Roster` int(11) NOT NULL,
  `ID_MK` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Ruangan` varchar(256) NOT NULL,
  `Jam_Dimulai` time NOT NULL DEFAULT '00:00:00',
  `Jam_Berakhir` time NOT NULL DEFAULT '00:00:00',
  `statusDosen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `daftar_roster_matakuliah`
--

INSERT INTO `daftar_roster_matakuliah` (`ID_Roster`, `ID_MK`, `Tanggal`, `Ruangan`, `Jam_Dimulai`, `Jam_Berakhir`, `statusDosen`) VALUES
(10, 22, '2020-11-18', 'Space', '05:30:00', '04:30:00', 0),
(12, 3, '2019-01-14', 'R.002', '09:00:00', '12:00:00', 1),
(13, 3, '2019-01-16', 'R.002', '10:00:00', '13:00:00', 1),
(14, 3, '2019-01-21', 'R.002', '09:00:00', '12:00:00', 1),
(15, 3, '2019-01-23', 'R.002', '10:00:00', '13:00:00', 1),
(16, 9, '2019-01-15', 'R.005', '08:00:00', '10:00:00', 1),
(17, 9, '2019-01-17', 'R.005', '08:00:00', '10:00:00', 1),
(18, 9, '2019-01-22', 'R.005', '08:00:00', '10:00:00', 1),
(19, 9, '2019-01-24', 'R.005', '08:00:00', '10:00:00', 1),
(20, 12, '2019-01-15', 'R.007', '11:00:00', '13:00:00', 1),
(21, 12, '2019-01-17', 'R.007', '11:00:00', '13:00:00', 1),
(22, 12, '2019-01-22', 'R.007', '11:00:00', '13:00:00', 1),
(23, 12, '2019-01-24', 'R.007', '11:00:00', '13:00:00', 1),
(24, 13, '2019-01-14', 'R.002', '15:00:00', '17:00:00', 1),
(25, 13, '2019-01-16', 'R.002', '15:00:00', '17:00:00', 1),
(26, 13, '2019-01-21', 'R.002', '15:00:00', '17:00:00', 1),
(27, 13, '2019-01-23', 'R.002', '15:00:00', '17:00:00', 1),
(28, 4, '2019-01-14', 'R..004', '12:00:00', '15:00:00', 1),
(29, 4, '2019-01-16', 'R.004', '07:00:00', '10:00:00', 1),
(30, 4, '2019-01-21', 'R.004', '12:00:00', '15:00:00', 1),
(31, 4, '2019-01-23', 'R.004', '07:00:00', '10:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `detail_matakuliah`
--

CREATE TABLE `detail_matakuliah` (
  `ID_MK` int(11) NOT NULL,
  `NID` char(8) NOT NULL,
  `Kode_MK` char(6) NOT NULL,
  `Kelas` varchar(2) NOT NULL,
  `Jumlah_Pertemuan` int(10) NOT NULL,
  `Tahun` year(4) NOT NULL,
  `Semester` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detail_matakuliah`
--

INSERT INTO `detail_matakuliah` (`ID_MK`, `NID`, `Kode_MK`, `Kelas`, `Jumlah_Pertemuan`, `Tahun`, `Semester`) VALUES
(3, '111', 'IF-101', 'A', 24, 2019, 'Ganjil'),
(4, '111', 'IF-101', 'B', 24, 2019, 'Ganjil'),
(5, '112', 'IF-101', 'A', 24, 2020, 'Ganjil'),
(6, '112', 'IF-101', 'B', 24, 2020, 'Ganjil'),
(9, '112', 'IF-102', 'A', 14, 2019, 'Ganjil'),
(10, '112', 'IF-102', 'A', 14, 2020, 'Ganjil'),
(11, '111', 'IF-1P1', 'A', 14, 2019, 'Ganjil'),
(12, '111', 'IF-1P1', 'B', 14, 2019, 'Ganjil'),
(13, '112', 'IF-1P2', 'A', 14, 2019, 'Ganjil'),
(14, '112', 'IF-1P2', 'A', 14, 2020, 'Ganjil'),
(15, '113', 'IF-1P3', 'A', 26, 2019, 'Genap'),
(16, '113', 'IF-1P3', 'B', 26, 2019, 'Genap'),
(17, '111', 'IF-904', 'A', 14, 2019, 'Genap'),
(18, '111', 'IF-904', 'B', 14, 2019, 'Genap'),
(19, '114', 'KU-101', 'A', 14, 2019, 'Genap'),
(20, '115', 'KU-102', 'A', 14, 2019, 'Genap'),
(21, '116', 'IF-181', 'A', 14, 2019, 'Genap'),
(22, '116', 'SI-1P1', 'A', 14, 2019, 'Genap'),
(23, '117', 'AK-100', 'A', 14, 2019, 'Genap');

-- --------------------------------------------------------

--
-- Table structure for table `detail_rencana_studi_mahasiswa`
--

CREATE TABLE `detail_rencana_studi_mahasiswa` (
  `ID_MK` int(11) NOT NULL,
  `ID_RSM` char(13) NOT NULL,
  `ID_Detail_RSM` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detail_rencana_studi_mahasiswa`
--

INSERT INTO `detail_rencana_studi_mahasiswa` (`ID_MK`, `ID_RSM`, `ID_Detail_RSM`) VALUES
(5, '2020GA1119002', 27),
(10, '2020GA1119002', 28),
(23, '2019GE1119002', 31),
(22, '2019GE1119002', 32),
(3, '2019GA1118003', 33),
(9, '2019GA1118003', 34),
(21, '2019GE1219001', 35),
(22, '2019GE1219001', 36),
(4, '2019GA1119004', 37),
(9, '2019GA1119004', 38),
(12, '2019GA1119004', 39),
(13, '2019GA1119004', 40);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `ID_Detail` int(11) NOT NULL,
  `ID_Transaksi` int(11) NOT NULL,
  `ID_Kategori` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `NID` varchar(8) NOT NULL,
  `ID_User` char(32) NOT NULL,
  `Program_Studi` varchar(20) NOT NULL,
  `Bidang_Ilmu` varchar(20) NOT NULL,
  `Gelar_Akademik` varchar(20) NOT NULL,
  `Status_Pegawai` varchar(20) NOT NULL,
  `Status_Ikatan_Kerja` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`NID`, `ID_User`, `Program_Studi`, `Bidang_Ilmu`, `Gelar_Akademik`, `Status_Pegawai`, `Status_Ikatan_Kerja`) VALUES
('111', 'f61326c0bb9880dfeaf6efc4f1a9bf08', 'Teknik Informatika', 'Teknik', 'M.Kom', 'PNS', 'Dosen Tetap'),
('112', '819d34de8e0e271c13b3b2bf996fb006', 'Teknik Informatika', 'Teknik', 'M.Kom', 'PNS', 'Dosen Tetap'),
('113', '642e65ae0468f4cbbd42ac67c8c76d2f', 'Teknik Informatika', 'Teknik', 'S.Kom', 'PNS', 'Dosen Tidak Tetap'),
('114', '30ede07c21699568c3f245861e9bd03f', '-', 'Pendidikan Agama', 'S.PAK', 'PNS', 'Dosen Tetap'),
('115', '00e99b59ed270f17936d19667bde79da', '-', 'Sastra Inggris', 'S.Pd', 'PNS', 'Dosen Honorer'),
('116', '30b4c9d14cb447ba6576f78cf38f8465', 'Sistem Informasi', 'Teknik', 'S.SI', 'PNS', 'Dosen Tetap'),
('117', 'e4180149804d67e75c13cccf0edb7262', 'Akuntansi', 'Ekonomi', 'S.Ak', 'Bukan-PNS', 'Dosen Honorer');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_studi_mahasiswa`
--

CREATE TABLE `hasil_studi_mahasiswa` (
  `ID_HSM` int(11) NOT NULL,
  `NIM` char(8) NOT NULL,
  `ID_MK` int(11) NOT NULL,
  `N1` int(11) NOT NULL DEFAULT '0',
  `N2` int(11) NOT NULL DEFAULT '0',
  `N3` int(11) NOT NULL DEFAULT '0',
  `N4` int(11) NOT NULL DEFAULT '0',
  `N5` int(11) NOT NULL DEFAULT '0',
  `N_UAS` int(11) NOT NULL DEFAULT '0',
  `NA` double NOT NULL DEFAULT '0',
  `Huruf` char(2) NOT NULL DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hasil_studi_mahasiswa`
--

INSERT INTO `hasil_studi_mahasiswa` (`ID_HSM`, `NIM`, `ID_MK`, `N1`, `N2`, `N3`, `N4`, `N5`, `N_UAS`, `NA`, `Huruf`) VALUES
(1, '1119002', 23, 0, 0, 0, 0, 0, 0, 0, '-'),
(2, '1119002', 22, 55, 66, 77, 88, 99, 77, 77, 'A-'),
(3, '1118003', 3, 100, 100, 0, 0, 0, 0, 33.333332, 'E'),
(4, '1118003', 9, 0, 0, 0, 0, 0, 0, 0, '-'),
(5, '1219001', 21, 0, 0, 0, 0, 0, 0, 0, '-'),
(6, '1219001', 22, 0, 0, 0, 0, 0, 0, 0, 'E'),
(7, '1119004', 4, 0, 0, 0, 0, 0, 0, 0, '-'),
(8, '1119004', 9, 90, 0, 0, 0, 0, 0, 0, '-'),
(9, '1119004', 12, 0, 0, 0, 0, 0, 0, 0, '-'),
(10, '1119004', 13, 0, 0, 0, 0, 0, 0, 0, '-');

-- --------------------------------------------------------

--
-- Table structure for table `kategori_transaksi`
--

CREATE TABLE `kategori_transaksi` (
  `ID_Kategori` int(11) NOT NULL,
  `Nama_Kategori` varchar(256) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Kategori_Semester` char(1) NOT NULL,
  `Kategori_Angkatan` int(11) NOT NULL,
  `Tahun_Ajaran` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` char(8) NOT NULL,
  `ID_User` char(32) NOT NULL,
  `Jurusan` varchar(256) NOT NULL,
  `Tahun_Masuk` year(4) NOT NULL,
  `Tahun_Lulus` year(4) NOT NULL,
  `IPK` double NOT NULL,
  `Predikat` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `ID_User`, `Jurusan`, `Tahun_Masuk`, `Tahun_Lulus`, `IPK`, `Predikat`) VALUES
('1118003', '513b67e9744d8f7d2783e79a191b022e', 'Informatika', 2018, 2022, 0, '-'),
('1118005', '41a378ed45bfeba6aaf8a5919ea8e8f0', 'Informatika', 2018, 2022, 0, '-'),
('1119001', '52af501fcd4e7dc8dc71e6e8a0b907ee', 'Informatika', 2019, 2023, 0, '-'),
('1119002', '761736f9512d2db231bc9894456c35bf', 'Informatika', 2019, 2023, 0, 'Sarjana'),
('1119004', '093d2acfcb39bd8dc214bf92141409ea', 'Informatika', 2019, 2023, 0, 'Sarjana'),
('1119006', 'b3135526a9c1560c59ab75b74b51f96d', 'Informatika', 2019, 2023, 0, 'Sarjana'),
('1119007', '1fd7b287810b7152528dde3fc4b42d8a', 'Informatika', 2019, 2023, 0, '-'),
('1119036', 'a27925e897b6533b53567bc947a76871', 'Informatika', 2019, 2023, 0, '-'),
('1219001', '479f3002f89bdd53e90d3bad705a3c31', 'Sistem Informasi', 2019, 2023, 0, '-'),
('1219002', 'af76d85aa4b2a8de37684c7a6ccffc94', 'Sistem Informasi', 2019, 2023, 0, '-'),
('3219001', 'cff1aef5d79edc9f98161855018afb4e', 'Akuntansi', 2019, 2023, 0, '-'),
('3219003', '42e5083d55316e33134daa05c15f59d1', 'Akuntansi', 2019, 2023, 0, '-');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `Kode` char(6) NOT NULL,
  `Nama_MK` varchar(256) NOT NULL,
  `Jenis_MK` int(11) NOT NULL,
  `Sifat_MK` int(11) NOT NULL,
  `SKS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`Kode`, `Nama_MK`, `Jenis_MK`, `Sifat_MK`, `SKS`) VALUES
('AK-100', 'Pengantar Akuntansi I', 1, 0, 3),
('IF-101', 'Algoritma dan Pemrograman', 1, 0, 4),
('IF-102', 'Pengantar Teknologi Informasi', 1, 0, 2),
('IF-181', 'Dasar Pemrograman 1', 1, 0, 2),
('IF-1P1', 'Prak.Algoritma dan Pemrograman', 0, 0, 2),
('IF-1P2', 'Prak.Pengantar Teknologi Informasi', 0, 0, 1),
('IF-1P3', 'Desain Web', 0, 0, 2),
('IF-904', 'Game Design', 1, 1, 2),
('KU-101', 'Pendidikan Agama', 1, 2, 2),
('KU-102', 'English 1', 1, 2, 2),
('SI-1P1', 'Praktikum Dasar Pemrograman 1', 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rencana_studi_mahasiswa`
--

CREATE TABLE `rencana_studi_mahasiswa` (
  `ID_RSM` char(13) NOT NULL,
  `NIM` char(8) NOT NULL,
  `Semester` varchar(8) NOT NULL,
  `Tahun` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rencana_studi_mahasiswa`
--

INSERT INTO `rencana_studi_mahasiswa` (`ID_RSM`, `NIM`, `Semester`, `Tahun`) VALUES
('2019GA1118003', '1118003', 'Ganjil', 2019),
('2019GA1119004', '1119004', 'Ganjil', 2019),
('2019GE1119002', '1119002', 'Genap', 2019),
('2019GE1219001', '1219001', 'Genap', 2019),
('2020GA1119002', '1119002', 'Ganjil', 2020);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_Transaksi` int(11) NOT NULL,
  `NIM` char(8) NOT NULL,
  `ID_RSM` int(11) NOT NULL,
  `Tanggal_Transaksi` date NOT NULL,
  `Jumlah_Bayar` int(11) NOT NULL,
  `Tahun_Ajaran` year(4) NOT NULL,
  `Semester` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID_User` char(32) NOT NULL,
  `Nama_Lengkap` varchar(256) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Password` char(64) NOT NULL,
  `Tanggal_Lahir` date NOT NULL,
  `Jenis_Kelamin` char(9) NOT NULL,
  `No_Telp` varchar(256) NOT NULL,
  `jenisUser` int(10) NOT NULL,
  `pathFoto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID_User`, `Nama_Lengkap`, `Email`, `Password`, `Tanggal_Lahir`, `Jenis_Kelamin`, `No_Telp`, `jenisUser`, `pathFoto`) VALUES
('00e99b59ed270f17936d19667bde79da', 'Natalia Winata', 'winata@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1993-11-30', 'Perempuan', '087756889788', 2, 'https://i.insider.com/5b8407d03cccd122058b4580?width=1100&format=jpeg&auto=webp'),
('093d2acfcb39bd8dc214bf92141409ea', 'Calvin Jeremy', 'calvin@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-11-13', 'Laki-Laki', '083235612345', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('0d7ad2bddb28fb852bd7f990b327f9c3', 'Yuni Yulianti', 'yuniyulianti@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1985-11-26', 'Perempuan', '085367889577', 1, 'https://ichef.bbci.co.uk/news/1024/cpsprodpb/151AB/production/_111434468_gettyimages-1143489763.jpg'),
('1fd7b287810b7152528dde3fc4b42d8a', 'Michael Jordan', 'michaelj@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-05-14', 'Laki-Laki', '085358693884', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('30b4c9d14cb447ba6576f78cf38f8465', 'Rafli Alexer', 'raflialexer@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2020-06-18', 'Laki-Laki', '083344598766', 2, ''),
('30ede07c21699568c3f245861e9bd03f', 'Verdy Antonius', 'verdyantonius@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1965-05-19', 'Laki-Laki', '085234478591', 2, 'https://icc.govt.nz/wp-content/uploads/2019/03/cats-banner.jpg'),
('41a378ed45bfeba6aaf8a5919ea8e8f0', 'Ericha Morales', 'moralesericha@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2000-03-24', 'Perempuan', '08536688912', 3, 'https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg'),
('42e5083d55316e33134daa05c15f59d1', 'Cindy Laurensia', 'cindylauren@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-10-26', 'Perempuan', '085366889012', 3, 'https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png'),
('479f3002f89bdd53e90d3bad705a3c31', 'Jessica Kurniawan', 'jessicakurni@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-02-20', 'Perempuan', '082345586942', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('513b67e9744d8f7d2783e79a191b022e', 'Daniel Chris', 'danielchris@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2000-09-10', 'Laki-Laki', '082233456889', 3, 'https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg'),
('52af501fcd4e7dc8dc71e6e8a0b907ee', 'Michelle Santosa', 'michellesantosa@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-11-08', 'Perempuan', '083145768423', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('642e65ae0468f4cbbd42ac67c8c76d2f', 'Dewi Yunita', 'dewiyuni@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1980-12-30', 'Perempuan', '081223845677', 2, 'https://icc.govt.nz/wp-content/uploads/2019/03/cats-banner.jpg'),
('761736f9512d2db231bc9894456c35bf', 'Albertus Angkuw', 'albertus@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-11-08', 'Laki-Laki', '082233131344', 3, 'https://icons-for-free.com/iconfiles/png/512/business+face+people+icon-1320086457520622872.png'),
('819d34de8e0e271c13b3b2bf996fb006', 'Jeremy Thomas', 'thomasjer@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1985-09-30', 'Laki-Laki', '087734578988', 2, 'https://www.rspcasa.org.au/wp-content/uploads/2019/01/Adopt-a-cat-or-kitten-from-RSPCA.jpg'),
('82840b51f5c9f1f15b8353dc15191ab5', 'Kimso', 'kimso@mail.com', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', '2020-10-17', 'Laki-Laki', '0874927492', 2, 'misdjadjwdw'),
('a27925e897b6533b53567bc947a76871', 'Elangel', 'elangel@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2000-08-07', 'Perempuan', '0822358693682', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('af76d85aa4b2a8de37684c7a6ccffc94', 'Mike Andrew', 'mikeandrew@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-10-30', 'Laki-Laki', '082245886944', 3, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('b3135526a9c1560c59ab75b74b51f96d', 'William Juniar', 'williamjuniar@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-06-25', 'Laki-Laki', '081220833081', 3, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/NGC_4414_%28NASA-med%29.jpg/1200px-NGC_4414_%28NASA-med%29.jpg'),
('cff1aef5d79edc9f98161855018afb4e', 'Jason Anderson', 'jasonanderson@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-12-08', 'Laki-Laki', '082355698000', 3, 'https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png'),
('e4180149804d67e75c13cccf0edb7262', 'Liana Angelina', 'angelinaliana@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1986-03-09', 'Perempuan', '087766554455', 2, 'https://news.cgtn.com/news/77416a4e3145544d326b544d354d444d3355444f31457a6333566d54/img/37d598e5a04344da81c76621ba273915/37d598e5a04344da81c76621ba273915.jpg'),
('f3fa607eda8a8b3790a96ddf81df0f62', 'Albertus Septian', 'albertusseptian@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '2001-11-13', 'Laki-Laki', '085344576844', 1, 'https://static.toiimg.com/photo/msid-67586673/67586673.jpg?3918697'),
('f61326c0bb9880dfeaf6efc4f1a9bf08', 'John Sinaga', 'sinagajohn@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '1970-07-21', 'Laki-Laki', '085544689753', 2, 'https://www.rspcasa.org.au/wp-content/uploads/2019/01/Adopt-a-cat-or-kitten-from-RSPCA.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `daak`
--
ALTER TABLE `daak`
  ADD PRIMARY KEY (`NIK`);

--
-- Indexes for table `daftar_hadir_mahasiswa`
--
ALTER TABLE `daftar_hadir_mahasiswa`
  ADD PRIMARY KEY (`ID_Kehadiran`);

--
-- Indexes for table `daftar_roster_matakuliah`
--
ALTER TABLE `daftar_roster_matakuliah`
  ADD PRIMARY KEY (`ID_Roster`);

--
-- Indexes for table `detail_matakuliah`
--
ALTER TABLE `detail_matakuliah`
  ADD PRIMARY KEY (`ID_MK`);

--
-- Indexes for table `detail_rencana_studi_mahasiswa`
--
ALTER TABLE `detail_rencana_studi_mahasiswa`
  ADD PRIMARY KEY (`ID_Detail_RSM`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`ID_Detail`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`NID`);

--
-- Indexes for table `hasil_studi_mahasiswa`
--
ALTER TABLE `hasil_studi_mahasiswa`
  ADD PRIMARY KEY (`ID_HSM`);

--
-- Indexes for table `kategori_transaksi`
--
ALTER TABLE `kategori_transaksi`
  ADD PRIMARY KEY (`ID_Kategori`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`Kode`);

--
-- Indexes for table `rencana_studi_mahasiswa`
--
ALTER TABLE `rencana_studi_mahasiswa`
  ADD PRIMARY KEY (`ID_RSM`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_Transaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_User`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `daftar_hadir_mahasiswa`
--
ALTER TABLE `daftar_hadir_mahasiswa`
  MODIFY `ID_Kehadiran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `daftar_roster_matakuliah`
--
ALTER TABLE `daftar_roster_matakuliah`
  MODIFY `ID_Roster` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `detail_matakuliah`
--
ALTER TABLE `detail_matakuliah`
  MODIFY `ID_MK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `detail_rencana_studi_mahasiswa`
--
ALTER TABLE `detail_rencana_studi_mahasiswa`
  MODIFY `ID_Detail_RSM` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `ID_Detail` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hasil_studi_mahasiswa`
--
ALTER TABLE `hasil_studi_mahasiswa`
  MODIFY `ID_HSM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `kategori_transaksi`
--
ALTER TABLE `kategori_transaksi`
  MODIFY `ID_Kategori` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `ID_Transaksi` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
