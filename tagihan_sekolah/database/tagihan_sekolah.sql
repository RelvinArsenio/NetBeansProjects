SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `tagihan_sekolah` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tagihan_sekolah`;

CREATE TABLE `login` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `login` (`Username`, `Password`) VALUES
('admin1', '123');

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `tagihan_id` int(11) NOT NULL,
  `jumlah_bayar` decimal(10,2) NOT NULL,
  `tanggal_bayar` date NOT NULL,
  PRIMARY KEY (`id_pembayaran`),
  KEY `tagihan_id` (`tagihan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `pembayaran` (`id_pembayaran`, `tagihan_id`, `jumlah_bayar`, `tanggal_bayar`) VALUES
(1, 1, 2500000.00, '2023-06-28'),
(2, 2, 2500000.00, '2023-07-04');

CREATE TABLE `siswa` (
  `id_siswa` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis_kelamin` set('Laki Laki','Perempuan') NOT NULL,
  `kelas` varchar(10) NOT NULL,
  PRIMARY KEY (`id_siswa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `siswa` (`id_siswa`, `nama`, `jenis_kelamin`, `kelas`) VALUES
(1, 'Alvin Grayson', 'Laki Laki', '10A'),
(2, 'Aksa', 'Laki Laki', '12B'),
(3, 'Alteza', 'Laki Laki', '10E'),
(4, 'Felicya Angraini', 'Perempuan', '10A'),
(5, 'Relvin Arsenio', 'Laki Laki', '12A'),
(6, 'Ren Kaidou', 'Laki Laki', '11B'),
(7, 'Rui Kenichi', 'Laki Laki', '10A'),
(8, 'Senliana Siel', 'Laki Laki', '11A');

CREATE TABLE `tagihan` (
  `id_tagihan` int(11) NOT NULL,
  `siswa_id` int(11) NOT NULL,
  `jenis_tagihan` varchar(50) NOT NULL,
  `jumlah` decimal(10,2) NOT NULL,
  `tanggal_tagihan` date NOT NULL,
  PRIMARY KEY (`id_tagihan`),
  KEY `siswa_id` (`siswa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tagihan` (`id_tagihan`, `siswa_id`, `jenis_tagihan`, `jumlah`, `tanggal_tagihan`) VALUES
(1, 1, 'Biaya Sekolah', 2500000.00, '2023-06-26'),
(2, 5, 'Study Tour', 2500000.00, '2023-07-05'),
(3, 8, 'Pendaftaran', 200000.00, '2023-04-01'),
(4, 6, 'Biaya Sekolah', 5200000.00, '2023-05-17'),
(5, 5, 'SPP', 100000.00, '2023-05-01');


ALTER TABLE `pembayaran`
  DROP PRIMARY KEY,
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`tagihan_id`) REFERENCES `tagihan` (`id_tagihan`);

ALTER TABLE `siswa`
  DROP PRIMARY KEY,
  ADD PRIMARY KEY (`id_siswa`);

ALTER TABLE `tagihan`
  DROP PRIMARY KEY,
  ADD PRIMARY KEY (`id_tagihan`),
  ADD CONSTRAINT `tagihan_ibfk_1` FOREIGN KEY (`siswa_id`) REFERENCES `siswa` (`id_siswa`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
