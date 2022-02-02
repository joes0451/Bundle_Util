/*
 * :folding=explicit:collapseFolds=1:
 */

/**
 *	  Bundle_Util is a utility for Android's bundletool
 *
 *	  Copyright (c) 2022 Joseph Siebenmann
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General  Public License as published by
 *    the Free Software Foundation; version 2.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see<http://www.gnu.org/licenses/>.
 */

package com.dominionmobile.bundleutil;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.DefaultListModel;
import javax.swing.*;
import java.awt.Color;
import java.awt.List;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.util.Iterator;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.UIDefaults;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.ListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.swing.plaf.ColorUIResource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.text.*;
import java.util.Properties;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Bundle_Util
{
    
    //{{{   Data

    private static JPanel mainPanel;
    private static JPanel cardPanel;
    private static JFrame mainJFrame;
    private static JFrame selectDeviceFrame;
    private static JFrame selectPackageFrame;
    
    private static JFrame installApksFrame;
    private static JFrame buildApksFrame;
    private static JFrame extractApksFrame;
    private static JFrame installMultiApksFrame;    
    private static JFrame getDeviceSpecFrame;
    private static JFrame validateFrame;
    private static JFrame getSizeFrame;
    private static JFrame buildBundleFrame;
    private static JFrame dumpFrame;
    private static JFrame requestFrame;
    
    private static JTextField outputField;
    private static JTextField deviceSpecPathField;
    
    private static JTextPane textPane;
    private static JTextField currentPathField;
    private static JSpinner deviceSpinner;
    private static JSpinner fileSpinner;
    private static JMenuItem logcatMenuItem;

    private static JPanel textAreaPanel;
    private static JMenu subMenu;
    private static JTextField apksPathField;
    private static JTextField aabPathField;
    private static JTextField outputPathField;
    private static JSpinner modeSpinner; 
    private static JSpinner dumpSpinner;
    private static JCheckBox connectedDeviceCheckBox;
    private static JCheckBox overwriteCheckBox;
    private static JCheckBox humanReadableSizesCheckBox;
    private static JCheckBoxMenuItem releaseCheckBoxMenuItem;
    private static JCheckBoxMenuItem debugCheckBoxMenuItem;
    
	private JLabel statusLabel;
	private JLabel deviceLabel;
	private JLabel packageLabel;
	private JLabel statusPath;
    
    private static Bundle_Util bundle_Util;
    
    static volatile String sInternalCommand;
    static volatile String sDeviceName;
    static volatile String commandResultS;
    static volatile String sAndroidSdkPath;
    static volatile String sListSelection;
    static volatile String commandS;
    static volatile String outputEndS;
    static volatile String sCurrentPath;

    static volatile String sProjectHome;    
    static volatile String sProjectPathLead;
    static volatile String sJavaPath;
    static volatile String sBundleToolJarPath;
    static volatile String sApksPath;
    static volatile String sAabPath;
    static volatile String sKeyStorePath;
    static volatile String sKeyAlias;
    static volatile String sKeyStorePassword;
    static volatile String sKeyAliasPassword;
    
    static volatile String sStampKeyStorePath;    
    static volatile String sStampKeyAlias;    
    static volatile String sStampKeyStorePassword;     
    static volatile String sStampKeyAliasPassword;    
    
    static volatile String sDialogTitle;
    static volatile String sCommand;
    static volatile String sOutputPathFieldLbl;
    static volatile String sDumpMode;
    static volatile String sOutputPath;
    
    static volatile String sAdbPath;
    static volatile String sDeviceSpec;
    static volatile String sDeviceTier;
    static volatile String sAapt2Path;
    static volatile String sDeviceId;
    static volatile String sLineage;
    static volatile String sMaxThreads;
    static volatile String sMinApiVersion;
    static volatile String sStampSource;
    static volatile String sOldestSigner;
    static volatile String sModuleFiles;
    static volatile String sModuleNames;
    static volatile String sMetadataFile;
    static volatile String sConfig;
    static volatile String sModules;
    static volatile String sOutputDir;
    static volatile String sOutputFormat;
    static volatile String sOptimizeFor;
    static volatile String sTimeoutMillis;
    static volatile String sApks;
    static volatile String sApksZip;
    static volatile String sDeviceGroups;
    static volatile String sModule;
    
    static volatile String sVerboseFlag;   
    static volatile String sIncludeMetadataFlag;    
    static volatile String sInstantFlag;    
    static volatile String sCreateStampFlag;    
    static volatile String sAdditionalLocalTestingFilesFlag;    
    static volatile String sAllowDowngradeFlag;     
    static volatile String sAllowTestOnlyFlag;   
    static volatile String sValuesFlag;    
    static volatile String sEnableRollbackFlag;    
    static volatile String sStagedFlag;    
    static volatile String sUpdateOnlyFlag;   
    static volatile String sLocalTestingFlag;
    static volatile String sOutputPathFile;
    static volatile String sCommandSummary;
    static volatile String sShowCommandSummary;
    static volatile String sModuleNamesExtract;
    
    static volatile String[] tokSa;
    
    static volatile boolean bCommandFinished;
    static volatile boolean bDevicesFinished;
    static volatile boolean bBreakOut;
    static volatile boolean bIOBgThreadBreak;
    static volatile boolean bLogcatOn;
    static volatile boolean bFinished;
    static volatile boolean bIOBgThreadFinished;
    static volatile boolean bSelectFinished;
    static volatile boolean bProjectSelected;
    static volatile boolean bHomeJustSet;
    
    static volatile boolean bShowAabPath;
    static volatile boolean bShowApksPath;
    static volatile boolean bShowDeviceSpecPath;
    static volatile boolean bShowHumanReadableSizes;
    static volatile boolean bShowOutputPathField;
    static volatile boolean bShowModeSpinner;
    static volatile boolean bShowDumpSpinner;
    static volatile boolean bShowConnectedDeviceCb;
    static volatile boolean bShowOverwriteCb;
    static volatile boolean bShowLocalTestingCb;
    static volatile boolean bDebugSelected;
    static volatile boolean bShowInstallMultiApksText;
    
    static volatile int iOS;
    static volatile int iListId;
    static volatile int iSelectMode;
    static volatile int iButtonCount;
    
    static volatile long lPrevTime;
    
	private StyledDocument doc;
	private Style normalStyle;
	private Style warningStyle;
	private Style errorStyle;
    
    static ArrayList<String> FilesAr;
    static ArrayList<String> DevicesAr = null;
    static ArrayList<String> ConnectDevicesAr;
    static ArrayList<String> fileToksAr;
    
    static CountDownLatch commandRequestLatch;
    static CountDownLatch completeLatch;
    
    CardLayout cardLayout;
    
    private static Semaphore commandControl = new Semaphore(1);
    
    private byte[] tempBuf = new byte[4096];
    private StringBuffer lineSb = new StringBuffer(4096);

    CommandBgThread commandBgThread;    
    GetDevicesBgThread getDevicesBgThread;
    IOBgThread iOBgThread;
    
	static final int WINDOWS = 0;
	static final int LINUX_MAC = 1;
	
	static final int NORMAL = 0;
	static final int WARNING = 1;
	static final int ERROR = 2;
	
	static final int SELECT_NORMAL = 0;
	static final int SELECT_CONNECT = 1;
	
	static final int FONT_SIZE = 13;

	static final int DISPLAY_WIDTH = 105;
	static final int DISPLAY_BREAK_WIDTH = DISPLAY_WIDTH - 5;
	
	static final String SELECT_DEVICE = "Select Device";
	static final String DEVICES = "Devices";
	
	static final String SELECT_DEVICE_CANCEL = "select_device_cancel";
	static final String SELECT_DEVICE_SUBMIT = "select_device_submit";

	static final String HOME = "Home";
	
	static final String BUILD_BUNDLE = "build-bundle";
	static final String BUILD_APKS = "build-apks";
	static final String INSTALL_APKS = "install-apks";
	static final String EXTRACT_APKS = "extract-apks";
	static final String INSTALL_MULTI_APKS = "install-multi-apks";
	static final String GET_DEVICE_SPEC = "get-device-spec";
	static final String VALIDATE = "validate";
	static final String GET_SIZE = "get-size";
	static final String VERSION = "version";
	static final String DUMP = "dump";
	
	static final String AAB_PATH_CHOOSER = "aab_path_chooser";
	static final String APKS_PATH_CHOOSER = "apks_path_chooser";
	static final String DEVICE_SPEC_PATH_CHOOSER = "device_spec_path_chooser";
	
	static final String RELEASE = "Release";
	static final String DEBUG = "Debug";

	static final String REQUEST_SUBMIT = "request_submit";
	static final String REQUEST_CANCEL = "request_cancel";
	
    //}}}

    //{{{   Bundle_Util() constructor    
    public Bundle_Util()
    {
        //System.out.println("Bundle_Util()");
		// Determine OS..
		String sOs = System.getProperty("os.name").toLowerCase();
		if (sOs.contains("win"))
			iOS = WINDOWS;
		else if ((sOs.contains("nix")) ||
                (sOs.contains("nux")) ||
                (sOs.contains("mac")))
			iOS = LINUX_MAC;
		
		sProjectPathLead = "";
		SingletonClass sc = SingletonClass.getInstance();
		sc.sBundlePath = "";
		sc.bConnected = false;
		
		CreateGui();
		RefreshProperties();
		
		init();
		
		sCurrentPath = "";
		iButtonCount = 0;
		lPrevTime = 0;
		sCommand = "";
		
		
		/**
         * Get number of running Emulators or devices..
         */

		bDevicesFinished = false;
		getDevicesBgThread = new GetDevicesBgThread();
		getDevicesBgThread.start();

		while ( true )
		{			
			try
			{
			    Thread.sleep(150);
			}
			catch (InterruptedException ie)
			{
			}
			
			if ( bDevicesFinished )
			    break;
		}

/*
		if ( DevicesAr == null )
		    System.out.println("DevicesAr null");
		else
		    System.out.println("DevicesAr.size(): "+DevicesAr.size());
/**/		
		
		if ( (DevicesAr	!= null) && (DevicesAr.size() > 0) )
		{
			if ( DevicesAr.size() > 1 )
			{
				// Open Dialog..
				selectDeviceDialog();
			}
			else
			{
			    sc.bConnected = true;
			    
				// Single device, show it..
				deviceLabel.setText((String)DevicesAr.get(0));
				sDeviceName = (String)DevicesAr.get(0);
			}
		}
    }   //}}}

	//{{{	RefreshProperties()
	private void RefreshProperties()
	{
	    //System.out.println("RefreshProperties()");
		// Read Properties..
		String sT = "";
		Properties prop = new Properties();

		try
		{
			prop.load(new FileInputStream("config.properties"));

			// Get Property Values..
			sJavaPath = processPath(prop.getProperty("java_path"));
			sAndroidSdkPath = processPath(prop.getProperty("android_sdk_path"));
			sBundleToolJarPath = processPath(prop.getProperty("bundletool_jar_path"));
			sShowCommandSummary = processPath(prop.getProperty("show_command_summary"));

			// Fields..
			sAdbPath = processPath(prop.getProperty("adb_path"));
			sDeviceSpec = processPath(prop.getProperty("device_spec"));
			sDeviceTier = processPath(prop.getProperty("device_tier"));
			sAapt2Path = processPath(prop.getProperty("aapt2_path"));
			sDeviceId = processPath(prop.getProperty("device_id"));
			sLineage = processPath(prop.getProperty("lineage"));
			sMaxThreads = processPath(prop.getProperty("max_threads"));
			sMinApiVersion = processPath(prop.getProperty("min_api_version"));
			sStampSource = processPath(prop.getProperty("stamp_source"));
			sOldestSigner = processPath(prop.getProperty("oldest_signer"));
			sModuleFiles = processPath(prop.getProperty("module_files"));
			sModuleNames = processPath(prop.getProperty("module_names"));
			
			sModuleNamesExtract = processPath(prop.getProperty("modules"));
			sMetadataFile = processPath(prop.getProperty("metadata_file"));
			sConfig = processPath(prop.getProperty("config"));
			sModules = processPath(prop.getProperty("modules"));
			sOutputDir = processPath(prop.getProperty("output_dir"));
			sOutputFormat = processPath(prop.getProperty("output_format"));
			sOptimizeFor = processPath(prop.getProperty("optimize_for"));
			sTimeoutMillis = processPath(prop.getProperty("timeout_millis"));
			sApks = processPath(prop.getProperty("apks"));
			sApksZip = processPath(prop.getProperty("apks_zip"));
			sDeviceGroups = processPath(prop.getProperty("device_groups"));
			
            // Flags..			
			sVerboseFlag = processPath(prop.getProperty("verbose_flag"));
			sIncludeMetadataFlag = processPath(prop.getProperty("include_metadata_flag"));
			sInstantFlag = processPath(prop.getProperty("instant_flag"));
			sCreateStampFlag = processPath(prop.getProperty("create_stamp_flag"));
			sAdditionalLocalTestingFilesFlag = processPath(prop.getProperty("additional_local_testing_files_flag"));
			sAllowDowngradeFlag = processPath(prop.getProperty("allow_downgrade_flag"));
			sAllowTestOnlyFlag = processPath(prop.getProperty("allow_test_only_flag"));
			sValuesFlag = processPath(prop.getProperty("values_flag"));
			sEnableRollbackFlag = processPath(prop.getProperty("enable_rollback_flag"));
			sStagedFlag = processPath(prop.getProperty("staged_flag"));
			sUpdateOnlyFlag = processPath(prop.getProperty("update_only_flag"));
			sLocalTestingFlag = processPath(prop.getProperty("local_testing_flag"));
			
			sKeyStorePath = processPath(prop.getProperty("keystore_path"));
			sKeyAlias = processPath(prop.getProperty("key_alias"));
			sKeyStorePassword = processPath(prop.getProperty("key_store_password"));
			sKeyAliasPassword = processPath(prop.getProperty("key_alias_password"));

			sStampKeyStorePath = processPath(prop.getProperty("stamp_keystore_path"));
			sStampKeyAlias = processPath(prop.getProperty("stamp_key_alias"));
			sStampKeyStorePassword = processPath(prop.getProperty("stamp_key_store_password"));
			sStampKeyAliasPassword = processPath(prop.getProperty("stamp_key_alias_password"));
			
		}
		catch (IOException ioe)
		{
			System.out.println("RefreshProperties() Exception");
			ioe.printStackTrace();
		}
		
		//System.out.println("Exiting RefreshProperties()");

	} //}}}

	//{{{	init()
	private void init()
	{
	    // Read Project Home from Persistent storage
		String tokS = "";
		String sT = "";
		int iLoc;
		byte[] buf = null;
		//System.out.println("init()");
		
		//System.out.println("bProjectSelected: "+bProjectSelected);
        if ( bProjectSelected )
            ;
        else
        {
            // Try to read from Persistent storage..
            
            // Like:  C:/Android/Dev/G_GameNew
            buf = readFile(1000, "store.tmp");
            if ( (buf != null) && (buf.length > 0) )
                tokS = new String(buf);
/*                
            if ( tokS == null )
                System.out.println("tokS null");
            else
                System.out.println("tokS: '"+tokS+"'");
/**/
    
            // Save the state of each..		
            if ( (tokS != null) && (! tokS.equals("")) )
            {
                tokS = tokS.trim();
                bHomeJustSet = true;
                sProjectHome = tokS;
                
                if ( statusLabel != null )
                    statusLabel.setText(sProjectHome);
                
                iLoc = sProjectHome.lastIndexOf('/');
                if ( iLoc != -1 )
                    sProjectPathLead = sProjectHome.substring(0, iLoc);
/*                
                if ( sProjectPathLead == null )
                    System.out.println("sProjectPathLead null");
                else
                    System.out.println("sProjectPathLead: '"+sProjectPathLead+"'");
/**/
                
                StringTokenizer st = new StringTokenizer(tokS, "~");
                int iCount = st.countTokens();
                
                for ( int iG = 0; iG < iCount; iG++ )
                {
                    if ( iG == 0 )
                    {
                        // Home..
                        bHomeJustSet = true;
                        sProjectHome = st.nextToken();
                        //System.out.println("sProjectHome: '"+sProjectHome+"'");
    
                        if ( statusLabel != null )
                            statusLabel.setText(sProjectHome);
                        
                        iLoc = sProjectHome.lastIndexOf('/');
                        if ( iLoc != -1 )
                            sProjectPathLead = sProjectHome.substring(0, iLoc);
                    }
                    else if ( iG == 1 )
                    {
                        // Bundle path..
                        sT = st.nextToken();
                        
                        // Load..
                        SingletonClass sc = SingletonClass.getInstance();
                        sc.sBundlePath = sT;
                    }
                }	// End for..
                
                // Reset..			
                bHomeJustSet = false;
            }
        }
        
        if ( bProjectSelected )
            bProjectSelected = false;   // Reset..
        
        //System.out.println("Exiting init()");
        
	}	//}}}
    
	//{{{	CreateGui()
	public void CreateGui()
	{
	    //System.out.println("CreateGui()");
	    int iFontSize = FONT_SIZE;
	    byte[] buf = null;
	    
		// Use BorderLayout..
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		GridBagLayout gridbag = new GridBagLayout();

		JPanel topPanel = new JPanel();
		topPanel.setLayout(gridbag);

		/**
		 *		Menus
		 */

		GridBagConstraints menuBarGbc = new GridBagConstraints();

		JMenuBar menuBar = new JMenuBar();
		
		JMenu projectMenu = new JMenu("Project");
		
		JMenuItem homeMenuItem = new JMenuItem("Home");
		homeMenuItem.addActionListener(actListener);
		subMenu = new JMenu("Recent Projects");
		JMenuItem subMenuItem = null;

		// Construct Submenu..
		String sOut = "";
		String[] sAr;
		buf = readFile(1000, "recent.tmp");
		if ( (buf != null) && (buf.length > 0) )
		    sOut = new String(buf);
		
		if ( (sOut != null) && (sOut.length() > 0) )
		{
		    
		    sAr = sOut.split("~");
		    
			int iLoc;
			String sTok;
			String sTitle;
			for ( int iG = 0; iG < sAr.length; iG++ )
			{
				sTok = sAr[iG];
				//System.out.println("sTok: '"+sTok+"'");
				if ( (iG % 2) == 0 )    // Even..
				{
					// Get title..
					iLoc = sTok.lastIndexOf('/');
					if ( iLoc != -1 )
					{
						sTitle = sTok.substring(iLoc + 1);
						//System.out.println("sTitle: '"+sTitle+"'");
						subMenuItem = new JMenuItem(sTitle);
						subMenuItem.addActionListener(actListener);
						subMenu.add(subMenuItem);
					}
				}
			}
		}
		
		JMenuItem selectDeviceMenuItem = new JMenuItem("Select Device");
		selectDeviceMenuItem.addActionListener(actListener);

		releaseCheckBoxMenuItem = new JCheckBoxMenuItem("Release");
		releaseCheckBoxMenuItem.addActionListener(actListener);
		debugCheckBoxMenuItem = new JCheckBoxMenuItem("Debug");
		debugCheckBoxMenuItem.addActionListener(actListener);
		
        releaseCheckBoxMenuItem.setState(true);
        debugCheckBoxMenuItem.setState(false);

		projectMenu.add(homeMenuItem);
		projectMenu.add(subMenu);
		projectMenu.add(selectDeviceMenuItem);
		projectMenu.addSeparator();
		projectMenu.add(releaseCheckBoxMenuItem);
		projectMenu.add(debugCheckBoxMenuItem);
		menuBar.add(projectMenu);
		
		JMenu buildMenu = new JMenu("Build");
		JMenuItem buildBundleMenuItem = new JMenuItem("build-bundle");
		buildBundleMenuItem.addActionListener(actListener);
		JMenuItem buildApksMenuItem = new JMenuItem("build-apks");
		buildApksMenuItem.addActionListener(actListener);

		buildMenu.add(buildBundleMenuItem);
		buildMenu.add(buildApksMenuItem);
		menuBar.add(buildMenu);

		JMenu extractMenu = new JMenu("Extract");
		JMenuItem extractApksMenuItem = new JMenuItem("extract-apks");
		extractApksMenuItem.addActionListener(actListener);

		extractMenu.add(extractApksMenuItem);
		menuBar.add(extractMenu);
		
		JMenu installMenu = new JMenu("Install");
		JMenuItem installApksMenuItem = new JMenuItem("install-apks");
		installApksMenuItem.addActionListener(actListener);
		JMenuItem installMultipleApksMenuItem = new JMenuItem("install-multi-apks");
		installMultipleApksMenuItem.addActionListener(actListener);
		
		installMenu.add(installApksMenuItem);
		installMenu.add(installMultipleApksMenuItem);
		menuBar.add(installMenu);

		JMenu otherCommandsMenu = new JMenu("Other Commands");
		JMenuItem getDeviceSpecMenuItem = new JMenuItem("get-device-spec");
		getDeviceSpecMenuItem.addActionListener(actListener);
		JMenuItem validateMenuItem = new JMenuItem("validate");
		validateMenuItem.addActionListener(actListener);
		JMenuItem dumpMenuItem = new JMenuItem("dump");
		dumpMenuItem.addActionListener(actListener);
		JMenuItem getSizeMenuItem = new JMenuItem("get-size");
		getSizeMenuItem.addActionListener(actListener);
		JMenuItem versionMenuItem = new JMenuItem("version");
		versionMenuItem.addActionListener(actListener);

		otherCommandsMenu.add(getDeviceSpecMenuItem);
		otherCommandsMenu.add(validateMenuItem);
		otherCommandsMenu.add(dumpMenuItem);
		otherCommandsMenu.add(getSizeMenuItem);
		otherCommandsMenu.add(versionMenuItem);
		menuBar.add(otherCommandsMenu);

		menuBarGbc.gridy = 0;
		menuBarGbc.gridheight = 1;
		menuBarGbc.weightx = 1.0;
		menuBarGbc.gridwidth = GridBagConstraints.REMAINDER;
		menuBarGbc.fill = GridBagConstraints.HORIZONTAL;
		menuBarGbc.anchor = GridBagConstraints.WEST;

		topPanel.add(menuBar, menuBarGbc);

		/**
		 *		Console Pane
		 */

		cardLayout = new CardLayout(); 
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);

		Dimension dim = new Dimension();
		dim = topPanel.getPreferredSize();

		Font defaultFont = new Font("Monospaced", Font.BOLD, FONT_SIZE);
		FontMetrics fontMetrics = mainPanel.getFontMetrics(defaultFont);
		
		int iChrW = fontMetrics.charWidth('X');
		int iHgt = fontMetrics.getHeight();
		
		topPanel.setPreferredSize(new Dimension(iChrW * DISPLAY_WIDTH, (int)dim.getHeight()));	// Original

		UIDefaults defs = UIManager.getDefaults();
		defs.put("TextPane.background", new ColorUIResource(Color.BLACK));
		defs.put("TextPane.inactiveBackground", new ColorUIResource(Color.BLACK));

		StyleContext styleContext = new StyleContext();
		doc = new DefaultStyledDocument(styleContext);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setPreferredSize(new Dimension(iChrW * DISPLAY_WIDTH, iHgt * 20));
		textPane.setBorder(BorderFactory.createEmptyBorder());	// Remove default (white) margin..
		
		normalStyle = styleContext.addStyle("Normal", null);
		normalStyle.addAttribute(StyleConstants.Foreground, new Color(224, 224, 224));
		normalStyle.addAttribute(StyleConstants.FontSize, new Integer(iFontSize));
		normalStyle.addAttribute(StyleConstants.FontFamily, "Monospaced");
		normalStyle.addAttribute(StyleConstants.Bold, new Boolean(true));

		warningStyle = styleContext.addStyle("Warning", null);
		warningStyle.addAttribute(StyleConstants.Foreground, new Color(255, 158, 13));
		warningStyle.addAttribute(StyleConstants.FontSize, new Integer(iFontSize));
		warningStyle.addAttribute(StyleConstants.FontFamily, "Monospaced");
		warningStyle.addAttribute(StyleConstants.Bold, new Boolean(true));

		errorStyle = styleContext.addStyle("Error", null);
		errorStyle.addAttribute(StyleConstants.Foreground, new Color(255, 25, 25));
		errorStyle.addAttribute(StyleConstants.FontSize, new Integer(iFontSize));
		errorStyle.addAttribute(StyleConstants.FontFamily, "Monospaced");
		errorStyle.addAttribute(StyleConstants.Bold, new Boolean(true));
		
		JScrollPane scrollPane = new JScrollPane(textPane,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setPreferredSize(new Dimension(iChrW * DISPLAY_WIDTH, iHgt * 20));
		
		cardPanel.add(scrollPane);
		

		/**
		 *		Status Bar..
		 */

		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		int iGridX = 0;

		JPanel statusBar = new JPanel();
		statusBar.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();

		statusLabel = new JLabel(" ");        // <-- (Set)
		statusLabel.setBorder(loweredBevel);

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = iGridX;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2); // top left bottom right

		statusBar.add(statusLabel, gbc);
		
		iGridX++;
		
		deviceLabel = new JLabel(" ");			// <-- (Set)
		deviceLabel.setBorder(loweredBevel);

		if ( (sDeviceName != null) && (sDeviceName.length() > 0) )
			statusLabel.setText(sDeviceName);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = iGridX;
		gbc.weightx = 0.1;
		gbc.insets = new Insets(2, 2, 2, 2);	// top left bottom right
		
		statusBar.add(deviceLabel, gbc);
		
		iGridX++;

		statusPath = new JLabel(" ");			// <-- (Set)
		statusPath.setBorder(loweredBevel);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = iGridX;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2);	// top left bottom right
		
		statusBar.add(statusPath, gbc);
		
		dim = statusBar.getPreferredSize();
		statusBar.setPreferredSize(new Dimension(iChrW, (int)dim.getHeight()));
		statusBar.setMaximumSize(new Dimension(iChrW, (int)dim.getHeight()));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
		mainPanel.add(statusBar, BorderLayout.SOUTH);

	} //}}}

	//{{{	IOBgThread
	/**
     * Handle commands and console output 
     */
	class IOBgThread extends Thread
	{
		public void run()
		{
			//System.out.println("\nIOBgThread run()");
			Process proc = null;			
			OutputStream os = null;
			
			InputStream error_is = null;
			InputStream out_is = null;
			BufferedInputStream error_bis = null;
			BufferedInputStream out_bis = null;
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] writeBuf;
			byte[] bZeroD = {(byte)0x0d};
			String sZeroD = new String(bZeroD);
			byte[] bZeroA = {(byte)0x0a};
			String sZeroA = new String(bZeroA);

			int iBytesRead = 0;
			int iCount;
			int iExitVal;
			int iTotalBytes;
			int iG;
			int iLoc;
			int iLoc2 = 0;
			int iLoc3 = 0;
			int iLoc4 = 0;
			int iLoc5 = 0;
			int iLoc6 = 0;
			int iLen;
			int iLEnd = -1;
			int iLenSave = 0;
			int iCurrentType = NORMAL;
			int iTmpLength = tempBuf.length;
			int iIndex;
			int iType;
			int iLineLen;
			int iLnLength;
			int iStart;
			int iLen2;
			
			int iBlockIndex = 0;
			int iBlockCharCount = 0;
			int iIdx;
			int iG3;
			int iT;
			int iZ;
			int iY;
			int iBIndex;
			int iClosest;
			int iInsertLoc;
			int iHalf;
			int iChunkLen;
			int iArrayIndex = 0;
			int iPartialLength = 0;
			int iBlockCount = 0;
			int iBlkCount = 0;
			int iLastZeroA = 0;
			int[] iBlock = new int[128];

			char cChr;
			
			Integer IVal;
			
			boolean bCompletePartialLine = false;
			boolean bLineBreakOut;
			boolean bSaveLen = false;
			boolean bContinued;
			boolean bOver;
			boolean bHitTrailing;
			boolean bBytesAvailable;
			boolean bFoundPhrase = false;
			boolean bCheckBlock;
			boolean bFirst = true;
			boolean bSplit = false;
			boolean bDoBreak = false;
			boolean bBlockSplit = false;
			boolean bStart;
			boolean bFinishEnd = false;
			boolean bFirst2;
			
			String outLineS;
			String inLineS;
			String lineS = "";
			String outS;
			String sT = "";
			String sT2 = "";
			String sPrevEnd = "";
			StringBuffer sB = null;
			StringBuffer endSb = null;
			
			
			ArrayList locAr = new ArrayList<String>(384);
			
            SingletonClass sc = SingletonClass.getInstance();


			// Note:
			//
			// If we use: exec(new String[] {})
			// we can detect when the I/O is finished
			// using exitValue(), but we don't get any
			// command lines from the system.
			//
			// if we use exec(), exitValue() doesn't
			// work but we get the command lines from the system
			// which show useful information

			//System.out.println("\n\n(IOBgThread)commandS: '"+commandS+"'");
			//System.out.println("\nIOBgThread run()");
/*			
			if ( commandS == null )
				System.out.println("commandS null");
			else
				System.out.println("commandS: '"+commandS+"'");
/**/

			try
			{
				Runtime rt = Runtime.getRuntime();
				
				if ( iOS == LINUX_MAC )
				{
					proc = rt.exec(new String[] {"/bin/bash", "-c", commandS});
				}
				else
				{
					proc = rt.exec("cmd.exe");
					
					writeBuf = commandS.getBytes();
					
					// Command..				
					os = proc.getOutputStream();
					os.write(writeBuf);
					os.flush();
				}
					
				error_is = proc.getErrorStream();
				out_is = proc.getInputStream();
				
				error_bis = new BufferedInputStream(error_is);
				out_bis = new BufferedInputStream(out_is);	
				
				if ( iOS == WINDOWS )
				{
					StringBuffer tSb = new StringBuffer();

					// Get current directory prompt..
					StringBuffer currDirSb = new StringBuffer();
					String currDirS = System.getProperty("user.dir");    // Like:  'C:\Dev\ADB_Util'
					//System.out.println("currDirS: '"+currDirS+"'");

					iLoc = currDirS.lastIndexOf('\\');
					if ( iLoc != -1 )
					{
					    // Like:  'ADB_Util>'
					    if ( (iLoc + 1) < currDirS.length() )
					    {
                            currDirSb.append(currDirS.substring(iLoc + 1));
                            currDirSb.append(">");
                        }
					}
					
					//System.out.println("currDirSb: '"+currDirSb.toString()+"'");
					
					// Set end to prompt..
					outputEndS = currDirSb.toString();
					
/*
					if ( actionCommandS == null )
						System.out.println("actionCommandS null");
					else
						System.out.println("actionCommandS: '"+actionCommandS+"'");
/**/

				}
				
				//System.out.println("\noutputEndS: '"+outputEndS+"'");

				iTotalBytes = 0;
				int iWordLength = 0;
				int iWordStart = 0;
				int iSIdx;
				int iBlockIdx;
				int iSplitBlockCount;
				int iChrLoc = 0;
				int iBreakLength = DISPLAY_WIDTH / 2;
				boolean bInWord;
				
				long lCTM1;
				long lCTM2;
				long lDif = 0;

				sB = new StringBuffer();
				endSb = new StringBuffer();
				
				while ( ! isInterrupted() )
				{
					//System.out.println("--TOP--");
					if ( bBreakOut )
						break;
					
					if ( bIOBgThreadBreak )
					    break;
					
					if ( out_bis.available() > 0 )	// Check Output Stream..
					{
						lCTM1 = System.currentTimeMillis();
						iBytesRead = out_bis.read(tempBuf, 0, iTmpLength);
						//System.out.println("(Output Stream)iBytesRead: "+iBytesRead);
						if ( iBytesRead == -1 )
						{
							// Never gets this..
							break;
						}

						baos.write(tempBuf, 0, iBytesRead);

						lineSb.insert(0, baos.toString());
						lineSb.setLength(iBytesRead);
						
						baos.reset();
						
						iTotalBytes += iBytesRead;
						lCTM2 = System.currentTimeMillis();
						lDif = lCTM2 - lCTM1;
						//System.out.println("Diff: "+lDif);
					}
					else if ( error_bis.available() > 0 )	// Check Error Stream..
					{
						iBytesRead = error_bis.read(tempBuf, 0, iTmpLength);
						//System.out.println("(Error Stream)iBytesRead: "+iBytesRead);
						if ( iBytesRead == -1 )
						{
							// Never gets this..
							break;
						}
						
						baos.write(tempBuf, 0, iBytesRead);

						lineSb.insert(0, baos.toString());
						lineSb.setLength(iBytesRead);

						baos.reset();						
						
						iTotalBytes += iBytesRead;
					}

/*					
					if ( (lineSb != null) && (iBytesRead > 0) )
					{
						System.out.println();
						char cTChr;

						//if ( lineSb.length() > 500 )
						//{
							for ( int g = 0; g < lineSb.length(); g++ )
							//for ( int g = 0; g < 500; g++ )
							{
								cTChr = (char)lineSb.charAt(g);
								if ( (cTChr < 0x20) || (cTChr > 0x7e) )
									System.out.print("["+Integer.toHexString((int)cTChr)+"]");
								else
									System.out.print(cTChr);
							}
						//}
						System.out.println("\n");
						System.out.println("\n");
					}
/**/

/*
                    if ( lineSb == null )
                        System.out.println("lineSb null");
                    else
                        System.out.println("lineSb.length(): "+lineSb.length());
/**/                            
 
                    // Without this, console output
                    // can get really laggy and unresponsive..
                    if ( lineSb.length() < 4096 )
                        Thread.sleep(10);
                    else
                    {
                        if ( lDif > 0 )
                            Thread.sleep(40);
                        else
                            Thread.sleep(20);
                    }

					if ( (lineSb != null) && (iBytesRead > 0) )
					{
						// Start of new block..
						//System.out.println("=== NEW BLOCK ===");

                        if ( lineSb.length() > 0 )
                        {
                        
                            bInWord = false;
                            iWordStart = 0;
                            
                            //System.out.println("bBlockSplit: "+bBlockSplit);
                            if ( bBlockSplit )
                            {
                                // Continue processing from previous block..
                            }
                            else
                            {
                                // New block..
                                iWordLength = 0;
                            }
    
                            iIdx = 0;
                            bDoBreak = false;
                            bSplit = false;
                            iChunkLen = lineSb.length();
                            
                            for ( ; ; iIdx++ ) 
                            {
                                //System.out.println("--TOP--");
                                if ( bDoBreak )
                                {
                                    //System.out.println("--Breaking--");
                                    break;
                                }
                                
                                if ( iIdx >= iChunkLen )
                                {
                                    // Hit end of block..
                                    cChr = lineSb.charAt(lineSb.length() - 1);
                                    if ( (cChr == (char)0x0a) || (cChr == (char)0x0d) )
                                        ;
                                    else
                                    {
                                        bBlockSplit = true;
                                    }
                                    
                                    bDoBreak = true;
                                }
                                else
                                {
                                    cChr = lineSb.charAt(iIdx);
                                    if ( Character.isWhitespace(cChr) )
                                    {
                                        // Whitespace..
                                        iWordLength = 0;	// Reset..
                                        bInWord = false;	// Reset..
                                    }
                                    else
                                    {
                                        // Character..
                                        if ( bInWord == false )
                                        {
                                            bInWord = true;
                                            iWordStart = iIdx;
                                        }
                                            
                                        iWordLength++;
                                        if ( iWordLength >= DISPLAY_BREAK_WIDTH )
                                        {
                                            bSplit = true;
                                        }
                                    }
                                }
                                
                                if ( bSplit )
                                {
                                    // Split..
                                    //System.out.println("\n== SPLIT ==");
                                    bSplit = false;		// Reset..
                                    iSIdx = iWordStart;
                                    
                                    iSplitBlockCount = iWordLength;
                                    iWordLength = 0;	// Reset..
                                    
                                    //System.out.println("iSplitBlockCount: "+iSplitBlockCount);
                                    iChrLoc = 0;
                                    
                                    for ( ; ; iSIdx++, iSplitBlockCount++ )
                                    {
                                        if ( iSIdx >= iChunkLen )
                                        {
                                            // Hit end..
                                            cChr = lineSb.charAt(lineSb.length() - 1);
                                            if ( (cChr == (char)0x0a) || (cChr == (char)0x0d) )
                                                ;
                                            else
                                            {
                                                iWordLength = iSplitBlockCount;
                                            }
    
                                            bDoBreak = true;
                                            break;
                                        }
                                        
                                        cChr = lineSb.charAt(iSIdx);
                                        if ( Character.isWhitespace(cChr) )
                                        {
                                            // Done..
                                            break;
                                        }
                                        
                                        if ( ! Character.isLetterOrDigit(cChr) )
                                        {
                                            // Special character..
                                            iChrLoc = iSIdx;
                                            //System.out.println("(Special)iChrLoc: "+iChrLoc);
                                        }
                                        
                                        if ( iSplitBlockCount > iBreakLength )
                                        {
                                            if ( iChrLoc > (iSIdx - (iBreakLength / 2) ) )
                                            {
                                                lineSb.insert((iChrLoc + 1), ' ');
                                            }
                                            else
                                            {
                                                // No special characters found..
                                                lineSb.insert((iSIdx + 1), ' ');
                                            }
                                            
                                            iChunkLen++;	// Adjust for added space..
                                            iSIdx += 1;		// Adjust past insert, plus loop increment..
                                            iChrLoc = 0;	// Reset..
                                            iSplitBlockCount = 0;
                                            
                                        }
                                    }	// End for..
                                    
                                    //System.out.println("Dropped out");
                                }
                            }	// End for..
                        }
					}
/**/					
                    //System.out.println("\nPast split block");
                    
					// Note:
					//
					// Sometimes it can catch the end prompt early,
					// so we need an end test..
					//System.out.println("iBytesRead: "+iBytesRead);
					if ( iBytesRead > 0 )
					{
						if ( ! bLogcatOn )
						{
							if ( iOS == WINDOWS )
							{
								if ( lineSb.charAt(lineSb.length() - 1) == '>' )
								{
									lineS = lineSb.substring(0, lineSb.length());

                                    if ( lineS.endsWith(outputEndS) )
                                    {
                                        //System.out.println("End matched, breaking out..");
                                        bBreakOut = true;	// Signal to break out..
                                    }
								}
							}
						}

						outLineS = "";	// Final line to be inserted..
						bContinued = false;
						iType = NORMAL;
						iLineLen = lineSb.length();

						try
						{
							doc = textPane.getStyledDocument();
                            if ( iBytesRead > 0 ) 
                            {
                                outS = lineSb.substring(0, lineSb.length());
                                
                                iLen = doc.getLength();
                                doc.insertString(iLen, outS, normalStyle);
                                if ( iLen > 0 )
                                {
                                    textPane.setCaretPosition(doc.getLength() - 1);
                                    textPane.repaint();
                                }
                            }
						}
						catch (IllegalArgumentException iae)
						{
							iae.printStackTrace();
						}
						catch (BadLocationException ble)
						{
							ble.printStackTrace();
						}
					}
					else
					{
						// No output..
						if ( iOS == LINUX_MAC )
						{
							// If still getting data
							// gets Exception:
							// 'Exception: java.lang.IllegalThreadStateException: process hasn't exited'
							// When I/O is finished, does exitValue()..
							try
							{
								iExitVal = proc.exitValue();
								//System.out.println("iExitVal: "+iExitVal);
								break;
							}
							catch (IllegalThreadStateException itse)
							{
								//System.out.println(itse.toString());
							}
						}
					}
					
					iBytesRead = 0;
					
				}	// End while..
				
				bIOBgThreadBreak = false;    // Reset..
				
				//System.out.println("\nIOBgThread dropped out");
			}
			catch (Exception e)
			{
				System.out.println("Exception: "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if ( error_bis != null )
						error_bis.close();
					
					if ( out_bis != null )
						out_bis.close();
					
					if ( error_is != null )
						error_is.close();
					
					if ( out_is != null )
						out_is.close();
 				}
				catch (IOException ioe)
				{
				}
			}

			//System.out.println("Calling destroy()");
			proc.destroy();

			while ( true )
			{
				try
				{
					iExitVal = proc.waitFor();
					//System.out.println("iExitVal: "+iExitVal);
					break;
				}
				catch (InterruptedException ie)
				{
					System.out.println(ie.toString());
				}
			}

			bIOBgThreadFinished = true;

			// Reset..
			bBreakOut = false;
			bFinished = true;

			//System.out.println("\nExiting IOBgThread run()");
		}
	}	//}}}
	
	//{{{	GetDevicesBgThread
	class GetDevicesBgThread extends Thread
	{
		public void run()
		{
			//System.out.println("\nGetDevicesBgThread run()");
			int iLoc;
			int iLoc2;
			int iLoc3;
			int iStart;
			int iEnd;
			int iIndex = 0;
			int iLongest = 0;
			String sDevice = "";
			
			DevicesAr = new ArrayList<String>();
	
			//System.out.println("sAndroidSdkPath: '"+sAndroidSdkPath+"'");
			
			StringBuffer sb = new StringBuffer();
			
			if ( iOS == LINUX_MAC )
			{
				sb.append("export PATH=${PATH}:");
				sb.append(sAndroidSdkPath);
				sb.append("/platform-tools");
				
				sb.append(";adb kill-server");
				sb.append(";adb start-server");
				sb.append(";adb devices");
			}
			else
			{
				sb.append("SET PATH=");
				sb.append(sAndroidSdkPath);
				sb.append("/platform-tools");
				sb.append(";%PATH%");
				
				sb.append("&&adb kill-server");
				sb.append("&&adb start-server");
				sb.append("&&adb devices");
				sb.append("\n");
			}
	

            //System.out.println("sb: '"+sb.toString()+"'");
            bCommandFinished = false;
            sInternalCommand = sb.toString();
            commandBgThread = new CommandBgThread();
            commandBgThread.start();

			// Wait for Thread to finish..
			while ( true )
			{
				try
				{
					Thread.sleep(250);
				}
				catch (InterruptedException ie)
				{
				}

				if ( bCommandFinished )
					break;
			}

/*			
            System.out.println();
            char cTChr;
            
            for ( int g = 0; g < commandResultS.length(); g++ )
            {
                cTChr = (char)commandResultS.charAt(g);
                if ( (cTChr < 0x20) || (cTChr > 0x7e) )
                    System.out.print("["+Integer.toHexString((int)cTChr)+"]");
                else
                    System.out.print(cTChr);
            }
            System.out.println();
/**/

/*
			if ( commandResultS == null )
				System.out.println("(devices)commandResultS null");
			else
				System.out.println("(devices)commandResultS: '"+commandResultS+"'");
/**/
				
			int iG;
			if ( (commandResultS != null) && (commandResultS.length() > 0) )
			{
				iLoc = commandResultS.indexOf("attached");
				if ( iLoc != -1 )
				{
				    //System.out.println("Found attached");
					iLoc2 = iLoc;
					while ( true )
					{
						iLoc2 = commandResultS.indexOf("device", iLoc2);
						if ( iLoc2 != -1 )
						{
							for ( iG = (iLoc2 - 1); Character.isWhitespace(commandResultS.charAt(iG)); iG--);
							iEnd = iG + 1;
							
							for ( ; ! Character.isWhitespace(commandResultS.charAt(iG)); iG-- );
							iStart = iG + 1;
							
							sDevice = commandResultS.substring(iStart, iEnd);
							sDevice = sDevice.trim();
							
							//System.out.println("(ADD)sDevice: '"+sDevice+"'");
							// Longest first..
							if ( sDevice.length() > iLongest )
							{
								DevicesAr.add(0, (String)sDevice);
								iLongest = sDevice.length();
							}
							else
							{
								DevicesAr.add(iIndex, (String)sDevice);
							}
							
							iIndex++;
						}
						else
							break;
						
						iLoc2++;
					}
				}
			}
/*
			for ( int iJ = 0; iJ < DevicesAr.size(); iJ++ )
				System.out.println("["+iJ+"]: '"+(String)DevicesAr.get(iJ)+"'");
/**/

			bDevicesFinished = true;
			//completeLatch.countDown();
			
		}
	}	//}}}

	//{{{   UpdateBundlePath()
    public void UpdateBundlePath()
    {
        //System.out.println("\nUpdateBundlePath()");
        
        // Check if we have it..
        SingletonClass sc = SingletonClass.getInstance();
/*        
        if ( sc.sBundlePath == null )
            System.out.println("sc.sBundlePath null");
        else
            System.out.println("sc.sBundlePath: '"+sc.sBundlePath+"'");
/**/        
        
        if ( (sc.sBundlePath != null) && (sc.sBundlePath.length() > 0) )
            ;
        else
            return;
        
        // Update recent.tmp..
        boolean bWrite = false;
        byte[] buf = null;
        StringBuffer sB;
        StringTokenizer st;
        String sOut = "";
        int iCount = 0;
        int iLoc = 0;
        int iLoc2 = 0;
        int iLoc3 = 0;
        
        String sTok;
        String sTitle;
        String sT = "";
        String[] sAr;
        boolean bMatch = false;
        
        buf = readFile(1000, "recent.tmp");
        if ( (buf != null) && (buf.length > 0) )
            sOut = new String(buf);
        
        if ( (sOut != null) && (sOut.length() > 0) )
        {
            //System.out.println("(recent.tmp)sOut: '"+sOut+"'");
            
            sAr = sOut.split("~");
            //System.out.println("sAr.length: "+sAr.length);
            for ( int iG = 0; iG < sAr.length; iG++ )
            {
                //System.out.println("--TOP-- iG: "+iG);
                sTok = sAr[iG];
                //System.out.println("sTok: '"+sTok+"'");
                
                if ( (iG % 2) == 0 )    // Even..
                {
                    //System.out.println("Inside");
                    // Project Home..
                    //System.out.println("sProjectHome: '"+sProjectHome+"'");
                    if ( sTok.equals(sProjectHome) )
                    {
                        //System.out.println("--MATCH--");
                        bMatch = true;
                        break;
                    }
                }
            }
            
            if ( bMatch )
            {
                // Matched, try to fill-in app bundle path..
                // C:/Android/Dev/HurricaneTrackerG~~C:/Android/Dev/G_GameNew~~
                
                sB = new StringBuffer(sOut);
                iLoc = sB.indexOf(sProjectHome);
                if ( iLoc != -1 )
                {
                    iLoc2 = sB.indexOf("~", iLoc);
                    if ( iLoc2 != -1 )
                    {
                        iLoc3 = sB.indexOf("~", iLoc2 + 1);
                        if ( iLoc3 != -1 )
                        {
                            // Replace what's there..
                            sB = sB.replace(iLoc2 + 1, iLoc3, sc.sBundlePath);
                            bWrite = true;
                        }
                    }
                }
            }
            else
            {
                // Didn't match, create new entry..
                sB = new StringBuffer(sOut);
                sB.append(sProjectHome);
                sB.append("~");
                sB.append(sc.sBundlePath);
                sB.append("~");
                bWrite = true;
            }
            
            if ( bWrite )
            {
                //System.out.println("(new recent.tmp): '"+sB.toString()+"'");
                writeFile(sB.toString().getBytes(), "recent.tmp");
            }
        }
    }   //}}}
    
	//{{{	processPath()
	/**
	 * Remove double quotes
	 * Flip '\' -> '/'
	 */
	//String ProcessPath(String sIn)
	String processPath(String sIn)
	{
		//System.out.println("\nProcessPath()");
		StringBuffer sb = null;

		if ((sIn != null) && (!sIn.equals("")))
			sb = new StringBuffer(sIn);
		else
			return sIn;

		for ( int g = 0; g < sb.length(); )
		{
			if (sb.charAt(g) == '\\')
				sb.setCharAt(g, '/');
			else if (sb.charAt(g) == (char)'"')
			{
				sb.deleteCharAt(g);
				continue;
			}

			g++;
		}

		//System.out.println("(Returning)sb: "+sb.toString());		
		return sb.toString();
	} //}}}
    
	//{{{   CommandBgThread    readLine()
	class CommandBgThread extends Thread
	{
		public void run()
		{
			//System.out.println("\nCommandBgThread run()");
			//System.out.println("sInternalCommand: '"+sInternalCommand+"'");
			
			// ==================
			// THREAD MUTEX
			// ==================
			try
			{
				commandControl.acquire();			
			}
			catch (InterruptedException ie)
			{
			}

			ProcessBuilder processBuilder;
			Process process = null;
			InputStream inputStream;
			InputStream errorStream;
			BufferedReader inputBufferedReader = null;
			BufferedReader errorBufferedReader = null;
			String sLine = "";
			StringBuffer sB;
			StringBuffer sBOut;
			int iExitCode = 0;
			int iExitVal = 0;
			long lTime = 0;
			long lTime2 = 0;

			byte[] bReply = {(byte) 0x79, (byte) 0x0d, (byte) 0x0a};
			String sReply = new String(bReply);
			byte[] b0d0a = {(byte) 0x0d, (byte) 0x0a};
			String sEnd = new String(b0d0a);

			try
			{
				processBuilder = new ProcessBuilder();

				if ( iOS == LINUX_MAC )
					processBuilder.command("/bin/bash", "-c", sInternalCommand);
				else
					processBuilder.command("cmd.exe", "/c", sInternalCommand);

				process = processBuilder.start();
			}
			catch (IOException ioe)
			{}

			inputStream = process.getInputStream();
			errorStream = process.getErrorStream();
			sBOut = new StringBuffer();

			try
			{
				inputBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				errorBufferedReader = new BufferedReader(new InputStreamReader(errorStream));

				//System.out.println("Above top");
				while ( true )
				{
					if ( inputBufferedReader.ready() )
					{
					    lTime = System.currentTimeMillis();
						sLine = inputBufferedReader.readLine();
						if ( sLine != null )
						{
							//System.out.println("(input): '"+sLine+"'");

							sB = new StringBuffer(sLine);
							sB.append(sEnd);

							sBOut.append(sB.toString());

/*							
                            System.out.println("\n\n");
                            char cTChr;

                            for ( int g = 0; g<sB.length(); g++ )
                            {
                                cTChr = (char)sB.charAt(g);
                                if ( (cTChr<0x21) || (cTChr > 0x7e) )
                                    System.out.print("["+Integer.toHexString((int)cTChr)+"]");
                                else
                                    System.out.print(cTChr);
                            }
                            System.out.println("\n\n length(): "+sB.length());
/**/

						}
					}
					else if (errorBufferedReader.ready())
					{
					    lTime = System.currentTimeMillis();
						sLine = errorBufferedReader.readLine();
						if ( sLine != null )
						{
							//System.out.println("(error): '"+sLine+"'");
							sB = new StringBuffer(sLine);
							sB.append(sEnd);
							
							sBOut.append(sB.toString());
						}
					}
					else
					{
						// Didn't get anything..
						lTime2 = System.currentTimeMillis();
						if ( (lTime > 0) && (lTime2 - lTime > 3000) )
						{
						    //System.out.println("Too long, breaking");
						    break;
						}
						
						try
						{
							iExitVal = process.exitValue();
							//System.out.println("iExitVal: "+iExitVal);
							break;
						}
						catch (IllegalThreadStateException itse)
						{}
					}
				} // End while..
			}
			catch (IOException ioe)
			{
				System.out.println("CommandBgThread Exception:");
				ioe.printStackTrace();
			}
			finally
			{
				try
				{
					if (inputBufferedReader != null)
						inputBufferedReader.close();

					if (inputStream != null)
						inputStream.close();

					if (errorBufferedReader != null)
						errorBufferedReader.close();

					if (errorStream != null)
						errorStream.close();
				}
				catch (IOException ioe)
				{}
			}

			if ( process != null )
			{
				process.destroy();
				process = null;
			}

			commandResultS = sBOut.toString();
			
			//System.out.println("commandResultS: '"+commandResultS+"'");
			
/*			
			//String sT4 = commandResultS.substring(5000, commandResultS.length() - 1000);
			//String sT4 = commandResultS.substring(5000);
			String sT4 = commandResultS.substring(0, 6500);
			
            System.out.println("\n\n");
            char cTChr;

            for ( int g = 0; g<sT4.length(); g++ )
            {
                cTChr = (char)sT4.charAt(g);
                if ( (cTChr<0x21) || (cTChr > 0x7e) )
                    System.out.print("["+Integer.toHexString((int)cTChr)+"]");
                else
                    System.out.print(cTChr);
            }
            System.out.println("\n\n");
/**/			

			bCommandFinished = true;
			
			//System.out.println("Exiting CommandBgThread run()");

			if (commandRequestLatch != null)
				commandRequestLatch.countDown();
			
			// ==================
			// THREAD MUTEX
			// ==================
			commandControl.release();

		}
	} //}}}

	//{{{	selectDeviceDialog()
	public void selectDeviceDialog()
	{
	    //System.out.println("\n-- selectDeviceDialog() --");
		selectDeviceFrame = new JFrame();
		selectDeviceFrame.setLayout(new BorderLayout());		
		selectDeviceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		selectDeviceFrame.setTitle("Select Device");
		selectDeviceFrame.setAlwaysOnTop(true);
		
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel deviceLbl = new JLabel("Device: ");

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(4, 25, 4, 4);	// bottom, left, right, top
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		panel.add(deviceLbl, gbc);

/*
		if ( DevicesAr == null )
			System.out.println("DevicesAr null");
		else
			System.out.println("DevicesAr.size(): "+DevicesAr.size());
/**/		
				
		// Construct choices..
		String[] tSa;
		boolean bOk = false;
		boolean bConnect = false;
		int iSz = 0;
		
        if ( (DevicesAr != null) && (DevicesAr.size() > 0) )
        {
            iSz = DevicesAr.size();
            bOk = true;
        }
		
		if ( bOk )
		{
			tSa = new String[iSz];
			for ( int g = 0; g < tSa.length; g++ )
			{
				if ( bConnect )
				{
				    if ( g < ConnectDevicesAr.size() )
				    {
				        if ( g < tSa.length )
				            tSa[g] = (String)ConnectDevicesAr.get(g);
				    }
				}
				else
				{
				    if ( g < DevicesAr.size() )
				    {
				        if ( g < tSa.length )
				            tSa[g] = (String)DevicesAr.get(g);
				    }
				}
			}

			SpinnerListModel deviceModel = new SpinnerListModel(tSa);		
			deviceSpinner = new JSpinner(deviceModel);
			
			deviceSpinner.setEditor(new JSpinner.DefaultEditor(deviceSpinner));	// Set as non-editable..
			deviceSpinner.setAlignmentX(Component.LEFT_ALIGNMENT);
			
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(4, 4, 4, 4);	// bottom, left, right, top
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.gridwidth = 3;
			panel.add(deviceSpinner, gbc);
		}

		panel.setBorder(new LineBorder(Color.GRAY));
		
		JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("select_device_submit");
		submitButton.addActionListener(actListener);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("select_device_cancel");
		cancelButton.addActionListener(actListener);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(submitButton);
		buttonPanel.add(cancelButton);

		selectDeviceFrame.getContentPane().add(panel, BorderLayout.CENTER);
		selectDeviceFrame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		
		selectDeviceFrame.pack();
		selectDeviceFrame.setVisible(true);
		selectDeviceFrame.setResizable(false);
		
	}	//}}}

    //{{{   RequestDialog()	
    public void RequestDialog()
    {
		//System.out.println("\nRequestDialog()");
		SingletonClass sc = SingletonClass.getInstance();
		StringBuffer sB = null;
		String sT = "";
		
		RefreshProperties();
		
		requestFrame = new JFrame();
		requestFrame.setLayout(new BorderLayout());
		requestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		requestFrame.setTitle(sDialogTitle);
		
		int iGridY = 0;
		int iLoc = 0;

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(4, 4, 4, 4); // External padding of the component

		if ( (sShowCommandSummary != null) && (sShowCommandSummary.equals("true")) )
		{
            textAreaPanel = new JPanel();		
            JTextArea summaryTextArea = new JTextArea();
            summaryTextArea.setRows(2);
            summaryTextArea.setEditable(false);
            summaryTextArea.append(sCommandSummary);
            
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            textAreaPanel.add(summaryTextArea, gbc);
    
            iGridY++;
		
            panel.setBorder(new LineBorder(Color.GRAY));
        }

		if ( bShowInstallMultiApksText )
		{
            JLabel dumpLbl = new JLabel("Taking command options from config.properties");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(dumpLbl, gbc);
		}

		//System.out.println("bShowDumpSpinner: "+bShowDumpSpinner);
        if ( bShowDumpSpinner )
        {
            JLabel dumpLbl = new JLabel("Dump: ");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(dumpLbl, gbc);
    
            String[] modeSa = {"manifest", "resources", "config"};        
            
            SpinnerListModel dumpModel = new SpinnerListModel(modeSa);
            dumpSpinner = new JSpinner(dumpModel);
    
            // Default..
            dumpSpinner.setValue((String)modeSa[0]);
            
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 3;
            panel.add(dumpSpinner, gbc);
            
            iGridY++;
        }

        //System.out.println("bShowAabPath: "+bShowAabPath);
		if ( bShowAabPath )
		{
		    //StringBuffer tSb;
		    //System.out.println("\nAAB PATH");
            JLabel aabPathLbl = new JLabel("Bundle (.aab) Path: ");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(aabPathLbl, gbc);
    
            aabPathField = new JTextField(30);		
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 2;
    
/*            
            if ( sProjectHome == null )
                System.out.println("sProjectHome null");
            else
                System.out.println("sProjectHome: '"+sProjectHome+"'");
/**/

/*
            if ( sc.sBundlePath == null )
                System.out.println("sc.sBundlePath null");
            else
                System.out.println("sc.sBundlePath: '"+sc.sBundlePath+"'");
/**/				    

            sB = new StringBuffer();
            if ( (sc.sBundlePath != null) && (sc.sBundlePath.length() > 0) )
            {
                // Have app bundle path..
                if ( (releaseCheckBoxMenuItem != null) && (releaseCheckBoxMenuItem.getState() == true) )
                {
                    if ( sc.sBundlePath.contains("debug") )
                    {
                        // Replace with 'release'..
                        sT = sc.sBundlePath;
                        sT = sT.replace("debug", "release");
                        sc.sBundlePath = sT;
                    }
                }
                else
                {
                    // debug selected, check for 'release'..
                    if ( sc.sBundlePath.contains("release") )
                    {
                        // Replace with 'debug'..
                        sT = sc.sBundlePath;
                        sT = sT.replace("release", "debug");
                        sc.sBundlePath = sT;
                    }
                }
                
                sB.append(sc.sBundlePath);
            }
            else
            {
                //sB = new StringBuffer();
                sB.append(sProjectHome);
                sB.append("/");
            }
/**/ 

            if ( aabPathField != null )
                aabPathField.setText(sB.toString());
            
            panel.add(aabPathField, gbc);
            
            JButton chooseButton = new JButton("...");
            chooseButton.setActionCommand("aab_path_chooser");
            chooseButton.addActionListener(actListener);
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);	// bottom, left, right, top
            gbc.gridx = 3;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(chooseButton, gbc);
            
            iGridY++;
        }

        //System.out.println("bShowApksPath: "+bShowApksPath);
        if ( bShowApksPath )
        {
            JLabel apksPathLbl = new JLabel("Apks Path: ");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(apksPathLbl, gbc);
    
            apksPathField = new JTextField(30);		
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 2;
    
/*            
            if ( sProjectHome == null )
                System.out.println("sProjectHome null");
            else
                System.out.println("sProjectHome: '"+sProjectHome+"'");
/**/
    
            // Try to load Project Home..		
            if ( (sProjectHome != null) && (! sProjectHome.equals("")) )
            {
                StringBuffer ppSb = new StringBuffer();
                ppSb.append(sProjectHome);
                ppSb.append("/");
                
                apksPathField.setText(ppSb.toString());
            }
    
            panel.add(apksPathField, gbc);
            
            JButton chooseButton = new JButton("...");
            chooseButton.setActionCommand("apks_path_chooser");
            chooseButton.addActionListener(actListener);
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);	// bottom, left, right, top
            gbc.gridx = 3;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(chooseButton, gbc);
            
            iGridY++;
        }
        
        //System.out.println("bShowOutputPathField: "+bShowOutputPathField);
        if ( bShowOutputPathField )
        {
            // get-device-spec
            JLabel outputPathFieldLbl = new JLabel(sOutputPathFieldLbl);
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(outputPathFieldLbl, gbc);

            outputPathField = new JTextField(30);		
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 2;
            panel.add(outputPathField, gbc);
            
            // Try to load Project Home..		
            if ( (sProjectHome != null) && (! sProjectHome.equals("")) )
            {
                StringBuffer ppSb = new StringBuffer();
                ppSb.append(sProjectHome);
                ppSb.append("/");

                // Try to load default filename..                
                if ( sOutputPathFile != null )
                {
                    sOutputPathFile = sOutputPathFile.trim();
                    ppSb.append(sOutputPathFile);
                }
                
                outputPathField.setText(ppSb.toString());
            }
            
            iGridY++;
        }

        //System.out.println("bShowDeviceSpecPath: "+bShowDeviceSpecPath);
		if ( bShowDeviceSpecPath )
		{
		    // extract-apks
            JLabel deviceSpecPathLbl = new JLabel("Device Spec Path: ");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(deviceSpecPathLbl, gbc);
    
            deviceSpecPathField = new JTextField(30);		
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 2;
    
            // Try to load Project Home..		
            if ( (sProjectHome != null) && (! sProjectHome.equals("")) )
            {
                StringBuffer ppSb = new StringBuffer();
                ppSb.append(sProjectHome);
                ppSb.append("/");
                
                deviceSpecPathField.setText(ppSb.toString());
            }
    
            panel.add(deviceSpecPathField, gbc);
            
            JButton chooseButton = new JButton("...");
            chooseButton.setActionCommand("device_spec_path_chooser");
            chooseButton.addActionListener(actListener);
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(4, 4, 4, 4);	// bottom, left, right, top
            gbc.gridx = 3;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(chooseButton, gbc);
            
            iGridY++;
        }

        //System.out.println("bShowHumanReadableSizes: "+bShowHumanReadableSizes);
        if ( bShowHumanReadableSizes )
        {
            // get-size
            humanReadableSizesCheckBox = new JCheckBox("    human-readable-sizes");
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(4, 4, 4, 4);    // bottom, left, right, top
            panel.add(humanReadableSizesCheckBox, gbc);
            
            iGridY++;
        }
        
        //System.out.println("bShowModeSpinner: "+bShowModeSpinner);
        if ( bShowModeSpinner )
        {
            JLabel modeLbl = new JLabel("Mode: ");
            gbc.gridx = 0;
            gbc.gridy = iGridY;
            gbc.gridwidth = 1;
            panel.add(modeLbl, gbc);
    
            String[] modeSa = {"default", "universal", "system", "persistent", "instant", "archive"};        
            
            SpinnerListModel modeModel = new SpinnerListModel(modeSa);
            modeSpinner = new JSpinner(modeModel);
    
            // Default..
            modeSpinner.setValue((String)modeSa[0]);
            
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 3;
            panel.add(modeSpinner, gbc);
            
            iGridY++;
        }

        //System.out.println("bShowConnectedDeviceCb: "+bShowConnectedDeviceCb);
        if ( bShowConnectedDeviceCb )
        {
            connectedDeviceCheckBox = new JCheckBox("    connected-device");
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(4, 4, 4, 4);    // bottom, left, right, top
            panel.add(connectedDeviceCheckBox, gbc);
            
            iGridY++;
        }

        //System.out.println("bShowOverwriteCb: "+bShowOverwriteCb);
        if ( bShowOverwriteCb )
        {
            overwriteCheckBox = new JCheckBox("    overwrite");
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = iGridY;
            gbc.gridwidth = 3;
            gbc.insets = new Insets(4, 4, 4, 4);    // bottom, left, right, top
            panel.add(overwriteCheckBox, gbc);
            
            iGridY++;
        }
        
		panel.setBorder(new LineBorder(Color.GRAY));
		
		JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("request_submit");
		submitButton.addActionListener(actListener);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("request_cancel");
		cancelButton.addActionListener(actListener);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(submitButton);
		
		buttonPanel.add(cancelButton);

		if ( (sShowCommandSummary != null) && (sShowCommandSummary.equals("true")) )
		    requestFrame.getContentPane().add(textAreaPanel, BorderLayout.NORTH);
		
		requestFrame.getContentPane().add(panel, BorderLayout.CENTER);
		requestFrame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		
		requestFrame.pack();
		requestFrame.setVisible(true);
		requestFrame.setResizable(false);
		
		//System.out.println("Exiting RequestDialog()");
        
    }   //}}}
	
	//{{{	ActionListener
	private ActionListener actListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			//System.out.println("\n== ActionListener ==");
			String sActionCommand = e.getActionCommand();
			String sT = "";
			String sProjectPath = "";    // Internal
			StringBuffer sb;
			StringBuffer sB = null;
			StringBuffer sBNm = null;
			StringTokenizer st;
			
			SingletonClass sc = SingletonClass.getInstance();
			int iLoc = 0;
			int iLoc2 = 0;
			int iCount = 0;
			int iTokIndex = 0;
			byte[] buf = null;
			boolean bMatch;
			//System.out.println("sActionCommand: '"+sActionCommand+"'");
			
			// Check if from Recent Projects..
