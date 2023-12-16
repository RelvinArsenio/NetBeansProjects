SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `service` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `service`;

CREATE TABLE `jasa` (
  `id_jasa` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `notelp` varchar(15) NOT NULL,
  `jenis_service` varchar(50) NOT NULL,
  `tarif_service` int(11) NOT NULL,
  `biaya_tambahan` int(11) NOT NULL,
  `total_bayar` int(11) GENERATED ALWAYS AS (`tarif_service` + `biaya_tambahan`) VIRTUAL,
  PRIMARY KEY (`id_jasa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `jasa` (`id_jasa`, `nama`, `notelp`, `jenis_service`, `tarif_service`, `biaya_tambahan`) VALUES
(1, 'Relvin Arsenio', '081291910202', 'Perbaikan Software', 200000, 55000),
(2, 'Rino Aldera', '081234576796', 'Penggantian Mesin', 1000000, 250000),
(3, 'Rizky Juniardi', '0812345678', 'Penggantian Baterai', 350000, 0),
(4, 'Valian Ardafi', '08123456345', 'Perbaikan Layar', 500000, 0);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
