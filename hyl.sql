-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 21, 2022 lúc 06:01 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `hyl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `benh`
--

CREATE TABLE `benh` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Slg` int(5) NOT NULL,
  `infor` text COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `benh`
--

INSERT INTO `benh` (`ID`, `Ten`, `Slg`, `infor`) VALUES
(1, 'Sốt xuất huyết', 5, 'Triệu chứng thường xuất hiện đột ngột với sốt cao, người mệt mỏi rũ rượi, nhức đầu, đau sau hốc mắt, đau cơ, thường kèm theo đau họng, buồn nôn, nôn mửa, đau vùng thượng vị và tiêu chảy. Ở trẻ em, đau họng và đau bụng thường là những triệu chứng nổi trội.'),
(2, 'Cảm cúm', 6, 'Khi bị bệnh cúm, bệnh nhân sẽ có các triệu chứng như: Sốt cao, có khi lên tới 39-40 độ C, thân nhiệt không ổn định, có cảm giác ớn lạnh, hoặc rét run, nhức đầu.'),
(3, 'Covid-19', 6, 'Bệnh do vi-rút corona (COVID-19) là một bệnh truyền nhiễm do vi-rút SARS-CoV-2 gây ra.Hầu hết người mắc bệnh COVID-19 sẽ gặp các triệu chứng từ nhẹ đến trung bình và hồi phục mà không cần phải điều trị đặc biệt.'),
(6, 'Thiếu máu cơ tim', 7, 'Cơn đau thắt ngực được xem là triệu chứng thiếu máu cơ tim điển hình và phổ biến. Ban đầu, cơn đau thường khởi phát ở ngực trái, sau đó có thể lan ra vùng cổ, vai, cánh tay trái, hàm.'),
(10, 'Sốt rét', 7, 'Cơn đau thắt ngực được xem là triệu chứng thiếu máu cơ tim điển hình và phổ biến. Ban đầu, cơn đau thường khởi phát ở ngực trái, sau đó có thể lan ra vùng cổ, vai, cánh tay trái, hàm.'),
(12, 'Viêm họng cấp', 7, 'Cơ thể bị sốt cao từ 39 đến 40 độ C, ăn ngủ kém, cơ thể bị ớn lạnh và đau nhức. Khô nóng vùng cổ họng, kèm theo đó là triệu chứng đau nhói và đau rát.'),
(13, 'Viêm phổi', 8, 'Viêm phổi là một tình trạng bệnh lý hay gặp, thường do nhiễm trùng phổi gây ra, khiến các tổ chức tại phổi bị viêm và ảnh hưởng tới hoạt động chức năng của phổi. Viêm phổi gồm nhiều mức độ khác nhau, từ viêm phổi nhẹ cho tới mức độ nặng đe dọa tính mạng người bệnh.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `benhthuoc`
--

CREATE TABLE `benhthuoc` (
  `ID` int(11) NOT NULL,
  `idBenh` int(11) NOT NULL,
  `idThuoc` int(11) NOT NULL,
  `Slg` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `benhthuoc`
--

INSERT INTO `benhthuoc` (`ID`, `idBenh`, `idThuoc`, `Slg`) VALUES
(1, 2, 7, 3),
(2, 2, 8, 3),
(3, 2, 9, 3),
(19, 1, 4, 5),
(20, 1, 17, 5),
(21, 1, 20, 3),
(37, 12, 22, 4),
(38, 12, 23, 4),
(39, 12, 24, 4),
(41, 3, 4, 6),
(42, 3, 6, 6),
(43, 3, 25, 6),
(44, 6, 17, 5),
(45, 6, 18, 5),
(46, 6, 20, 5),
(47, 10, 26, 5),
(48, 10, 27, 5),
(49, 13, 28, 6),
(50, 13, 29, 6),
(51, 13, 30, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctb`
--

CREATE TABLE `ctb` (
  `ID` int(11) NOT NULL,
  `idB` int(11) NOT NULL,
  `idTC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctb`
--

INSERT INTO `ctb` (`ID`, `idB`, `idTC`) VALUES
(14, 1, 3),
(15, 1, 10),
(16, 1, 11),
(17, 1, 13),
(18, 1, 14),
(55, 2, 1),
(56, 2, 2),
(57, 2, 3),
(58, 2, 4),
(59, 2, 13),
(60, 2, 15),
(61, 10, 2),
(62, 10, 3),
(63, 10, 9),
(64, 10, 10),
(65, 10, 13),
(66, 10, 15),
(67, 10, 19),
(116, 12, 1),
(117, 12, 2),
(118, 12, 4),
(119, 12, 13),
(120, 12, 15),
(121, 12, 27),
(122, 12, 28),
(133, 3, 1),
(134, 3, 4),
(135, 3, 5),
(136, 3, 6),
(137, 3, 8),
(138, 3, 13),
(144, 6, 3),
(145, 6, 12),
(146, 6, 14),
(147, 6, 19),
(148, 6, 20),
(149, 6, 32),
(150, 6, 33),
(151, 13, 1),
(152, 13, 5),
(153, 13, 12),
(154, 13, 14),
(155, 13, 19),
(156, 13, 29),
(157, 13, 31),
(158, 13, 32);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt`
--

CREATE TABLE `ctdt` (
  `ID` int(11) NOT NULL,
  `idDon` int(11) NOT NULL,
  `idThuoc` int(11) NOT NULL,
  `Slg` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdt`
--

INSERT INTO `ctdt` (`ID`, `idDon`, `idThuoc`, `Slg`) VALUES
(120, 1137, 28, 6),
(121, 1137, 29, 6),
(122, 1137, 30, 6),
(123, 1138, 7, 3),
(124, 1138, 8, 3),
(125, 1138, 9, 3),
(126, 1139, 4, 6),
(127, 1139, 6, 6),
(128, 1139, 25, 6),
(129, 1140, 4, 6),
(130, 1140, 6, 6),
(131, 1140, 25, 6),
(132, 1141, 7, 3),
(133, 1141, 8, 3),
(134, 1141, 9, 3),
(135, 1142, 28, 6),
(136, 1142, 29, 6),
(137, 1142, 30, 6),
(138, 1143, 26, 5),
(139, 1143, 27, 5),
(140, 1144, 28, 6),
(141, 1144, 29, 6),
(142, 1144, 30, 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donthuoc`
--

CREATE TABLE `donthuoc` (
  `ID` int(10) NOT NULL,
  `idBenh` int(11) NOT NULL,
  `userName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `xs` decimal(10,2) NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donthuoc`
--

INSERT INTO `donthuoc` (`ID`, `idBenh`, `userName`, `xs`, `Date`) VALUES
(1137, 13, NULL, '96.00', '2022-08-20 20:59:02'),
(1138, 2, 'lby2001', '77.33', '2022-08-20 20:59:27'),
(1139, 3, 'lby2001', '60.67', '2022-08-20 20:59:51'),
(1140, 3, 'meo', '94.00', '2022-08-20 21:19:31'),
(1141, 2, 'meo', '77.33', '2022-08-20 21:20:06'),
(1142, 13, 'meo', '96.00', '2022-08-20 21:20:35'),
(1143, 10, 'huyen', '64.43', '2022-08-20 21:21:52'),
(1144, 13, 'lai', '71.00', '2022-08-20 21:22:36');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuoc`
--

CREATE TABLE `thuoc` (
  `ID` int(10) NOT NULL,
  `Ten` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Hoatchat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ctysx` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Nuocsx` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DVT` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thuoc`
--

INSERT INTO `thuoc` (`ID`, `Ten`, `Hoatchat`, `Ctysx`, `Nuocsx`, `DVT`) VALUES
(1, 'Casoran', 'Cao hoa hòe (3:1) ; Cao dừa cạn (6:1) ; Cao tâm sen (4:1) ; Cao cúc hoa (3:1)', 'Công ty cổ phần công nghệ cao Traphaco', 'Việt Nam', 'Viên'),
(2, 'Docetaxel 20mg', 'Docetaxel', 'Teva Pharmaceutical Works Private Limited Company', 'Hungary', 'Lọ'),
(3, 'Hà thủ ô', 'Cao đặc rễ hà thủ ô đỏ', 'Công ty cổ phần công nghệ cao Traphaco', 'Việt Nam', 'Viên'),
(4, 'Paracetamol', 'Paracetamol - 500 mg', 'Công ty cổ phần Dược phẩm Tipharco', 'Việt Nam', 'Viên'),
(5, 'Panadol Extra Đỏ 500Mg', 'Caffeine:65 mg; Paracetamol:500 mg', 'GlaxoSmithKline', 'Malaysia', 'Viên'),
(6, 'Molravir 400', 'Molnupiravir: 400 mg, Pregelatinized starch, crospovidon, colloidal silicon dioxyd, natri stearyl fumarat, natri lauryl sulfat,...', 'Công ty Cổ phần Dược phẩm Boston', 'Việt Nam', 'Viên'),
(7, 'Panadol Cảm Cúm ', 'Paracetamol 500mg, Caffeine 25mg, Phenylephrine hydrochloride 5mg.', 'Sanofi', 'Việt Nam', 'Viên'),
(8, 'Prednisolone 5Mg', 'Prednisolone: 5mg', 'Công ty cổ phần Dược phẩm Đồng Nai ', 'Việt Nam', 'Viên'),
(9, 'Topralsin', 'Paracetamol, Natri benzoat, Oxomemazin', 'Pharimexco', 'Việt Nam', 'Viên'),
(17, 'Aspirin 81mg', 'Aspirin: 81mg', 'Công ty Cổ phần Dược phẩm Agimexpharm', 'Việt Nam', 'Viên'),
(18, 'Ranexa', 'Ranolazine', 'Công ty Dược phẩm đa quốc gia Lupin', 'Ấn Độ', 'Viên'),
(19, 'Benazepril 10mg', 'Benazepril: 10mg', 'Công ty Cổ phần Dược phẩm Đạt Vi Phú - Davipharm', 'Việt Nam', 'Viên'),
(20, 'Meloxicam', 'Meloxicam: 7.5mg', 'Công ty Cổ phần Dược phẩm Imexpharm', 'Việt Nam', 'Viên'),
(21, 'Augmentin 625mg', 'Amoxicillin: 500mg, Acid clavulanic: 125mg', 'SmithKline Beecham Pharmaceuticals', 'Mỹ', 'Viên'),
(22, 'Beta-lactamin', 'Amoxicillin, Ceftriaxone, Cephalexin,… ', 'Sanofi', 'Pháp', 'Viên'),
(23, 'Macrolid', 'Clarithromycin, Azithromycin, Erythromycin, Clarithromycin, Azithromycin.', ' Bouchara Recordati', 'Pháp', ''),
(24, 'NSAID', 'Diclofenac, Ibuprofen.', 'Fareva Amboise', 'Mỹ', 'Viên'),
(25, 'Molnupiravir 400mg', 'Molnupiravir: 400mg', 'Công ty TNHH Liên doanh Stellapharm', 'Việt Nam', 'Viên'),
(26, 'Quinine sulphate 250mg', 'Quinine sulphate: 250mg, Lactose, Gelatin, Tinh bột bắp, Croscarmellose sodium, Talc, Magnesium stearate', 'Công ty cổ phần hóa - Dược phẩm Mekophar', 'Việt Nam', 'Viên'),
(27, 'Clindastad 150mg', 'Clindamycin HCl:150mg', 'Stellapharm', 'Việt Nam', 'Viên'),
(28, 'Azithromycin 250mg', 'Azithromycin: 250mg, Lactose, Talc, Magnesi stearate', 'Dược Hậu Giang', 'Việt Nam', 'Viên'),
(29, 'Clarithromycin 250mg', 'Clarithromycin: 250mg', 'Stellapharm', 'Việt Nam', 'Viên'),
(30, 'Erythromycin 250mg', 'Erythromycin: 250mg, Đường trắng, Acesulfam K, Gôm xanthan, Natri citrat, Mannitol, Povidon, Mùi Vanillin, Bột mùi dâu, Colloidal Silicon dioxid.', 'Mekophar', 'Việt Nam', 'Gói');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trieuchung`
--

CREATE TABLE `trieuchung` (
  `ID` int(10) NOT NULL,
  `Ten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `trieuchung`
--

INSERT INTO `trieuchung` (`ID`, `Ten`) VALUES
(1, 'Ho khan'),
(2, 'Sổ mũi'),
(3, 'Đau đầu'),
(4, 'Đau họng'),
(5, 'Khó thở'),
(6, 'Mắt đỏ'),
(7, 'Tiêu chảy'),
(8, 'Mất vị giác'),
(9, 'Hắt hơi'),
(10, 'Phát ban'),
(11, 'Đau nhức cơ'),
(12, 'Tức ngực'),
(13, 'Sốt'),
(14, 'Buồn nôn'),
(15, 'Nghẹt mũi'),
(16, 'Chóng mặt'),
(17, 'Khó tiêu'),
(19, 'Đổ mồ hôi lạnh'),
(20, 'Nhịp tim nhanh'),
(21, 'Đầy bụng'),
(22, 'Hởi thở hôi'),
(23, 'Chảy mũi mủ'),
(24, 'Đau nhức ở mặt'),
(25, 'Nhịp tim chậm'),
(26, 'Đau lưng'),
(27, 'Khàn giọng'),
(28, 'Nổi hạch vùng cổ'),
(29, 'Ho đờm'),
(30, 'Thở nhanh'),
(31, 'Ớn lạnh'),
(32, 'Yếu người'),
(33, 'Xây xẩm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `ID` int(10) NOT NULL,
  `Username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `admin` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`ID`, `Username`, `Password`, `Email`, `admin`) VALUES
(1, 'lby2001', 'baoyen', 'baoyen@gmail.com', 1),
(2, 'huyen', 'huyen', 'thaohuyen@gmail.com', 1),
(3, 'lai', 'lai', 'thailai@gmail.com', 1),
(4, 'meo', 'meo', 'meo@gmail.com', 0),
(5, 'aaaaaa', 'hihi', 'hihi@gmail.com', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `benh`
--
ALTER TABLE `benh`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `benhthuoc`
--
ALTER TABLE `benhthuoc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idBenh` (`idBenh`),
  ADD KEY `idThuoc` (`idThuoc`);

--
-- Chỉ mục cho bảng `ctb`
--
ALTER TABLE `ctb`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idB` (`idB`),
  ADD KEY `idTC` (`idTC`);

--
-- Chỉ mục cho bảng `ctdt`
--
ALTER TABLE `ctdt`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idThuoc` (`idThuoc`),
  ADD KEY `idDon` (`idDon`);

--
-- Chỉ mục cho bảng `donthuoc`
--
ALTER TABLE `donthuoc`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `userName` (`userName`),
  ADD KEY `idBenh` (`idBenh`);

--
-- Chỉ mục cho bảng `thuoc`
--
ALTER TABLE `thuoc`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `trieuchung`
--
ALTER TABLE `trieuchung`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `benh`
--
ALTER TABLE `benh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `benhthuoc`
--
ALTER TABLE `benhthuoc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT cho bảng `ctb`
--
ALTER TABLE `ctb`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;

--
-- AUTO_INCREMENT cho bảng `ctdt`
--
ALTER TABLE `ctdt`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=143;

--
-- AUTO_INCREMENT cho bảng `donthuoc`
--
ALTER TABLE `donthuoc`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1145;

--
-- AUTO_INCREMENT cho bảng `thuoc`
--
ALTER TABLE `thuoc`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `trieuchung`
--
ALTER TABLE `trieuchung`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `user_account`
--
ALTER TABLE `user_account`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `benhthuoc`
--
ALTER TABLE `benhthuoc`
  ADD CONSTRAINT `benhthuoc_ibfk_1` FOREIGN KEY (`idBenh`) REFERENCES `benh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `benhthuoc_ibfk_2` FOREIGN KEY (`idThuoc`) REFERENCES `thuoc` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctb`
--
ALTER TABLE `ctb`
  ADD CONSTRAINT `ctb_ibfk_1` FOREIGN KEY (`idB`) REFERENCES `benh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctb_ibfk_2` FOREIGN KEY (`idTC`) REFERENCES `trieuchung` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt`
--
ALTER TABLE `ctdt`
  ADD CONSTRAINT `ctdt_ibfk_1` FOREIGN KEY (`idThuoc`) REFERENCES `thuoc` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctdt_ibfk_2` FOREIGN KEY (`idDon`) REFERENCES `donthuoc` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `donthuoc`
--
ALTER TABLE `donthuoc`
  ADD CONSTRAINT `donthuoc_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `user_account` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `donthuoc_ibfk_2` FOREIGN KEY (`idBenh`) REFERENCES `benh` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