/*			
			if ( sProjectHome == null )
			    System.out.println("sProjectHome null");
			else
			    System.out.println("sProjectHome: '"+sProjectHome+"'");
/**/

            if ( REQUEST_SUBMIT.equals(sActionCommand) )
            {
                //System.out.println("REQUEST_SUBMIT");
                
                RefreshProperties();
                sb = new StringBuffer();
                String sMode = "";
                String sJsonPath = "";
			    
                if ( iOS == LINUX_MAC )
                {
                    sb.append("export PATH=${PATH}:");
                    sb.append("\"");
                    sb.append(sJavaPath);
                    sb.append("\"");

                    sb.append(";java -jar ");
                    sb.append(sBundleToolJarPath);
                    sb.append(" ");
                    sb.append(sCommand);
                }
                else
                {
                    sb.append("SET PATH=");
                    sb.append("\"");
                    sb.append(sJavaPath);
                    sb.append("\"");
                    sb.append(";%PATH%");
                    
                    sb.append("&&java -jar ");
                    sb.append(sBundleToolJarPath);
                    sb.append(" ");
                    sb.append(sCommand);
                }
                
                if ( sCommand.equals("get-size") ) 
                    sb.append(" total");

                if ( bShowDumpSpinner )
                {
                    // dump
                    if ( dumpSpinner != null )
                    {
                        sDumpMode = (String)dumpSpinner.getValue();
                        sDumpMode = sDumpMode.trim();
                        sb.append(" ");
                        sb.append(sDumpMode);
                    }
                }

                if ( bShowAabPath )
                {
                    sb.append(" --bundle=");
                    if ( aabPathField != null )
                        sAabPath = aabPathField.getText();
                    
                    sb.append('"');
                    sb.append(sAabPath);
                    sb.append('"');
                }
                
                if ( bShowApksPath )
                {
                    sb.append(" --apks=");
                    if ( apksPathField != null )
                        sApksPath = apksPathField.getText();

                    sb.append('"');                    
                    sb.append(sApksPath);
                    sb.append('"');
                }
                
                if ( bShowDeviceSpecPath )
                {
                    // Note:
                    // extract-apks needs --device-spec=
                    // but get-device-spec needs --output
                    
                    // --output=<device-spec.json>
                    sb.append(" --device-spec=");
                    //sb.append(" --output=");
                    if ( deviceSpecPathField != null )
                        sJsonPath = deviceSpecPathField.getText();
                    
                    sb.append('"');
                    sb.append(sJsonPath);
                    sb.append('"');
                }
                
                if ( bShowOutputPathField )
                {
                    sb.append(" --output=");
                    if ( outputPathField != null )
                        sOutputPath = outputPathField.getText();
                    
                    sb.append('"');
                    sb.append(sOutputPath);
                    sb.append('"');
                }
                
                if ( bShowModeSpinner )
                {
                    if ( modeSpinner != null )
                    {
                        sMode = (String)modeSpinner.getValue();
                        sMode = sMode.trim();
                        if ( sMode.equals("default") )
                            ;
                        else
                        {
                            sb.append(" --mode=");
                            sb.append(sMode);
                        }
                    }
                }


                /**
                 * Fields
                 */
                 
                
                if ( (sAdbPath != null) && (! sAdbPath.equals("null")) && (sAdbPath.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("install-apks")) || (sCommand.equals("install-multi-apks"))
                    || (sCommand.equals("get-device-spec"))) )
                {
                    sB = new StringBuffer();
                    sT = sAdbPath;

                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }
                
                if ( (sDeviceSpec != null) && (! sDeviceSpec.equals("null")) && (sDeviceSpec.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("extract-apks")) || (sCommand.equals("get-size"))) )
                {
                    sB = new StringBuffer();
                    sT = sDeviceSpec;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }
                
                if ( (sAapt2Path != null) && (! sAapt2Path.equals("null")) && (sAapt2Path.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("install-multi-apks"))) )
                {
                    sB = new StringBuffer();
                    sT = sAapt2Path;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                if ( (sLineage != null) && (! sLineage.equals("null")) && (sLineage.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sB = new StringBuffer();
                    sT = sLineage;

                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                if ( (sOldestSigner != null) && (! sOldestSigner.equals("null")) && (sOldestSigner.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sB = new StringBuffer();
                    sT = sOldestSigner;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                // --modules=<path/to/module1.zip,path/to/module2.zip,...> in build-bundle
                if ( (sModuleFiles != null) && (! sModuleFiles.equals("null")) && (sModuleFiles.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("build-bundle")) || (sCommand.equals("extract-apks"))
                    || (sCommand.equals("install-apks")) || (sCommand.equals("get-size"))) )
                {
                    sB = new StringBuffer();
                    sT = sModuleFiles;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                // --module in dump                
                if ( (sModule != null) && (! sModule.equals("null")) && (sModule.length() > 0)
                    && (sCommand.equals("dump")) )
                {
                    sb.append(" ");
                    sb.append(sModule);
                }
                
                if ( (sConfig != null) && (! sConfig.equals("null")) && (sConfig.length() > 0)
                    && (sCommand.equals("build-bundle")) )
                {
                    sB = new StringBuffer();
                    sT = sConfig;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                // --output-dir                
                if ( (sOutputDir != null) && (! sOutputDir.equals("null")) && (sOutputDir.length() > 0)
                    && (sCommand.equals("extract-apks")) )
                {
                    sB = new StringBuffer();
                    sT = sOutputDir;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }
                
                if ( (sApksZip != null) && (! sApksZip.equals("null")) && (sApksZip.length() > 0)
                    && (sCommand.equals("install-multi-apks")) )
                {
                    sB = new StringBuffer();
                    sT = sApksZip;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                // For the only non-main, in install-multi-apks               
                if ( (sApks != null) && (! sApks.equals("null")) && (sApks.length() > 0)
                    && (sCommand.equals("install-multi-apks")) )
                {
                    sB = new StringBuffer();
                    sT = sApks;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }
                
                if ( (sMetadataFile != null) && (! sMetadataFile.equals("null")) && (sMetadataFile.length() > 0)
                    && (sCommand.equals("build-bundle")) )
                {
                    sB = new StringBuffer();
                    sT = sMetadataFile;
                    
                    if ( sProjectHome != null )                     
                        sT = sT.replace("[Home]", sProjectHome); 
                    
                    iLoc = sT.indexOf("=");
                    if ( iLoc != -1 )
                    {
                        // Add double quotes around path..
                        sB.append(sT.substring(0, iLoc + 1));   // Like: --aapt2=
                        sB.append('"');
                        sB.append(sT.substring(iLoc + 1));
                        sB.append('"');
                    }
                    
                    sb.append(" ");
                    sb.append(sB.toString());
                }

                
                if ( (sDeviceTier != null) && (! sDeviceTier.equals("null")) && (sDeviceTier.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("install-apks"))
                    || (sCommand.equals("get-device-spec"))) )
                {
                    sb.append(" ");
                    sb.append(sDeviceTier);
                }

                if ( (sDeviceId != null) && (! sDeviceId.equals("null")) && (sDeviceId.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("install-apks"))
                    || (sCommand.equals("install-multi-apks")) || (sCommand.equals("get-device-spec"))) )
                {
                    sb.append(" ");
                    sb.append(sDeviceId);
                }

                if ( (sMaxThreads != null) && (! sMaxThreads.equals("null")) && (sMaxThreads.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sMaxThreads);
                }

                // --min-v3-rotation-api-version
                if ( (sMinApiVersion != null) && (! sMinApiVersion.equals("null")) && (sMinApiVersion.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sMinApiVersion);
                }

                if ( (sStampSource != null) && (! sStampSource.equals("null")) && (sStampSource.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sStampSource);
                }

                // --modules=<base,module1,module2>
                if ( (sModuleNames != null) && (! sModuleNames.equals("null")) && (sModuleNames.length() > 0)
                    && ((sCommand.equals("build-apks")) || (sCommand.equals("extract-apks"))
                    || (sCommand.equals("install-apks")) || (sCommand.equals("get-size"))) )
                {
                    sb.append(" ");
                    sb.append(sModuleNames);
                }

                // --modules=<base,module1,module2>  A special one for extract-apks so it can handle "_ALL_"
                if ( (sModuleNamesExtract != null) && (! sModuleNamesExtract.equals("null")) && (sModuleNamesExtract.length() > 0)
                    && (sCommand.equals("extract-apks")) )
                {
                    sb.append(" ");
                    sb.append(sModuleNamesExtract);
                }
                
                if ( (sOutputFormat != null) && (! sOutputFormat.equals("null")) && (sOutputFormat.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sOutputFormat);
                }

                if ( (sOptimizeFor != null) && (! sOptimizeFor.equals("null")) && (sOptimizeFor.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sOptimizeFor);
                }

                if ( (sTimeoutMillis != null) && (! sTimeoutMillis.equals("null")) && (sTimeoutMillis.length() > 0)
                    && ((sCommand.equals("install-apks")) || (sCommand.equals("install-multi-apks"))) )
                {
                    sb.append(" ");
                    sb.append(sTimeoutMillis);
                }

                if ( (sDeviceGroups != null) && (! sDeviceGroups.equals("null")) && (sDeviceGroups.length() > 0)
                    && ((sCommand.equals("install-apks")) || (sCommand.equals("get-device-spec"))) )
                {
                    sb.append(" ");
                    sb.append(sDeviceGroups);
                }

                
                /**
                 * Flags
                 */
                 
                if ( bShowHumanReadableSizes )
                {
                    if ( (humanReadableSizesCheckBox != null) && (humanReadableSizesCheckBox.isSelected()) )
                        sb.append(" --human-readable-sizes");
                }
               
                if ( bShowConnectedDeviceCb )
                {
                    if ( (connectedDeviceCheckBox != null) && (connectedDeviceCheckBox.isSelected()) )
                        sb.append(" --connected-device");
                }

                if ( bShowOverwriteCb )
                {
                    if ( (overwriteCheckBox != null) && (overwriteCheckBox.isSelected()) )
                        sb.append(" --overwrite");
                }
                
                if ( (sVerboseFlag != null) && (! sVerboseFlag.equals("null")) && (sVerboseFlag.length() > 0)
                    && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sVerboseFlag);
                }

                if ( (sIncludeMetadataFlag != null) && (! sIncludeMetadataFlag.equals("null"))
                    && (sIncludeMetadataFlag.length() > 0) && (sCommand.equals("extract-apks")) )
                {
                    sb.append(" ");
                    sb.append(sIncludeMetadataFlag);
                }

                if ( (sInstantFlag != null) && (! sInstantFlag.equals("null")) && (sInstantFlag.length() > 0)
                    && ((sCommand.equals("extract-apks")) || (sCommand.equals("get-size"))) )
                {
                    sb.append(" ");
                    sb.append(sInstantFlag);
                }

                if ( (sCreateStampFlag != null) && (! sCreateStampFlag.equals("null"))
                    && (sCreateStampFlag.length() > 0) && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sCreateStampFlag);
                }

                if ( (sLocalTestingFlag != null) && (! sLocalTestingFlag.equals("null"))
                    && (sLocalTestingFlag.length() > 0) && (sCommand.equals("build-apks")) )
                {
                    sb.append(" ");
                    sb.append(sLocalTestingFlag);
                }
                
                if ( (sAdditionalLocalTestingFilesFlag != null) && (! sAdditionalLocalTestingFilesFlag.equals("null"))
                    && (sAdditionalLocalTestingFilesFlag.length() > 0) && (sCommand.equals("install-apks")) )
                {
                    sb.append(" ");
                    sb.append(sAdditionalLocalTestingFilesFlag);
                }

                if ( (sAllowDowngradeFlag != null) && (! sAllowDowngradeFlag.equals("null"))
                    && (sAllowDowngradeFlag.length() > 0) && (sCommand.equals("install-apks")) )
                {
                    sb.append(" ");
                    sb.append(sAllowDowngradeFlag);
                }

                if ( (sAllowTestOnlyFlag != null) && (! sAllowTestOnlyFlag.equals("null"))
                    && (sAllowTestOnlyFlag.length() > 0) && (sCommand.equals("install-apks")) )
                {
                    sb.append(" ");
                    sb.append(sAllowTestOnlyFlag);
                }

                if ( (sValuesFlag != null) && (! sValuesFlag.equals("null"))
                    && (sValuesFlag.length() > 0) && (sCommand.equals("dump")) )
                {
                    sb.append(" ");
                    sb.append(sValuesFlag);
                }

                if ( (sEnableRollbackFlag != null) && (! sEnableRollbackFlag.equals("null"))
                    && (sEnableRollbackFlag.length() > 0) && (sCommand.equals("install-multi-apks")) )
                {
                    sb.append(" ");
                    sb.append(sEnableRollbackFlag);
                }

                if ( (sStagedFlag != null) && (! sStagedFlag.equals("null"))
                    && (sStagedFlag.length() > 0) && (sCommand.equals("install-multi-apks")) )
                {
                    sb.append(" ");
                    sb.append(sStagedFlag);
                }

                if ( (sUpdateOnlyFlag != null) && (! sUpdateOnlyFlag.equals("null"))
                    && (sUpdateOnlyFlag.length() > 0) && (sCommand.equals("install-multi-apks")) )
                {
                    sb.append(" ");
                    sb.append(sUpdateOnlyFlag);
                }
                
                
                if ( sCommand.equals("build-apks") )
                {
                    if ( (sKeyStorePath != null) && (! sKeyStorePath.equals("null"))
                        && (sKeyStorePath.length() > 0) )
                    {
                        // Path to the keystore.
                        sb.append(" --ks=");
                        sb.append(sKeyStorePath);
                    }
                    
                    if ( (sKeyStorePassword != null) && (! sKeyStorePassword.equals("null"))
                        && (sKeyStorePassword.length() > 0) )
                    {
                        // Password of the keystore.
                        sb.append(" --ks-pass=pass:");
                        sb.append(sKeyStorePassword);
                    }

                    if ( (sKeyAlias != null) && (! sKeyAlias.equals("null")) && (sKeyAlias.length() > 0) )
                    {
                        // Alias of the key to use in the keystore.
                        sb.append(" --ks-key-alias=");
                        sb.append(sKeyAlias);
                    }

                    if ( (sKeyAliasPassword != null) && (! sKeyAliasPassword.equals("null"))
                        && (sKeyAliasPassword.length() > 0) )
                    {
                        // Password of the key in the keystore.
                        sb.append(" --key-pass=pass:");
                        sb.append(sKeyAliasPassword);
                    }
                    
                    /**
                     * Stamp
                     */
                     
                    if ( (sStampKeyStorePath != null) && (! sStampKeyStorePath.equals("null"))
                        && (sStampKeyStorePath.length() > 0) )
                    {
                        // Path to the Stamp keystore.
                        sb.append(" --stamp-ks=");
                        sb.append(sStampKeyStorePath);
                    }
                    
                    if ( (sStampKeyStorePassword != null) && (! sStampKeyStorePassword.equals("null"))
                        && (sStampKeyStorePassword.length() > 0) )
                    {
                        // Password of the Stamp keystore.
                        sb.append(" --stamp-ks-pass:");
                        sb.append(sStampKeyStorePassword);
                    }

                    if ( (sStampKeyAlias != null) && (! sStampKeyAlias.equals("null"))
                        && (sStampKeyAlias.length() > 0) )
                    {
                        // Alias of the key to use in the Stamp keystore.
                        sb.append(" --stamp-key-alias=");
                        sb.append(sStampKeyAlias);
                    }

                    if ( (sStampKeyAliasPassword != null) && (! sStampKeyAliasPassword.equals("null"))
                        && (sStampKeyAliasPassword.length() > 0) )
                    {
                        // Password of the key in the Stamp keystore.
                        sb.append(" --stamp-key-pass:");
                        sb.append(sStampKeyAliasPassword);
                    }
                }
                
                if ( iOS == WINDOWS )
                    sb.append("\n");
                
                //System.out.println("(Command)sb: '"+sb.toString()+"'");

                
                // Set up for IOBgThread output..
                commandS = sb.toString();

                bIOBgThreadFinished = false;                
                iOBgThread = new IOBgThread();
                iOBgThread.start();
                
                while ( true )
                {
                    try
                    {
                        Thread.sleep(100);                       
                    }
                    catch (InterruptedException ie)
                    {
                    }
                    
                    if ( bIOBgThreadFinished )
                        break;
                }
/**/

			    if ( requestFrame != null )
			    {
                    requestFrame.setVisible(false);
                    requestFrame.dispose();
                }
            }
            else if ( REQUEST_CANCEL.equals(sActionCommand) )
            {
                //System.out.println("REQUEST_CANCEL");
			    if ( requestFrame != null )
			    {
                    requestFrame.setVisible(false);
                    requestFrame.dispose();
                }
            }
			else if ( HOME.equals(sActionCommand) )
			{
				// Project Home..
				//System.out.println("HOME");
				
				File chosenFile;
				JFileChooser fChooser;
				
				if ( (sProjectPathLead != null) && (! sProjectPathLead.equals("")) )
					fChooser = new JFileChooser(sProjectPathLead);
				else
				{
					fChooser = new JFileChooser();
					fChooser.setCurrentDirectory(new java.io.File("."));
				}
					
				fChooser.setDialogTitle("Project Home");
				fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fChooser.setAcceptAllFileFilterUsed(false);
				
				if ( fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
				{
					sProjectHome = fChooser.getSelectedFile().toString();
/*					
					if ( sProjectHome == null )
					    System.out.println("sProjectHome null");
					else
					    System.out.println("sProjectHome: '"+sProjectHome+"'");
/**/					
					
					sProjectHome = processPath(sProjectHome);
					//System.out.println("(Final)sProjectHome: '"+sProjectHome+"'");
					
				    //statusLabel.setText(sProjectHome);
				    
					// Add to storage..
					boolean bWrite = false;
					StringBuffer recentSb = new StringBuffer();
					String sOut = "";
					buf = readFile(1000, "recent.tmp");
					if ( (buf != null) && (buf.length > 0) )
					    sOut = new String(buf);
					
					if ( (sOut != null) && (sOut.length() > 0) )
					{
					    //System.out.println("(recent.tmp)sOut: '"+sOut+"'");
					    String[] sAr;
					    sAr = sOut.split("~");
					    
						String sTok;
						String sTitle;
						bMatch = false;
						// Find matching Project Home..
						for ( int iG = 0; iG < sAr.length; iG++ )
						{
							sTok = sAr[iG];
							//System.out.println("sTok: '"+sTok+"'");
							if ( sTok.equals(sProjectHome) )
							{
							    //System.out.println("--MATCH--");
								bMatch = true;
								break;
							}
						}

                        //System.out.println("bMatch: "+bMatch);						
						if ( ! bMatch )
						{
						    // Clear..
						    sc.sBundlePath = "";
						    
							// Add..
							//System.out.println("Adding");
							recentSb.append(sOut);
							recentSb.append(sProjectHome);
							recentSb.append("~");
                            recentSb.append("~");

							bWrite = true;
						}
					}
					else
					{
						// New..
						recentSb.append(sProjectHome);
						recentSb.append("~");
						
                        sT = sc.sBundlePath;
                        if ( (sT != null) && (sT.length() > 0) )
                        {
                            recentSb.append(sT);
                        }
						
						recentSb.append("~");
						bWrite = true;
					}

					if ( bWrite )
					    writeFile(recentSb.toString().getBytes(), "recent.tmp");
					
					JMenuItem subMenuItem;
					int iLoc3;
					String sTitle = "";
					iLoc3 = sProjectHome.lastIndexOf("/");
					if ( iLoc3 != -1 )
					{
						sTitle = sProjectHome.substring(iLoc3 + 1);
					}
					
					//System.out.println("sTitle: '"+sTitle+"'");
					subMenuItem = new JMenuItem(sTitle);
					subMenuItem.addActionListener(actListener);
					subMenu.add(subMenuItem);

					//System.out.println("(statusLabel.setText())projectHomeS: '"+projectHomeS+"'");
					statusLabel.setText(sProjectHome);
					statusPath.setText(" ");	// Clear status..
					
                    updateStorage();    // Write store.tmp..
                    init();		// Reset..
				    
				}
			}
            else if ( BUILD_BUNDLE.equals(sActionCommand) )
            {
                //System.out.println("BUILD_BUNDLE");
                sDialogTitle = "Build Bundle";
                sCommand = "build-bundle";
                
                sCommandSummary = "Builds an Android App Bundle from a set of Bundle\n" +
                    "modules provided as zip files.";
                
                sOutputPathFieldLbl = "Output (.aab) Path";
                
                // This lets the user know, at least, what file
                // is supposed to be output..
                sOutputPathFile = "bundle.aab";    // Default file to output..
                
                bShowInstallMultiApksText = false;
                bShowAabPath = false;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = true;        // Field to set up..
                
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = true;
                
                RequestDialog();
            }
            else if ( BUILD_APKS.equals(sActionCommand) )
            {
                //System.out.println("BUILD_APKS");
                sDialogTitle = "Build Apks";
                sCommand = "build-apks";
                
                sCommandSummary = "Generates an APK Set archive containing either all possible split APKs\n" +
                    "and standalone APKs or APKs optimized for the connected device.";
                
                sOutputPathFieldLbl = "Output Path";
                
                // This lets the user know, at least, what file
                // is supposed to be output..
                sOutputPathFile = "output.apks";    // Default file to output..
                
                bShowInstallMultiApksText = false;
                bShowAabPath = true;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = true;    // Field to set up..
                
                bShowModeSpinner = true;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = true;
                bShowOverwriteCb = true;
                
                RequestDialog();
            }
            else if ( INSTALL_APKS.equals(sActionCommand) )
            {
                sDialogTitle = "Install Apks";
                sCommand = "install-apks";
                
                sCommandSummary = "Installs APKs extracted from an APK Set to a connected device.\n" +
                    "Replaces already installed package.";
                
                bShowInstallMultiApksText = false;
                bShowAabPath = false;
                bShowApksPath = true;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
            else if ( EXTRACT_APKS.equals(sActionCommand) )
            {
                sDialogTitle = "Extract Apks";
                sCommand = "extract-apks";
                
                sCommandSummary = "Extracts from an APK Set the APKs that should be installed\n" +
                    "on a given device.";
                
                bShowInstallMultiApksText = false;
                bShowAabPath = false;
                bShowApksPath = true;
                bShowDeviceSpecPath = true;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
            else if ( INSTALL_MULTI_APKS.equals(sActionCommand) )
            {
                sDialogTitle = "Install Multi Apks";
                sCommand = "install-multi-apks";
                
                sCommandSummary = "Atomically install APKs and APEXs from multiple APK Sets to\n" +
                    "a connected device.";
                
                bShowInstallMultiApksText = true;
                bShowAabPath = false;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
            else if ( GET_DEVICE_SPEC.equals(sActionCommand) )
            {
                sDialogTitle = "Get Device Spec";
                sCommand = "get-device-spec";
                
                sCommandSummary = "Writes out a JSON file containing the device specifications\n" +
                    "(i.e. features and properties) of the connected Android device.";
                
                sOutputPathFieldLbl = "Output Path";
                
                // This lets the user know, at least, what file
                // is supposed to be output..
                sOutputPathFile = "device-spec.json";    // Default file to output..
                
                bShowInstallMultiApksText = false;
                bShowAabPath = false;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;     // Chooser
                bShowHumanReadableSizes = false;
                bShowOutputPathField = true;        // Field to set up..
                
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = true;
                
                RequestDialog();
            }
            else if ( VALIDATE.equals(sActionCommand) )
            {
                sDialogTitle = "Validate";
                sCommand = "validate";
                
                sCommandSummary = "Verifies the given Android App Bundle is valid and prints\n" +
                    "out information about it.";
                
                bShowInstallMultiApksText = false;
                bShowAabPath = true;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
            else if ( GET_SIZE.equals(sActionCommand) )
            {
                sDialogTitle = "Get Size";
                sCommand = "get-size";
                
                sCommandSummary = "Computes the min and max download sizes of APKs served to\n" +
                    "different devices configurations from an APK Set.";
                
                bShowInstallMultiApksText = false;
                bShowAabPath = false;
                bShowApksPath = true;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = true;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = false;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
            else if ( VERSION.equals(sActionCommand) )
            {
                //RefreshProperties();
                sb = new StringBuffer();
			    
                if ( iOS == LINUX_MAC )
                {
                    sb.append("export PATH=${PATH}:");
                    sb.append('"');
                    sb.append(sJavaPath);
                    sb.append('"');

                    sb.append(";java -jar ");
                    sb.append(sBundleToolJarPath);
                    sb.append(" version");
                }
                else
                {
                    sb.append("SET PATH=");
                    sb.append('"');
                    sb.append(sJavaPath);
                    sb.append('"');
                    sb.append(";%PATH%");
                    
                    sb.append("&&java -jar ");
                    sb.append(sBundleToolJarPath);
                    sb.append(" version");
                }
                
                if ( iOS == WINDOWS )
                    sb.append("\n");
                
                //System.out.println("sb: '"+sb.toString()+"'");
                // Set up for IOBgThread output..
                commandS = sb.toString();
 
                bIOBgThreadFinished = false;
                iOBgThread = new IOBgThread();
                iOBgThread.start();

                while ( true )
                {
                    try
                    {
                        Thread.sleep(100);                       
                    }
                    catch (InterruptedException ie)
                    {
                    }
                    
                    if ( bIOBgThreadFinished )
                        break;
                }
                
            }
            else if ( DUMP.equals(sActionCommand) )
            {
                sDialogTitle = "Dump";
                sCommand = "dump";
                
                sCommandSummary = "Prints files or extract values from the bundle in a human-readable form.";
                
                bShowInstallMultiApksText = false;
                bShowAabPath = true;
                bShowApksPath = false;
                bShowDeviceSpecPath = false;
                bShowHumanReadableSizes = false;
                bShowOutputPathField = false;
                bShowModeSpinner = false;
                bShowDumpSpinner = true;
                bShowConnectedDeviceCb = false;
                bShowOverwriteCb = false;
                
                RequestDialog();
            }
			else if ( AAB_PATH_CHOOSER.equals(sActionCommand) )
			{
				//System.out.println("AAB_PATH_CHOOSER");
				JFileChooser fChooser;
/*				
				if ( sc.sBundlePath == null )
				    System.out.println("sc.sBundlePath null");
				else
				    System.out.println("sc.sBundlePath: '"+sc.sBundlePath+"'");
/**/				    

				if ( (sc.sBundlePath != null) && (sc.sBundlePath.length() > 0) )
				{
				    // Have app bundle path..
                    if ( (releaseCheckBoxMenuItem != null) && (releaseCheckBoxMenuItem.getState() == true) )
                    {
                        if ( sc.sBundlePath.contains("debug") )
                        {
                            // Replace with 'release'..
                            sT = sc.sBundlePath;
                            sT = sT.replace("debug", "release");
                            sc.sBundlePath = sT;
                        }
                    }
                    else
                    {
                        // debug selected, check for 'release'..
                        if ( sc.sBundlePath.contains("release") )
                        {
                            // Replace with 'debug'..
                            sT = sc.sBundlePath;
                            sT = sT.replace("release", "debug");
                            sc.sBundlePath = sT;
                        }
                    }
				    
				    fChooser = new JFileChooser((String)sc.sBundlePath);
				}
				else
				{
				    sB = new StringBuffer();
				    sB.append(sProjectHome);
				    sB.append("/");
					fChooser = new JFileChooser((String)sB.toString());
				    
				}
				
				
/**/


				fChooser.setDialogTitle("Bundle (aab) Path");
				fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fChooser.setAcceptAllFileFilterUsed(false);
				
				if ( fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
				{
				    // The full app bundle path was selected..
				    // Like:   'C:/Android/Dev/G_GameNew/app/build/outputs/bundle/release/app.aab'
				    //System.out.println("APPROVE_OPTION");
					String tS = fChooser.getSelectedFile().toString();
					tS = processPath(tS);
					//System.out.println("(getSelectedFile())tS: '"+tS+"'");
					
					// Add..
					sc.sBundlePath = tS;
					//System.out.println("(Add)sc.sBundlePath: '"+sc.sBundlePath+"'");

                    // Update store.tmp..					
					updateStorage();
					
					// Try to update recent.tmp..
					UpdateBundlePath();
					
/*
					if ( aabPathField == null )
					    System.out.println("aabPathField null");
					else
					    System.out.println("aabPathField not null");
/**/					
					aabPathField.setText(tS);
				}
			}
			else if ( APKS_PATH_CHOOSER.equals(sActionCommand) )
			{
				//System.out.println("APKS_PATH_CHOOSER");
				JFileChooser fChooser;
				
				if ( (sProjectHome != null) && (! sProjectHome.equals("")) )
				{
				    StringBuffer tSb = new StringBuffer();
				    tSb.append(sProjectHome);
				    tSb.append("/");
					fChooser = new JFileChooser((String)tSb.toString());
				}
				else
				{
					fChooser = new JFileChooser();
					fChooser.setCurrentDirectory(new java.io.File("."));
				}
					
				fChooser.setDialogTitle("Apks Path");
				fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fChooser.setAcceptAllFileFilterUsed(false);
				
				if ( fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
				{
					String tS = fChooser.getSelectedFile().toString();
					tS = processPath(tS);
					//System.out.println("tS: '"+tS+"'");
/*
					if ( apksPathField == null )
					    System.out.println("apksPathField null");
					else
					    System.out.println("apksPathField not null");
/**/					
					apksPathField.setText(tS);
				}
			}
			else if ( DEVICE_SPEC_PATH_CHOOSER.equals(sActionCommand) )
			{
				//System.out.println("DEVICE_SPEC_PATH_CHOOSER");
				JFileChooser fChooser;
				
				if ( (sProjectHome != null) && (! sProjectHome.equals("")) )
				{
				    StringBuffer tSb = new StringBuffer();
				    tSb.append(sProjectHome);
				    tSb.append("/");
					fChooser = new JFileChooser((String)tSb.toString());
				}
				else
				{
					fChooser = new JFileChooser();
					fChooser.setCurrentDirectory(new java.io.File("."));
				}
					
				fChooser.setDialogTitle("Device Spec Path");
				fChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fChooser.setAcceptAllFileFilterUsed(false);
				
				if ( fChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
				{
					String tS = fChooser.getSelectedFile().toString();
					tS = processPath(tS);
					//System.out.println("tS: '"+tS+"'");
/*
					if ( deviceSpecPathField == null )
					    System.out.println("deviceSpecPathField null");
					else
					    System.out.println("deviceSpecPathField not null");
/**/					
					deviceSpecPathField.setText(tS);
				}
			}
			else if ( SELECT_DEVICE.equals(sActionCommand) )
			{
			    //System.out.println("SELECT_DEVICE");
			    
			    //RefreshProperties();
			    
				DevicesAr = new ArrayList<String>();				

                bDevicesFinished = false;				
				getDevicesBgThread = new GetDevicesBgThread();
				getDevicesBgThread.start();
				
				while ( true )
				{
				    try
				    {
				        Thread.sleep(150);
				    }
				    catch (InterruptedException ie)
				    {
				    }
				    
				    if ( bDevicesFinished )
				        break;
				}


/*				
				if ( DevicesAr == null )
					System.out.println("(Before selectDeviceDialog())DevicesAr null");
				else
					System.out.println("(Before selectDeviceDialog())DevicesAr.size(): "+DevicesAr.size());
/**/

                if ( (DevicesAr != null) && (DevicesAr.size() == 1) )
                {
                    // Set Device..
                    sc.bConnected = true;
                    
                    sDeviceName = (String)DevicesAr.get(0);
                    //System.out.println("sDeviceName: '"+sDeviceName+"'");

                    // Load Status bar..
                    if ( (sDeviceName != null) && (sDeviceName.length() > 0) )
                        deviceLabel.setText(sDeviceName);
                }
				else if ( (DevicesAr != null) && (DevicesAr.size() > 1) )
					selectDeviceDialog();
			    
            }
            else if ( SELECT_DEVICE_SUBMIT.equals(sActionCommand) )
            {
                //System.out.println("SELECT_DEVICE_SUBMIT");
				// Set Device..
				RefreshProperties();
				
                sc.bConnected = true;
				
				sDeviceName = (String)deviceSpinner.getValue();
				//System.out.println("sDeviceName: '"+sDeviceName+"'");
				
				// Load Status bar..
				if ( (sDeviceName != null) && (sDeviceName.length() > 0) )
					deviceLabel.setText(sDeviceName);
				
				bSelectFinished = true;
				selectDeviceFrame.dispose();
                
            }
			else if (SELECT_DEVICE_CANCEL.equals(sActionCommand))
			{
			    if ( selectDeviceFrame != null )
			    {
                    selectDeviceFrame.setVisible(false);
                    selectDeviceFrame.dispose();
                }
			}
			else if (RELEASE.equals(sActionCommand))
			{
			    releaseCheckBoxMenuItem.setState(true);
			    debugCheckBoxMenuItem.setState(false);
			}
			else if (DEBUG.equals(sActionCommand))
			{
			    releaseCheckBoxMenuItem.setState(false);
			    debugCheckBoxMenuItem.setState(true);
			}
			else
			{
			    //System.out.println("\nSelect project");
			    bMatch = false;
                String sOut;
                String[] sAr;
                buf = readFile(1000, "recent.tmp");
                sOut = new String(buf);
                if ( (sOut != null) && (sOut.length() > 0) )
                {
                    //System.out.println("sOut: '"+sOut+"'");
                    sAr = sOut.split("~");
                    
                    String sTok = "";
                    
                    for ( int iG = 0; iG < sAr.length; iG++ )
                    {
                        //System.out.println("--TOP-- iG: "+iG);
                        sTok = sAr[iG];
                        //System.out.println("(1)sTok: '"+sTok+"'");
                        if ( (iG % 2) == 0 )    // Even..
                        {
                            // Project home..
                            // 'C:/Android/Dev/HurricaneTrackerG'
                            iLoc = sTok.lastIndexOf('/');
                            if ( iLoc != -1 )
                            {
                                // 'HurricaneTrackerG'
                                sT = sTok.substring(iLoc + 1);
                                //System.out.println("sT: '"+sT+"'");
                                if ( sT.equals(sActionCommand) )
                                {
                                    bMatch = true;
                                    //System.out.println("--MATCH--");
                                    sProjectPath = sTok;
                                    
                                    // Get Bundle path..
                                    //  'C:/Android/Dev/HurricaneTrackerG/app/build/outputs/bundle/release/app.aab'
                                    if ( (iG + 1) < sAr.length )
                                    {
                                        sTok = sAr[iG + 1];
                                        //System.out.println("(2)sTok: '"+sTok+"'");
                                        if ( (sTok != null) && (sTok.length() > 0) )
                                            sc.sBundlePath = sTok;
                                        else
                                            sc.sBundlePath = "";
                                    }
                                    
                                    break;
                                }
                            }
                        }
                    }   // End for..
                    
                    if ( bMatch )
                    {
                        sProjectHome = sProjectPath;
                        statusLabel.setText(sProjectHome);
                        statusPath.setText(" ");	// Clear status..

                        updateStorage();    // Write store.tmp..
                        init();		// Reset..
                    }
                }
			}
		}
	};    //}}}

	//{{{	readFile()
	private byte[] readFile(int iInitialSize, String fileName)
	{
	    // Utility to read file
		//System.out.println("readFile()");
/*		
		if ( fileName == null )
		    System.out.println("fileName null");
		else
		    System.out.println("fileName: '"+fileName+"'");
/**/

		ByteArrayOutputStream baos = new ByteArrayOutputStream(iInitialSize);
		byte[] tempBuf = new byte[768];
		
		int iBufLength = tempBuf.length;		
    	int bytes_read = 0;

		FileInputStream fis = null;

		try
		{
			File file = new File(fileName);
			if ( file.exists() )
			{
				fis = new FileInputStream(file);
	
				while ( true )
				{
					bytes_read = fis.read(tempBuf, 0, iBufLength);
					//System.out.println("bytes_read: "+bytes_read);
					if ( bytes_read == -1 )
					{
						// EOF
						break;
					}
		
					baos.write(tempBuf, 0, bytes_read);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception: "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if ( fis != null )
					fis.close();
			}
			catch (IOException ioe)
			{
			}
		}
		
		return baos.toByteArray();
		
	}	//}}}

	//{{{	writeFile()
	private void writeFile(byte[] outBuf, String fileNameS)
	{
	    // Utility to write file
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		File writeFile = new File(fileNameS);
		
		try
		{
			fos = new FileOutputStream(writeFile);
			dos = new DataOutputStream(fos);
			
			dos.write(outBuf, 0, outBuf.length);
			dos.flush();
		}
		catch (IOException ioe)
		{
			System.out.println("writeFile() Exception");
			ioe.printStackTrace();
		}
		finally
		{
			try
			{
				if ( fos != null )
					fos.close();
				
				if ( dos != null )
					dos.close();
			}
			catch (IOException ioe)
			{
			}
		}
	}	//}}}

	//{{{	updateStorage()
	private void updateStorage()
	{
	    // Update store.tmp
	    //   'C:/Android/Dev/G_GameNew~C:/Android/Dev/G_GameNew/app/build/outputs/bundle/release/app.aab'
		//System.out.println("\nupdateStorage()");
		
		StringBuffer sb = new StringBuffer();
		String sT = "";
/*		
        if ( sProjectHome == null )		
		    System.out.println("sProjectHome null");
		else
		    System.out.println("sProjectHome: '"+sProjectHome+"'");
/**/

		if ( (sProjectHome == null) || (sProjectHome.equals("")) )
			sb.append("");
		else
			sb.append(sProjectHome);
		
		sb.append("~");

        // Try to get Bundle path..		
        SingletonClass sc = SingletonClass.getInstance();
        sT = sc.sBundlePath;
/*        
        if ( sT == null )
            System.out.println("(sc.sBundlePath)sT null");
        else
            System.out.println("(sc.sBundlePath)sT: '"+sT+"'");
/**/            
            
        if ( (sT != null) && (sT.length() > 0) )
        {
            sT = sT.trim();
            sb.append(sT);
            
            sc.sBundlePath = sT;
        }
        
        //System.out.println("(New store.tmp)sb: '"+sb.toString()+"'");
		writeFile(sb.toString().getBytes(), "store.tmp");
	}	//}}}

	//{{{	WindowListener	windowClosed()
	static WindowListener windowListener = new WindowAdapter()
	{
		public void windowClosed(WindowEvent e)
		{
			// Invoked when a window has been closed as the result of calling dispose on the window.
			sCurrentPath = "";    // Reset..
			Window window = e.getWindow();
			//System.out.println("window.toString(): "+window.toString());
			if ( window.toString().contains("title=,") )    // Main Window will have this..
			    System.exit(0);
		}

		public void windowClosing(WindowEvent e)
		{
			// Invoked when the user attempts to close the window from the window's system menu.
			Window window = e.getWindow();
			window.dispose();
		}
	}; //}}}

	//{{{	main()	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
			    //System.out.println("\nmain run()");
				bundle_Util = new Bundle_Util();

				mainJFrame = new JFrame();
				mainJFrame.setContentPane(mainPanel);
				mainJFrame.revalidate();
				mainJFrame.pack();
				mainJFrame.repaint();
				mainJFrame.addWindowListener(windowListener);
				mainJFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				mainJFrame.setVisible(true);
			}
		});
	} //}}}

}



