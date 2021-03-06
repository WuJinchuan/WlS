USE [wx]
GO
/****** Object:  Table [dbo].[CM_Company]    Script Date: 2018/11/24 20:14:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CM_Company](
	[COID] [nchar](16) NOT NULL,
	[NDID] [nchar](16) NULL,
	[CPID] [nchar](12) NULL,
	[CO_Base] [int] NULL,
	[CO_Type] [int] NULL,
	[LG_Code] [nvarchar](12) NULL,
	[CO_Name] [nvarchar](64) NULL,
	[CO_Addr] [nvarchar](96) NULL,
	[CO_Time] [datetime] NULL,
	[CO_State] [int] NULL,
	[CO_Share] [int] NULL,
	[CO_Phone] [nvarchar](32) NULL,
	[CO_Spell] [nvarchar](32) NULL,
	[CO_Linker] [nvarchar](16) NULL,
	[CO_LkCode] [nvarchar](32) NULL,
	[CO_E_Mail] [nvarchar](64) NULL,
	[CO_BkType] [int] NULL,
	[CO_BkCode] [nvarchar](64) NULL,
	[CO_AcName] [nvarchar](64) NULL,
	[CO_VcType] [nvarchar](16) NULL,
	[CO_VcName] [nvarchar](64) NULL,
	[CO_TxCode] [nvarchar](32) NULL,
	[CO_BcFate] [int] NULL,
	[CO_Stable] [int] NULL,
	[CO_VWRate] [float] NULL,
	[CO_Router] [nvarchar](256) NULL,
	[CO_Server] [nvarchar](256) NULL,
	[CO_ReMark] [nvarchar](960) NULL,
	[CO_MapX] [float] NULL,
	[CO_MapY] [float] NULL,
	[CO_LaType] [int] NULL,
	[CO_Starts] [int] NULL,
 CONSTRAINT [PK_CM_Company] PRIMARY KEY CLUSTERED 
(
	[COID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CM_Matcher]    Script Date: 2018/11/24 20:14:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CM_Matcher](
	[COID] [nchar](16) NOT NULL,
	[CR_Idx] [int] NULL,
	[CR_Mode] [int] NULL,
	[CT_Mode] [int] NULL,
	[CR_Fate] [float] NULL,
	[RG_Code] [nvarchar](12) NULL,
	[RG_Name] [nvarchar](32) NULL,
	[AR_Code] [nvarchar](12) NULL,
	[AR_Name] [nvarchar](32) NULL,
	[CM_Code] [nvarchar](16) NULL,
	[CM_Name] [nvarchar](32) NULL,
	[CR_Addr] [nvarchar](96) NULL,
	[CR_Style] [int] NULL,
	[CR_Grade] [int] NULL
) ON [PRIMARY]

GO
