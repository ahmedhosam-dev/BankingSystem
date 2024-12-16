-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2024 at 04:03 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banksystem_uni`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `balance` decimal(10,0) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `customer_id`, `status`, `balance`, `created_at`, `updated_at`) VALUES
(2, 3, 'ACTIVE', 0, '2024-12-15 16:53:24', '2024-12-16 14:06:18'),
(3, 4, 'ACTIVE', 10300, '2024-12-16 12:57:42', '2024-12-16 14:06:19');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `full_name`, `birthday`, `email`, `phone_number`, `address`, `status`) VALUES
(3, 'Ahmed', 'Ahmed Hossam', '2004-03-14', 'ahmedhosam.dev@gmail.com', '+201147021121', 'Cairo, Egypt', 'ACTIVE'),
(4, 'Ali', 'Ali Mohamed Ali', '1999-12-12', 'alimohamed@gmail.com', '+201147002123', 'Earth', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `recipient_account_id` int(11) DEFAULT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `type` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `account_id`, `recipient_account_id`, `amount`, `date`, `type`, `status`) VALUES
(4, 2, NULL, 20.00, '2024-12-15 20:13:47', 'DEPOSIT', 'SUCCESS'),
(5, 2, NULL, 0.00, '2024-12-15 16:53:24', 'DEPOSIT', 'FAILED'),
(6, 2, NULL, 100000.00, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(7, 2, NULL, 100000.00, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(8, 2, NULL, 12.22, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(9, 2, NULL, 10000234.12, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(10, 2, NULL, 1000000.00, '2024-12-16 02:01:21', 'WITHDRAW', 'SUCCESS'),
(11, 2, NULL, 9400246.00, '2024-12-16 02:01:45', 'WITHDRAW', 'SUCCESS'),
(12, 2, NULL, 234.00, '2024-12-16 02:01:58', 'WITHDRAW', 'FAILED'),
(13, 2, NULL, 22.00, '2024-12-16 02:23:32', 'WITHDRAW', 'FAILED'),
(14, 2, NULL, 22.00, '2024-12-16 02:25:33', 'WITHDRAW', 'FAILED'),
(15, 2, NULL, 22.00, '2024-12-16 02:28:43', 'WITHDRAW', 'FAILED'),
(16, 2, NULL, 22.00, '2024-12-16 02:30:52', 'WITHDRAW', 'FAILED'),
(17, 2, NULL, 222.00, '2024-12-16 12:14:20', 'WITHDRAW', 'FAILED'),
(18, 2, NULL, 222.00, '2024-12-16 12:14:35', 'TRANSFER', 'FAILED'),
(19, 2, NULL, 12.00, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(20, 2, NULL, 12.00, '2024-12-16 12:40:18', 'WITHDRAW', 'SUCCESS'),
(21, 2, NULL, 1000.00, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(22, 3, NULL, 22.00, '2024-12-16 12:58:47', 'TRANSFER', 'FAILED'),
(23, 2, NULL, 500.00, '2024-12-16 12:59:25', 'TRANSFER', 'SUCCESS'),
(24, 2, NULL, 500.00, '2024-12-16 13:00:50', 'TRANSFER', 'SUCCESS'),
(25, 2, NULL, 100.00, '2024-12-16 13:03:40', 'TRANSFER', 'SUCCESS'),
(26, 2, NULL, 10000.00, '2024-12-15 16:53:24', 'DEPOSIT', 'SUCCESS'),
(27, 2, NULL, 200.00, '2024-12-16 14:05:47', 'WITHDRAW', 'SUCCESS'),
(28, 2, NULL, 10200.00, '2024-12-16 14:06:17', 'TRANSFER', 'SUCCESS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `full_name`, `email`, `role`) VALUES
(5, 'mohamed', '$2a$10$oambil2/RT2Ic5IMEzF1tOlllNXYKfdXybzJ3DbYiO04tA5vfTZSu', 'Mohamed Ali', 'mohamedali@banksystem.com', 'EMPLOYEE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`status`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`status`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`status`),
  ADD KEY `type_id` (`type`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `recipient_account_id` (`recipient_account_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`recipient_account_id`) REFERENCES `account` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
