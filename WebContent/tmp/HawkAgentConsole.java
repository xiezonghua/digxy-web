package com.tibco.as.space.agent;

import com.tibco.as.space.ASException;
import com.tibco.as.space.FileLogOptions;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.impl.ASMetaspace;
import com.tibco.as.space.impl.ASRevision;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HawkAgentConsole
{
    Metaspace metaspace;

    public static void printVersion ()
    {
        System.out.println(ASRevision.BANNER);
        System.out.println("TIBCO ActiveSpaces Hawk MicroAgent ");
        System.out.println(ASRevision.EDITION + " Edition. Version: " + ASRevision.VERSION + " " + ASRevision.DATE + " " + ASRevision.REVISION);
        System.out.println(ASRevision.COPYRIGHT);

        if (!ASRevision.EDITION.equals("Enterprise"))
        {
            System.out.println(ASRevision.AS_README);
            System.out.println(ASRevision.AS_LICENSE);
        }
        System.out.println(ASRevision.BANNER);
    }

    public static void main (String[] args)
    {
        printVersion();
        HawkAgentConsole hawkAgentConsole = new HawkAgentConsole(args);
        hawkAgentConsole.run();
        hawkAgentConsole.close();
    }

    private void printHelp ()
    {
        String command = " java -Djava.ext.dirs=<TIBCO_RV_HOME>/lib:<TIBCO_HAWK_HOME>/lib -jar as-hawk-agent.jar \n\n";

        System.out.println("Usage:\n\n" + command
                + "  -metaspace <metaspace_name> default ms      \n"
                + "  -discovery <url / url_list> default tibpgm  \n"
                + "  -listen <url>               default tcp     \n"
                + "  -hawk_rv_service <rv service>               \n"
                + "  -hawk_rv_network <rv network>               \n"
                + "  -hawk_rv_daemon <rv daemon>                 \n"
                + "  -log <log_file>                             \n"
                + "  -log_debug <log_level>      default 3 (INFO)\n"
                + "  -log_limit                  default -1 (no limit) \n"
                + "  -log_count                  default 1       \n"
                + "  -log_append                 default true    \n"
                + "  -debug <log_level> default 3(INFO)          \n"
                + "  -name <member_name>          (deprecated)   \n"
                + "  -member_name <member_name>                  \n"
                + "  -member_timeout               default 30000 \n"
                + "  -cluster_suspend_threshold    default -1    \n"
                + "  -security_policy <policy path>              \n"
                + "  -security_token <token path>                \n"
                + "  -authentication_domain <domain name>        \n"
                + "  -authentication_username <user name>        \n"
                + "  -authentication_keyfile <file location>     \n"
                + "  -authentication_password <password>         \n"
                + "  -identity_password <password>               \n"
                + "  -monitor_system <boolean>     default false \n"
                + "\n"
                + " Discovery url format:\n"
                + "   tcp://interface:port;interface2:port2;interface3:port3\n"
                + "   tibpgm://dport/interface;multicast/key1=value1;key2=value2;key3=value3\n"
                + " Listen url format:\n"
                + "   tcp://interface:port\n"
                + " Remote listen url format:\n"
                + "   tcp://interface:remote_listen_port"
         );
    }

    String metaspaceName;
    String memberName;
    String discoveryURL;

    String policyFile;
    String tokenFile;
    char[] identityPassword;

    String authentication_domain;
    String authentication_username;
    String authentication_keyfile;
    String authentication_password;
    String monitor_system;

    String listenURL;

    String logFile;
    String logFileDebug;
    String logFileLimit;
    String logFileCount;
    String logFileAppend;

    String logLevel;

    long connectionTimeout;
    String securityLogLevel;

    String memberTimeout;
    String clusterSuspendThreshold;

    String rvService;
    String rvNetwork;
    String rvDaemon;

    public HawkAgentConsole (String[] args)
    {
        if (args.length > 0)
        {
            if (args[0].equals("-h") || args[0].equals("-help") || args[0].equals("help") || args[0].equals("?"))
            {
                printHelp();
                System.exit(0);
            }
            else if (args[0].equals("-version"))
            {
                // version info has already been displayed
                System.exit(0);
            }
        }

        // set defaults from FileLogOptions
        FileLogOptions options = FileLogOptions.create();
        logFileLimit = "" + options.getLimit();
        logFileCount = "" + options.getFileCount();
        logFileAppend = "" + options.isAppend();
        logFileDebug = "" + options.getLogLevel().getValue();

        // set other defaults
        connectionTimeout = -1L;

        for (int i = 0; i < args.length; i++)
        {
            if (args[i].equals("-name") || args[i].equals("-member_name"))
            {
                if (i + 1 != args.length)
                {
                    memberName = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-log"))
            {
                if (i + 1 != args.length)
                {
                    logFile = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-log_debug"))
            {
                if (i + 1 != args.length)
                {
                    logFileDebug = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-log_limit"))
            {
                if (i + 1 != args.length)
                {
                    logFileLimit = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-log_count"))
            {
                if (i + 1 != args.length)
                {
                    logFileCount = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-log_append"))
            {
                if (i + 1 != args.length)
                {
                    logFileAppend = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-debug"))
            {
                if (i + 1 != args.length)
                {
                    logLevel = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-security_debug"))
            {
                if (i + 1 != args.length)
                {
                    securityLogLevel = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-metaspace"))
            {
                if (i + 1 != args.length)
                {
                    metaspaceName = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-discovery"))
            {
                if (i + 1 != args.length)
                {
                    discoveryURL = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-listen"))
            {
                if (i + 1 != args.length)
                {
                    listenURL = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-member_timeout"))
            {
                if (i + 1 != args.length)
                {
                    try
                    {
                        memberTimeout = args[++i];
                        long timeout = Long.parseLong(memberTimeout); // test if parse succeeds
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("invalid value for " + args[i]);
                    }
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-cluster_suspend_threshold"))
            {
                if (i + 1 != args.length)
                {
                    try
                    {
                        clusterSuspendThreshold = args[++i];
                        int threshold = Integer.parseInt(clusterSuspendThreshold); // test if parse succeeds
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("invalid value for " + args[i]);
                    }
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-hawk_rv_service"))
            {
                if (i + 1 != args.length)
                {
                    rvService = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-hawk_rv_network"))
            {
                if (i + 1 != args.length)
                {
                    rvNetwork = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-hawk_rv_daemon"))
            {
                if (i + 1 != args.length)
                {
                    rvDaemon = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-security_policy"))
            {
                if (i + 1 != args.length)
                {
                    policyFile = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-security_token"))
            {
                if (i + 1 != args.length)
                {
                    tokenFile = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-identity_password"))
            {
                if (i + 1 != args.length)
                {
                    identityPassword = args[++i].toCharArray();
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-authentication_domain"))
            {
                if (i + 1 != args.length)
                {
                    authentication_domain = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-authentication_username"))
            {
                if (i + 1 != args.length)
                {
                    authentication_username = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-authentication_keyfile"))
            {
                if (i + 1 != args.length)
                {
                    authentication_keyfile = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-authentication_password"))
            {
                if (i + 1 != args.length)
                {
                    authentication_password = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-monitor_system"))
            {
                if (i + 1 != args.length)
                {
                    monitor_system = args[++i];
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else if (args[i].equals("-connection_timeout"))
            {
                if (i + 1 != args.length)
                {
                    try
                    {
                        connectionTimeout = Long.parseLong(args[++i]);
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("invalid value for " + args[i]);
                    }
                }
                else
                {
                    System.out.println("missing value for " + args[i]);
                }
            }
            else
            {
                System.out.println("Unknown command " + args[i]);
                printHelp();
                System.exit(0);
            }
        }
    }

    public void close ()
    {
        if (metaspace != null)
        {
            try
            {
                String mname = metaspace.getName();
                System.out.println("Disconnecting from metaspace " + mname);
                metaspace.closeAll();
                metaspace = null;
                System.out.println("Disconnected from metaspace " + mname);
            }
            catch (ASException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    //
    public void run ()
    {
        try
        {
            Runtime.getRuntime().addShutdownHook(new Thread()
            {
                public void run ()
                {
                    if (metaspace != null)
                    {
                        System.out.println("Signal caught - Hawk MicroAgent exiting...");
                        close();
                    }
                }
            });

            Map<String, String> p = new HashMap<String, String>();

            p.put("-pname", "as-hawk-agent");

            if (logFile != null)
            {
                p.put("-log", logFile);
                p.put("-log_debug", logFileDebug);
                p.put("-log_limit", logFileLimit);
                p.put("-log_append", logFileAppend);
                p.put("-log_count", logFileCount);
            }
            if (logLevel != null)
            {
                p.put("-debug", "" + logLevel);
            }

            if (securityLogLevel != null)
            {
                p.put("-security_debug", "" + securityLogLevel);
            }

            if (monitor_system != null)
            {
                p.put("-monitor_system", monitor_system);
            }

            MemberDef memberDef = MemberDef.create();
            memberDef.setMemberName(memberName);
            memberDef.setDiscovery(discoveryURL);
            memberDef.setListen(listenURL);

            if (memberTimeout != null)
            {
                long timeout = Long.parseLong(memberTimeout);
                memberDef.setMemberTimeout(timeout);
            }

            if (clusterSuspendThreshold != null)
            {
                int threshold = Integer.parseInt(clusterSuspendThreshold);
                memberDef.setClusterSuspendThreshold(threshold);
            }

            if (connectionTimeout != -1L)
            {
                memberDef.setConnectTimeout(connectionTimeout);
            }

            memberDef.setSecurityPolicyFile(policyFile);
            memberDef.setSecurityTokenFile(tokenFile);
            memberDef.setIdentityPassword(identityPassword);

            if (authentication_username != null && authentication_password != null)
            {
                memberDef.setAuthenticationCallback(new SimpleAuthenticate(authentication_domain, authentication_username, authentication_password));
            }
            else if (authentication_keyfile != null && authentication_password != null)
            {
                memberDef.setAuthenticationCallback(new SimpleAuthenticate(authentication_keyfile, authentication_password));
            }
            else if (authentication_username != null && authentication_password == null)
            {
                System.out.println("Incomplete command: Missing password in credential");
                return;
            }
            else if (authentication_domain != null && authentication_username == null)
            {
                System.out.println("Incomplete command: Missing username in credential");
                return;
            }
            else if (authentication_password != null && authentication_username == null)
            {
                System.out.println("Incomplete command: Missing username in credential");
                return;
            }
            else if (authentication_keyfile != null && authentication_password == null)
            {
                System.out.println("Incomplete command: Missing password in credential");
                return;
            }
            else if (authentication_password != null && authentication_keyfile == null)
            {
                System.out.println("Incomplete command: Missing keyfile in credential");
                return;
            }

            metaspace = new ASMetaspace(metaspaceName, memberDef, p);

            System.out.println();
            System.out.println("Connected to metaspace using name '" + metaspace.getName() + "'"
                    + ", discovery url '" + metaspace.getMemberDef().getDiscovery() + "'"
                    + ", listen url '" + metaspace.getMemberDef().getListen() + "'");

            try
            {
                Class microAgentClass = Class.forName("com.tibco.as.ami.AmiMicroSessionStarter");

                Object microAgent = microAgentClass.newInstance();
                Class[] paramTypes = {Metaspace.class, String.class, String.class, String.class};

                @SuppressWarnings("unchecked")
                Method method = microAgentClass.getMethod("open", paramTypes);
                method.invoke(microAgent, metaspace, rvService, rvNetwork, rvDaemon);
            }
            catch (InvocationTargetException invokeEx)
            {
                System.err.println("");

                if (invokeEx.getCause() instanceof NoClassDefFoundError)
                {
                    Throwable noClassDefFoundError = invokeEx.getCause();
                    String missingClass = noClassDefFoundError.getCause().getMessage();
                    System.err.println("[FATAL] Failed to start the Hawk MicroAgents: class " + missingClass + " not found.");
                }
                else
                {
                    invokeEx.printStackTrace();
                    System.err.println("[FATAL] Failed to start the Hawk MicroAgents" + invokeEx.getMessage());
                }

                System.err.println("");
                System.err.println("Ensure <TIBCO_HAWK_HOME>/lib and <TIBCO_RV_HOME>/lib are included in the -Djava.ext.dirs on the startup script.");
                System.err.println("");

                printHelp();

                return;
            }
            catch (Exception ex)
            {
                System.err.println("");
                System.err.println("[FATAL] Failed to start the Hawk MicroAgents: " + ex.getMessage());
                System.err.println("");
                ex.printStackTrace();

                return;
            }

            while (true)
            {
                try
                {
                    Thread.sleep(1000);

                    // AS-2078: must update the reference for the metaspace
                    // else it can be garbage collected by the JVM, resulting
                    // in a closed metaspace
                    if (metaspace != null)
                    {
                        metaspace.hashCode();
                    }
                }
                catch (InterruptedException ignore)
                {

                    break;
                }

            }
        }
        catch (ASException ex)
        {
            System.out.println("Could not connect to metaspace: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
