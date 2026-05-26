-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 26, 2026 at 03:33 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tokolaptop`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_laptop`
--

CREATE TABLE `data_laptop` (
  `id_laptop` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nama_laptop` varchar(100) NOT NULL,
  `spesifikasi` text NOT NULL,
  `stok` int NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_laptop`
--

INSERT INTO `data_laptop` (`id_laptop`, `nama_laptop`, `spesifikasi`, `stok`, `harga`) VALUES
('1', 'ROG Strix', 'Core i9 14900HX', 1, 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `data_pelanggan`
--

CREATE TABLE `data_pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `tingkat_member` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_pelanggan`
--

INSERT INTO `data_pelanggan` (`id_pelanggan`, `nama_pelanggan`, `tingkat_member`) VALUES
('1', 'SCP', 'Bronze'),
('2', 'scpk', 'Gold');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `nama_laptop` varchar(100) NOT NULL,
  `harga_awal` double NOT NULL,
  `diskon` double NOT NULL,
  `harga_akhir` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `nama_pelanggan`, `nama_laptop`, `harga_awal`, `diskon`, `harga_akhir`) VALUES
('1', 'scpk', 'ROG Zephyrus', 10000000, 1500000, 8500000),
('2', 'scpk', 'ROG Zephyrus', 10000000, 1500000, 8500000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_laptop`
--
ALTER TABLE `data_laptop`
  ADD PRIMARY KEY (`id_laptop`);

--
-- Indexes for table `data_pelanggan`
--
ALTER TABLE `data_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
