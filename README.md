# Big Data Frameworks : YARN 2

### Name : Matthieu FREIRE ELEUTERIO

## Introduction

**Connect to the cluster**

```bash
ssh -l matthieu.freire.eleuterio bigdata01.efrei.hadoop.clemlab.io
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password:
```

**Check the HDFS**

```bash
ls
hadoop-examples-mapreduce.jar  input.txt
```

**Check the content of the input file**

```bash
cat input.txt
La tour Eiffel [tuʁɛfɛl] est une tour de fer puddlé de 330 m de hauteur située à Paris, à l’extrémité nord-ouest du parc du Champ-de-Mars en bordure de la Seine dans le 7ᵉ arrondissement. Son adresse officielle est 5, avenue Anatole-France
```

**Check the edge node**

```bash
hdfs dfs -ls
Found 15 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-15 11:57 .staging
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   58978808 2024-07-15 10:40 hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt
```

```bash
hdfs dfs -cat /user/matthieu.freire.eleuterio/output-districts/part-r-00000
‘was	1
‘we	1
‘what	1
‘what’s	1
‘when	1
‘who	1
‘whose	1
‘why	1
‘with	1
‘would	1
‘yonder	1
‘you	1
‘you’ll	1
“Ah,	1
“Defects,”	1
“Good	1
“Heads	1
“Here	1
“I	1
“Information	1
“Iron	1
“It	1
“Jip!”’	1
“Merrily	1
“Plain	1
“Project	1
“Right	1
“Under	1
“what	1
•	1
```

**Sending the file to the cluster**

```bash
scp /home/matthieu/Documents/Big\ Data\ Frameworks/trees.csv matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io:/home/matthieu.freire.eleuterio
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password:
Permission denied, please try again.
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password:
trees.csv                                                                                                     100%   16KB   1.8MB/s   00:00
```

**Check the file**

```bash
cat trees.csv
GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV
(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars
(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées
(48.8768191638, 2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place d'Estienne-d'Orves;Pérocarya du Caucase;;14;Square Etienne d'Orves
(48.8373323894, 2.40776275516);12;Celtis;australis;Cannabaceae;1906;16.0;295.0;27, boulevard Soult;Micocoulier de Provence;;16;Avenue 27 boulevard Soult
(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)
(48.8325900983, 2.41116455985);12;Platanus;x acerifolia;Platanaceae;1860;45.0;405.0;Ile de Bercy;Platane commun;;21;Bois de Vincennes (Ile de Bercy)
(48.8226749117, 2.33869560229);14;Platanus;x acerifolia;Platanaceae;1840;40.0;580.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Platane commun;;26;Parc Montsouris
(48.8428118006, 2.2972574926);15;Alnus;glutinosa;Betulaceae;1933;16.0;220.0;Rue Th‚ophraste-Renaudot, rue L‚on-Lhermitte, rue Jean Formig‚, rue du Docteur Jacquem;Aulne glutineux;;28;Square Saint Lambert
(48.8717782491, 2.27973325759);16;Aesculus;hippocastanum;Sapindaceae;;30.0;505.0;Avenue Foch;Marronnier d'Inde;;30;Avenue Foch
(48.8802898189, 2.38157469859);19;Ginkgo;biloba;Ginkgoaceae;1913;33.0;230.0;Rue Manin, rue Botzaris;Arbre aux quarante écus;;46;Parc des Buttes Chaumont
(48.8820015094, 2.39836942721);19;Fraxinus;excelsior;Oleaceae;;30.0;365.0;Boulevard d'Algérie;Frêne commun;;52;Square de la Butte du Chapeau Rouge
(48.846044762, 2.2529555706);16;Ailanthus;giraldii;Simaroubaceae;;35.0;460.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Ailanthe;;53;Jardin des Serres d'Auteuil
(48.8606198209, 2.2599223737);16;Taxodium;distichum;Taxodiaceae;1862;35.0;350.0;Berge du lac Inférieur;Cyprés chauve;;56;Bois de Boulogne (Berge du lac inférieur)
(48.8232165418, 2.46016871078);12;Diospyros;kaki;Ebenaceae;;12.0;160.0;Route de la Ferme, route de la Pyramide;Kaki;;58;Jardin de l' Ecole Du Breuil
(48.8764503804, 2.25765244347);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;;;Séquoia géant;;59;Bois de Boulogne (Portes Saint james)
(48.8691485018, 2.27224125103);16;Gymnocladus;dioicus;Fabaceae;;10.0;162.0;;Chicot du Canada;;61;Square Schumann
(48.8615768444, 2.25902702441);16;Fagus;sylvatica;Fagaceae;1857;10.0;200.0;;Hêtre pleureur;Pendula;63;Bois de Boulogne (petite île du Lac Inférieur)
(48.8633555664, 2.26174532022);16;Pterocarya;fraxinifolia;Juglandaceae;1882;27.0;400.0;;Pérocarya du Caucase;;65;Bois de Boulogne (Berge du lac inférieur)
(48.8646024472, 2.25171449183);16;Sequoiadendron;giganteum;Taxodiaceae;1872;;655.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Séquoia géant;;67;Bois de Boulogne (Pré Catelan)
(48.865022534, 2.2538285063);16;Pinus;nigra;Pinaceae;;30.0;250.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Pin noir;;69;Bois de Boulogne (Pré Catelan)
(48.8704017043, 2.24852577475);16;Platanus;orientalis;Platanaceae;1843;26.0;340.0;Allée de Longchamp, route de Sèvres à Neuilly;Platane d'Orient;;73;Bois de Boulogne (Bagatelle)
(48.8347628794, 2.42029690936);12;Zelkova;serrata;Ulmaceae;1872;18.0;240.0;;Zelkova du Japon;;83;Bois de Vincennes (Ecole chiens guide d'aveugle)
(48.8333849101, 2.41261756721);12;Juglans;nigra;Juglandaceae;1845;28.0;570.0;route de la ceinture du Lac Daumesnil;Noyer noir;;85;Bois de Vincennes (Lac Daumesnil/porte Dorée)
(48.8324049718, 2.41169855654);12;Taxodium;distichum;Taxodiaceae;1930;20.0;270.0;Ile de Bercy;Cyprés chauve;;87;Bois de Vincennes (Ile de Bercy)
(48.8213214388, 2.45537251962);12;Pinus;bungeana;Pinaceae;;10.0;50.0;Route de la Ferme, route de la Pyramide;Pin Napoléon;;95;Arboretum Ecole du Breuil
(48.8204495642, 2.44579219199);12;Pinus;nigra;Pinaceae;1870;25.0;248.0;route de la Tourelle, route du Point de Vue;Pin noir;Austriaca;97;Bois de Vincennes (lac de gravelle)
(48.8520958913, 2.34740754195);5;Robinia;pseudoacacia;Fabaceae;1601;11.0;385.0;Quai de Montebello, rue Lagrange, rue Saint-Julien-le-Pauvre;Robinier faux-acacia;;4;Square Viviani
(48.8578717375, 2.29706549763);7;Eucommia;ulmoides;Eucomiaceae;;12.0;190.0;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Arbre à gutta-percha;;7;Parc du Champs de Mars
(48.8792159582, 2.30640768208);8;Ginkgo;biloba;Ginkgoaceae;1879;22.0;283.0;Boulevard de Courcelles, avenue V‚lasquez, avenue Van-Dyck, avenue Ruysdael;Arbre aux quarante écus;;10;Parc Monceau
(48.8669690843, 2.31951408752);8;Sequoiadendron;giganteum;Taxodiaceae;1850;20.0;320.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Séquoia géant;;12;Jardin des Champs Elysées
(48.8353848188, 2.38157245444);12;Platanus;x acerifolia;Platanaceae;;35.0;510.0;Rue Paul-Belmondo, rue Joseph-Kessel, rue de l'Ambroise, rue François-Truffaut;Platane commun;;17;Parc de Bercy
(48.8330496955, 2.35078878768);13;Aesculus;hippocastanum;Sapindaceae;1894;18.0;355.0;Rue Croulebarbe, rue Corvisart, rue Emile-Deslandres, rue des Cordelières;Marronnier d'Inde;;23;Square René Le Gall
(48.8224956954, 2.3366608746);14;Fagus;sylvatica;Fagaceae;;30.0;370.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Hêtre pourpre;Purpurea;25;Parc Montsouris
(48.8220238534, 2.33628540112);14;Sequoia;sempervirens;Taxodiaceae;1935;30.0;335.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Séquoia sempervirent;;27;Parc Montsouris
(48.8814628758, 2.38367383179);19;Styphnolobium;japonicum;Fabaceae;1873;10.0;335.0;Rue Manin, rue Botzaris;Sophora du Japon;;44;Parc des Buttes Chaumont
(48.8803986732, 2.38129958306);19;Platanus;orientalis;Platanaceae;1862;34.0;670.0;Rue Manin, rue Botzaris;Platane d'Orient;;45;Parc des Buttes Chaumont
(48.8619346483, 2.39870061217);20;Acer;monspessulanum;Sapindacaees;1833;12.0;225.0;Rue du repos, rue des Rondeaux;Erable de Montpellier;;48;Cimetière du Père Lachaise
(48.879759998, 2.38064802989);19;Sequoiadendron;giganteum;Taxodiaceae;;35.0;470.0;Rue Manin, rue Botzaris;Séquoia géant;;57;Parc des Buttes Chaumont
(48.8640166469, 2.26774597209);16;Fagus;sylvatica;Fagaceae;;18.0;300.0;;Hêtre pourpre;Purpurea;60;Stade Muette
(48.8647824278, 2.25120424857);16;Diospyros;kaki;Ebenaceae;1897;14.0;145.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Kaki;;68;Bois de Boulogne (Pré Catelan)
(48.8693939056, 2.24776773334);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;490.0;Allée de Longchamp, route de Sèvres à Neuilly;Séquoia géant;;72;Bois de Boulogne (Bagatelle)
(48.867043584, 2.25320074406);16;Platanus;x acerifolia;Platanaceae;1872;40.0;520.0;Route du Lac à Bagatelle;Platane commun;;74;Bois de Boulogne (Route du Lac à Bagatelle)
(48.8630909172, 2.24159242682);16;Pinus;nigra laricio;Pinaceae;1882;30.0;240.0;All‚e de Longchamp, carrefour des cascades;Pin de Corse;;76;Bois de Boulogne (réservoir de la cascade)
(48.8632834941, 2.24066981564);16;Taxodium;distichum;Taxodiaceae;1859;30.0;290.0;Allée de Longchamp, carrefour des cascades;Cyprés chauve;;77;Bois de Boulogne (Grande Cascade)
(48.8400020891, 2.46422657197);12;Acer;cappadocicum;Sapindaceae;1900;16.0;280.0;avenue de la Belle Gabrielle;Erable de Cappadoce;;78;Bois de Vincennes (pelouse de Fontenay)
(48.8394165343, 2.43360205128);12;Liriodendron;tulipifera;Magnoliaceae;1862;35.0;305.0;avenue Daumesnil, Esplanade du Château de Vincennes;Tulipier de Virginie;;81;Bois de Vincennes (square Carnot)
(48.8319232533, 2.41202933239);12;Liriodendron;tulipifera;Magnoliaceae;1930;22.0;205.0;Ile de Bercy;Tulipier de Virginie;;88;Bois de Vincennes (Ile de Bercy)
(48.8320684332, 2.41182825531);12;Taxus;baccata;Taxaceae;1870;5.0;140.0;Ile de Bercy;If commun;;89;Bois de Vincennes (Ile de Bercy)
(48.8292071873, 2.41301158121);12;Platanus;x acerifolia;Platanaceae;1871;25.0;490.0;route de la ceinture du Lac Daumesnil;Platane commun;;92;Bois de Vincennes (lac daumesnil)
(48.8400754064, 2.43381509843);12;Diospyros;virginiana;Ebenaceae;1875;14.0;180.0;avenue Daumesnil, Esplanade du Château de Vincennes;Plaqueminier de Virginie;;94;Bois de Vincennes (square Carnot)
(48.8183933679, 2.43791766754);12;Quercus;ilex;Fagaceae;1860;15.0;;route de Gravelle, route du Mar‚chal Leclerc (Saint Maurice);Chêne vert;;98;Bois de Vincennes (pente de Gravelle)
(48.8557581795, 2.35399582218);4;Ulmus;carpinifolia;Ulmaceae;1935;15.0;180.0;Place St Gervais;Orme champêtre;;2;Place Saint Gervais
(48.8453050031, 2.35307565328);5;Fagus;sylvatica;Fagaceae;1905;2.0;72.0;Rue des Arênes, rue de Navarre, rue Monge;Faux de Verzy;Tortuosa;3;Square des Arènes de Lutèce
(48.8618464812, 2.37910176561);11;Corylus;colurna;Betulaceae;1879;20.0;245.0;Rue Lacharrière, rue Rochebrune, rue du Général-Guilhem, rue du Général-Blaise;Noisetier de Byzance;;15;Square Maurice Gardette
(48.8420426954, 2.43848438671);12;Fagus;sylvatica;Fagaceae;1895;23.0;370.0;Cours Marigny;Hêtre pourpre;Purpurea;18;Bois de Vincennes (Cours Marigny)
(48.8201249835, 2.44524393613);12;Cedrus;libanii;Pinaceae;1829;30.0;440.0;route de la Tourelle, route du Point de Vue;Cèdre du Liban;;22;Bois de Vincennes (lac de Gravelle)
(48.8471789821, 2.25293802515);16;Quercus;suber;Fagaceae;1895;10.0;180.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Chêne liège;;32;Jardin des Serres d'Auteuil
(48.8450859307, 2.26948936839);16;Broussonetia;papyrifera;Moraceae;;12.0;190.0;Rue Mirabeau, avenue de Versailles;Murier à papier;;33;Parc Sainte Perinne
(48.8634848878, 2.2403752961);16;Cedrus;libanii;Pinaceae;1862;30.0;460.0;All‚e de Longchamp, carrefour des cascades;Cèdre du Liban;;37;Bois de Boulogne (réservoir de la grande cascade)
(48.8845880534, 2.34391859224);18;Platanus;orientalis;Platanaceae;1857;27.0;470.0;Place Saint-Pierre, rue Ronsard, rue Paul-Albert, rue Maurice Utrillo;Platane d'Orient;;42;Square Louise Michel
(48.8830346813, 2.37007425143);19;Tilia;tomentosa;Malvaceae;1945;20.0;205.0;Place Stalingrad;Tilleul argenté;;43;Place de la bataille de Stalingrad
(48.85646631, 2.39469777758);20;Platanus;x acerifolia;Platanaceae;1880;20.0;395.0;148 boulevard de Charonne;Platane commun;;51;Alignement 148 boulevard de Charonne
(48.8471653404, 2.25199572129);16;Pterocarya;stenoptera;Juglandaceae;1905;30.0;530.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Ptérocarya de Chine;;54;Jardin des Serres d'Auteuil
(48.867221687, 2.27027693483);16;Cedrus;atlantica;Pinaceae;;6.0;195.0;;Cèdre bleu de l'Atlas ple;Glauca pendula;62;Square Debussy
(48.8731203887, 2.24884917245);16;Fagus;sylvatica;Fagaceae;1868;15.0;230.0;Allée de Longchamp, route de Sèvres à Neuilly;Hêtre pleureur;Pendula;70;Bois de Boulogne (Bagatelle)
(48.8732545226, 2.24886543775);16;Davidia;involucrata;Cornaceae;1906;12.0;120.0;Allée de Longchamp, route de Sèvres à Neuilly;Arbre aux pochettes;;71;Bois de Boulogne (Bagatelle)
(48.8433252639, 2.4497117757);12;Quercus;petraea;Fagaceae;1815;31.0;450.0;;Chêne rouve;;80;Bois de Vincennes (fort neuf)
(48.8323806372, 2.41052012477);12;Platanus;x acerifolia;Platanaceae;1860;42.0;405.0;Ile de Bercy;Platane commun;;90;Bois de Vincennes (Ile de Bercy)
(48.8314334738, 2.4115101993);12;Diospyros;virginiana;Ebenaceae;1935;12.0;;Ile de Bercy;Plaqueminier de Virginie;;93;Bois de Vincennes (Ile de Bercy)
(48.8210086122, 2.45551492936);12;Pinus;coulteri;Pinaceae;;14.0;225.0;Route de la Ferme, route de la Pyramide;Pin aux grands cônes;;96;Arboretum Ecole du Breuil
(48.8785456147, 2.30757576047);8;Platanus;orientalis;Platanaceae;1814;31.0;700.0;Boulevard de Courcelles, avenue V‚lasquez, avenue Van-Dyck, avenue Ruysdael;Platane d'Orient;;9;Parc Monceau
(48.8652536076, 2.31333976248);8;Platanus;orientalis;Platanaceae;1900;20.0;480.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Platane d'Orient;;13;Jardin des Champs Elysées
(48.8476260928, 2.25278179131);16;Ginkgo;biloba;Ginkgoaceae;1895;25.0;395.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Arbre aux quarante écus;;31;Jardin des Serres d'Auteuil
(48.861574817, 2.2910717819);16;Corylus;colurna;Betulaceae;;20.0;260.0;Place du Trocad‚ro et du 11 Novembre, rue Benjamin Franklin, avenue Albert de Mun;Noisetier de Byzance;;34;Jardin du Trocadéro
(48.8708601366, 2.24769299518);16;Taxus;baccata;Taxaceae;1772;13.0;235.0;Allée de Longchamp, route de Sèvres à Neuilly;If commun;;36;Bois de Boulogne (Bagatelle)
(48.8646850734, 2.25360607406);16;Fagus;sylvatica;Fagaceae;1782;30.0;558.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Hêtre pourpre;Purpurea;38;Bois de Boulogne (Pré Catelan)
(48.8880577555, 2.31595908796);17;Platanus;x acerifolia;Platanaceae;1840;30.0;595.0;Place Charles Filion, rue Cardinet;Platane commun;;41;Square des Batignolles
(48.8597396934, 2.39997847741);20;Aesculus;hippocastanum;Sapindaceae;;22.0;345.0;Rue du repos, rue des Rondeaux;Marronnier d'Inde;;47;Cimetière du Père Lachaise
(48.8622517606, 2.26098883991);16;Ginkgo;biloba;Ginkgoaceae;1893;18.0;215.0;;Arbre aux quarante écus;;64;Bois de Boulogne (Berge du lac inférieur)
(48.8336849895, 2.42111102704);12;Ginkgo;biloba;Ginkgoaceae;1865;25.0;255.0;;Arbre aux quarante écus;;84;Bois de Vincennes (Ecole chiens guide d'aveugle)
(48.8648376291, 2.36062929978);3;Corylus;colurna;Betulaceae;1882;20.0;210.0;Rue du Temple, rue de Bretagne, Rue Perrée, rue Eugène-Spuller;Noisetier de Byzance;;1;Square du Temple
(48.856902513, 2.33666989768);6;Catalpa;bignonioides;Bignoniaceae;;15.0;260.0;Rue de Seine, rue Mazarine;Catalpa commun;;5;Square Gabriel Pierné
(48.8577766649, 2.29329076205);7;Platanus;orientalis;Platanaceae;1814;20.0;700.0;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Platane d'Orient;;8;Parc du Champs de Mars
(48.8399672948, 2.43375148978);12;Fagus;sylvatica;Fagaceae;1865;20.0;530.0;avenue Daumesnil, Esplanade du Château de Vincennes;Hêtre pleureur;Pendula;20;Bois de Vincennes (square Carnot)
(48.827737189, 2.3592096955);13;Cedrus;atlantica;Pinaceae;1939;25.0;350.0;128-160 avenue de Choisy, rue Georges-Eastman, rue Charles-Moureu, rue du Docteur-Magn;Cèdre bleu de l'Atlas;Glauca;24;Parc de Choisy
(48.8723867386, 2.27912885453);16;Zelkova;carpinifolia;Ulmaceae;1852;30.0;395.0;Avenue Foch;Faux orme de Sibérie;;29;Avenue Foch
(48.8619170093, 2.2924448277);16;Paulownia;tomentosa;Paulowniaceae;;20.0;420.0;Place du Trocad‚ro et du 11 Novembre, rue Benjamin Franklin, avenue Albert de Mun;Paulownia;;35;Jardin du Trocadéro
(48.8716117578, 2.24933653506);16;Araucaria;araucana;Araucariaceae;1907;9.0;140.0;Allée de Longchamp, route de Sèvres à Neuilly;Désespoir du singe;;39;Bois de Boulogne (Bagatelle)
(48.8691433358, 2.24587597613);16;Platanus;x acerifolia;Platanaceae;1847;40.0;480.0;Allée de Longchamp, route de Sèvres à Neuilly;Platane commun;;40;Bois de Boulogne (Bagatelle)
(48.8661956075, 2.26238964912);16;Platanus;orientalis;Platanaceae;1859;25.0;375.0;Ile du lac inférieur;Platane d'Orient;;49;Bois de Boulogne (île du lac inférieur)
(48.8215800145, 2.45494779675);12;Zelkova;carpinifolia;Ulmaceae;;12.0;245.0;Route de la Ferme, route de la Pyramide;Faux orme de Sibérie;;50;Arboretum de Ecole du Breuil
(48.8727584235, 2.2873548507);16;Platanus;x acerifolia;Platanaceae;1852;30.0;525.0;Avenue Foch;Platane commun;;55;Avenue Foch
(48.8588189763, 2.25832952119);16;Magnolia;grandiflora;Magnoliaceae;1863;12.0;;Allée de Longchamp, carrefour des cascades;Magnolia à grandes fleurs;;66;Bois de Boulogne (Berge du lac inférieur)
(48.86260617, 2.23782412563);16;Zelkova;carpinifolia;Ulmaceae;1896;16.0;260.0;;Faux orme de Sibérie;;75;Bois de Boulogne (Moulin de Longchamp)
(48.8395160905, 2.43350820893);12;Platanus;x acerifolia;Platanaceae;1918;32.0;570.0;avenue Daumesnil, Esplanade du Château de Vincennes;Platane commun;;82;Bois de Vincennes (Square Carnot)
(48.833545551, 2.41033694606);12;Platanus;orientalis;Platanaceae;1860;22.0;475.0;route de la ceinture du Lac Daumesnil;Platane d'Orient;;86;Bois de Vincennes (Lac Daumesnil/porte Dorée)
(48.8302532096, 2.41400587444);12;Acer;opalus;Sapindaceae;1870;15.0;160.0;Ile de Bercy;Erable d'Italie;;91;Bois de Vincennes (Ile de Bercy)
```

**Adding the file to HDFS edge node**

```bash
hdfs dfs -put trees.csv
hdfs dfs -cat trees.csv
GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV
(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars
(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées
(48.8768191638, 2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place d'Estienne-d'Orves;Pérocarya du Caucase;;14;Square Etienne d'Orves
(48.8373323894, 2.40776275516);12;Celtis;australis;Cannabaceae;1906;16.0;295.0;27, boulevard Soult;Micocoulier de Provence;;16;Avenue 27 boulevard Soult
(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)
(48.8325900983, 2.41116455985);12;Platanus;x acerifolia;Platanaceae;1860;45.0;405.0;Ile de Bercy;Platane commun;;21;Bois de Vincennes (Ile de Bercy)
(48.8226749117, 2.33869560229);14;Platanus;x acerifolia;Platanaceae;1840;40.0;580.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Platane commun;;26;Parc Montsouris
(48.8428118006, 2.2972574926);15;Alnus;glutinosa;Betulaceae;1933;16.0;220.0;Rue Th‚ophraste-Renaudot, rue L‚on-Lhermitte, rue Jean Formig‚, rue du Docteur Jacquem;Aulne glutineux;;28;Square Saint Lambert
(48.8717782491, 2.27973325759);16;Aesculus;hippocastanum;Sapindaceae;;30.0;505.0;Avenue Foch;Marronnier d'Inde;;30;Avenue Foch
(48.8802898189, 2.38157469859);19;Ginkgo;biloba;Ginkgoaceae;1913;33.0;230.0;Rue Manin, rue Botzaris;Arbre aux quarante écus;;46;Parc des Buttes Chaumont
(48.8820015094, 2.39836942721);19;Fraxinus;excelsior;Oleaceae;;30.0;365.0;Boulevard d'Algérie;Frêne commun;;52;Square de la Butte du Chapeau Rouge
(48.846044762, 2.2529555706);16;Ailanthus;giraldii;Simaroubaceae;;35.0;460.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Ailanthe;;53;Jardin des Serres d'Auteuil
(48.8606198209, 2.2599223737);16;Taxodium;distichum;Taxodiaceae;1862;35.0;350.0;Berge du lac Inférieur;Cyprés chauve;;56;Bois de Boulogne (Berge du lac inférieur)
(48.8232165418, 2.46016871078);12;Diospyros;kaki;Ebenaceae;;12.0;160.0;Route de la Ferme, route de la Pyramide;Kaki;;58;Jardin de l' Ecole Du Breuil
(48.8764503804, 2.25765244347);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;;;Séquoia géant;;59;Bois de Boulogne (Portes Saint james)
(48.8691485018, 2.27224125103);16;Gymnocladus;dioicus;Fabaceae;;10.0;162.0;;Chicot du Canada;;61;Square Schumann
(48.8615768444, 2.25902702441);16;Fagus;sylvatica;Fagaceae;1857;10.0;200.0;;Hêtre pleureur;Pendula;63;Bois de Boulogne (petite île du Lac Inférieur)
(48.8633555664, 2.26174532022);16;Pterocarya;fraxinifolia;Juglandaceae;1882;27.0;400.0;;Pérocarya du Caucase;;65;Bois de Boulogne (Berge du lac inférieur)
(48.8646024472, 2.25171449183);16;Sequoiadendron;giganteum;Taxodiaceae;1872;;655.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Séquoia géant;;67;Bois de Boulogne (Pré Catelan)
(48.865022534, 2.2538285063);16;Pinus;nigra;Pinaceae;;30.0;250.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Pin noir;;69;Bois de Boulogne (Pré Catelan)
(48.8704017043, 2.24852577475);16;Platanus;orientalis;Platanaceae;1843;26.0;340.0;Allée de Longchamp, route de Sèvres à Neuilly;Platane d'Orient;;73;Bois de Boulogne (Bagatelle)
(48.8347628794, 2.42029690936);12;Zelkova;serrata;Ulmaceae;1872;18.0;240.0;;Zelkova du Japon;;83;Bois de Vincennes (Ecole chiens guide d'aveugle)
(48.8333849101, 2.41261756721);12;Juglans;nigra;Juglandaceae;1845;28.0;570.0;route de la ceinture du Lac Daumesnil;Noyer noir;;85;Bois de Vincennes (Lac Daumesnil/porte Dorée)
(48.8324049718, 2.41169855654);12;Taxodium;distichum;Taxodiaceae;1930;20.0;270.0;Ile de Bercy;Cyprés chauve;;87;Bois de Vincennes (Ile de Bercy)
(48.8213214388, 2.45537251962);12;Pinus;bungeana;Pinaceae;;10.0;50.0;Route de la Ferme, route de la Pyramide;Pin Napoléon;;95;Arboretum Ecole du Breuil
(48.8204495642, 2.44579219199);12;Pinus;nigra;Pinaceae;1870;25.0;248.0;route de la Tourelle, route du Point de Vue;Pin noir;Austriaca;97;Bois de Vincennes (lac de gravelle)
(48.8520958913, 2.34740754195);5;Robinia;pseudoacacia;Fabaceae;1601;11.0;385.0;Quai de Montebello, rue Lagrange, rue Saint-Julien-le-Pauvre;Robinier faux-acacia;;4;Square Viviani
(48.8578717375, 2.29706549763);7;Eucommia;ulmoides;Eucomiaceae;;12.0;190.0;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Arbre à gutta-percha;;7;Parc du Champs de Mars
(48.8792159582, 2.30640768208);8;Ginkgo;biloba;Ginkgoaceae;1879;22.0;283.0;Boulevard de Courcelles, avenue V‚lasquez, avenue Van-Dyck, avenue Ruysdael;Arbre aux quarante écus;;10;Parc Monceau
(48.8669690843, 2.31951408752);8;Sequoiadendron;giganteum;Taxodiaceae;1850;20.0;320.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Séquoia géant;;12;Jardin des Champs Elysées
(48.8353848188, 2.38157245444);12;Platanus;x acerifolia;Platanaceae;;35.0;510.0;Rue Paul-Belmondo, rue Joseph-Kessel, rue de l'Ambroise, rue François-Truffaut;Platane commun;;17;Parc de Bercy
(48.8330496955, 2.35078878768);13;Aesculus;hippocastanum;Sapindaceae;1894;18.0;355.0;Rue Croulebarbe, rue Corvisart, rue Emile-Deslandres, rue des Cordelières;Marronnier d'Inde;;23;Square René Le Gall
(48.8224956954, 2.3366608746);14;Fagus;sylvatica;Fagaceae;;30.0;370.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Hêtre pourpre;Purpurea;25;Parc Montsouris
(48.8220238534, 2.33628540112);14;Sequoia;sempervirens;Taxodiaceae;1935;30.0;335.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Séquoia sempervirent;;27;Parc Montsouris
(48.8814628758, 2.38367383179);19;Styphnolobium;japonicum;Fabaceae;1873;10.0;335.0;Rue Manin, rue Botzaris;Sophora du Japon;;44;Parc des Buttes Chaumont
(48.8803986732, 2.38129958306);19;Platanus;orientalis;Platanaceae;1862;34.0;670.0;Rue Manin, rue Botzaris;Platane d'Orient;;45;Parc des Buttes Chaumont
(48.8619346483, 2.39870061217);20;Acer;monspessulanum;Sapindacaees;1833;12.0;225.0;Rue du repos, rue des Rondeaux;Erable de Montpellier;;48;Cimetière du Père Lachaise
(48.879759998, 2.38064802989);19;Sequoiadendron;giganteum;Taxodiaceae;;35.0;470.0;Rue Manin, rue Botzaris;Séquoia géant;;57;Parc des Buttes Chaumont
(48.8640166469, 2.26774597209);16;Fagus;sylvatica;Fagaceae;;18.0;300.0;;Hêtre pourpre;Purpurea;60;Stade Muette
(48.8647824278, 2.25120424857);16;Diospyros;kaki;Ebenaceae;1897;14.0;145.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Kaki;;68;Bois de Boulogne (Pré Catelan)
(48.8693939056, 2.24776773334);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;490.0;Allée de Longchamp, route de Sèvres à Neuilly;Séquoia géant;;72;Bois de Boulogne (Bagatelle)
(48.867043584, 2.25320074406);16;Platanus;x acerifolia;Platanaceae;1872;40.0;520.0;Route du Lac à Bagatelle;Platane commun;;74;Bois de Boulogne (Route du Lac à Bagatelle)
(48.8630909172, 2.24159242682);16;Pinus;nigra laricio;Pinaceae;1882;30.0;240.0;All‚e de Longchamp, carrefour des cascades;Pin de Corse;;76;Bois de Boulogne (réservoir de la cascade)
(48.8632834941, 2.24066981564);16;Taxodium;distichum;Taxodiaceae;1859;30.0;290.0;Allée de Longchamp, carrefour des cascades;Cyprés chauve;;77;Bois de Boulogne (Grande Cascade)
(48.8400020891, 2.46422657197);12;Acer;cappadocicum;Sapindaceae;1900;16.0;280.0;avenue de la Belle Gabrielle;Erable de Cappadoce;;78;Bois de Vincennes (pelouse de Fontenay)
(48.8394165343, 2.43360205128);12;Liriodendron;tulipifera;Magnoliaceae;1862;35.0;305.0;avenue Daumesnil, Esplanade du Château de Vincennes;Tulipier de Virginie;;81;Bois de Vincennes (square Carnot)
(48.8319232533, 2.41202933239);12;Liriodendron;tulipifera;Magnoliaceae;1930;22.0;205.0;Ile de Bercy;Tulipier de Virginie;;88;Bois de Vincennes (Ile de Bercy)
(48.8320684332, 2.41182825531);12;Taxus;baccata;Taxaceae;1870;5.0;140.0;Ile de Bercy;If commun;;89;Bois de Vincennes (Ile de Bercy)
(48.8292071873, 2.41301158121);12;Platanus;x acerifolia;Platanaceae;1871;25.0;490.0;route de la ceinture du Lac Daumesnil;Platane commun;;92;Bois de Vincennes (lac daumesnil)
(48.8400754064, 2.43381509843);12;Diospyros;virginiana;Ebenaceae;1875;14.0;180.0;avenue Daumesnil, Esplanade du Château de Vincennes;Plaqueminier de Virginie;;94;Bois de Vincennes (square Carnot)
(48.8183933679, 2.43791766754);12;Quercus;ilex;Fagaceae;1860;15.0;;route de Gravelle, route du Mar‚chal Leclerc (Saint Maurice);Chêne vert;;98;Bois de Vincennes (pente de Gravelle)
(48.8557581795, 2.35399582218);4;Ulmus;carpinifolia;Ulmaceae;1935;15.0;180.0;Place St Gervais;Orme champêtre;;2;Place Saint Gervais
(48.8453050031, 2.35307565328);5;Fagus;sylvatica;Fagaceae;1905;2.0;72.0;Rue des Arênes, rue de Navarre, rue Monge;Faux de Verzy;Tortuosa;3;Square des Arènes de Lutèce
(48.8618464812, 2.37910176561);11;Corylus;colurna;Betulaceae;1879;20.0;245.0;Rue Lacharrière, rue Rochebrune, rue du Général-Guilhem, rue du Général-Blaise;Noisetier de Byzance;;15;Square Maurice Gardette
(48.8420426954, 2.43848438671);12;Fagus;sylvatica;Fagaceae;1895;23.0;370.0;Cours Marigny;Hêtre pourpre;Purpurea;18;Bois de Vincennes (Cours Marigny)
(48.8201249835, 2.44524393613);12;Cedrus;libanii;Pinaceae;1829;30.0;440.0;route de la Tourelle, route du Point de Vue;Cèdre du Liban;;22;Bois de Vincennes (lac de Gravelle)
(48.8471789821, 2.25293802515);16;Quercus;suber;Fagaceae;1895;10.0;180.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Chêne liège;;32;Jardin des Serres d'Auteuil
(48.8450859307, 2.26948936839);16;Broussonetia;papyrifera;Moraceae;;12.0;190.0;Rue Mirabeau, avenue de Versailles;Murier à papier;;33;Parc Sainte Perinne
(48.8634848878, 2.2403752961);16;Cedrus;libanii;Pinaceae;1862;30.0;460.0;All‚e de Longchamp, carrefour des cascades;Cèdre du Liban;;37;Bois de Boulogne (réservoir de la grande cascade)
(48.8845880534, 2.34391859224);18;Platanus;orientalis;Platanaceae;1857;27.0;470.0;Place Saint-Pierre, rue Ronsard, rue Paul-Albert, rue Maurice Utrillo;Platane d'Orient;;42;Square Louise Michel
(48.8830346813, 2.37007425143);19;Tilia;tomentosa;Malvaceae;1945;20.0;205.0;Place Stalingrad;Tilleul argenté;;43;Place de la bataille de Stalingrad
(48.85646631, 2.39469777758);20;Platanus;x acerifolia;Platanaceae;1880;20.0;395.0;148 boulevard de Charonne;Platane commun;;51;Alignement 148 boulevard de Charonne
(48.8471653404, 2.25199572129);16;Pterocarya;stenoptera;Juglandaceae;1905;30.0;530.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Ptérocarya de Chine;;54;Jardin des Serres d'Auteuil
(48.867221687, 2.27027693483);16;Cedrus;atlantica;Pinaceae;;6.0;195.0;;Cèdre bleu de l'Atlas ple;Glauca pendula;62;Square Debussy
(48.8731203887, 2.24884917245);16;Fagus;sylvatica;Fagaceae;1868;15.0;230.0;Allée de Longchamp, route de Sèvres à Neuilly;Hêtre pleureur;Pendula;70;Bois de Boulogne (Bagatelle)
(48.8732545226, 2.24886543775);16;Davidia;involucrata;Cornaceae;1906;12.0;120.0;Allée de Longchamp, route de Sèvres à Neuilly;Arbre aux pochettes;;71;Bois de Boulogne (Bagatelle)
(48.8433252639, 2.4497117757);12;Quercus;petraea;Fagaceae;1815;31.0;450.0;;Chêne rouve;;80;Bois de Vincennes (fort neuf)
(48.8323806372, 2.41052012477);12;Platanus;x acerifolia;Platanaceae;1860;42.0;405.0;Ile de Bercy;Platane commun;;90;Bois de Vincennes (Ile de Bercy)
(48.8314334738, 2.4115101993);12;Diospyros;virginiana;Ebenaceae;1935;12.0;;Ile de Bercy;Plaqueminier de Virginie;;93;Bois de Vincennes (Ile de Bercy)
(48.8210086122, 2.45551492936);12;Pinus;coulteri;Pinaceae;;14.0;225.0;Route de la Ferme, route de la Pyramide;Pin aux grands cônes;;96;Arboretum Ecole du Breuil
(48.8785456147, 2.30757576047);8;Platanus;orientalis;Platanaceae;1814;31.0;700.0;Boulevard de Courcelles, avenue V‚lasquez, avenue Van-Dyck, avenue Ruysdael;Platane d'Orient;;9;Parc Monceau
(48.8652536076, 2.31333976248);8;Platanus;orientalis;Platanaceae;1900;20.0;480.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Platane d'Orient;;13;Jardin des Champs Elysées
(48.8476260928, 2.25278179131);16;Ginkgo;biloba;Ginkgoaceae;1895;25.0;395.0;3 avenue de la Porte d'Auteuil, 1 avenue Gordon Benett;Arbre aux quarante écus;;31;Jardin des Serres d'Auteuil
(48.861574817, 2.2910717819);16;Corylus;colurna;Betulaceae;;20.0;260.0;Place du Trocad‚ro et du 11 Novembre, rue Benjamin Franklin, avenue Albert de Mun;Noisetier de Byzance;;34;Jardin du Trocadéro
(48.8708601366, 2.24769299518);16;Taxus;baccata;Taxaceae;1772;13.0;235.0;Allée de Longchamp, route de Sèvres à Neuilly;If commun;;36;Bois de Boulogne (Bagatelle)
(48.8646850734, 2.25360607406);16;Fagus;sylvatica;Fagaceae;1782;30.0;558.0;Route de la Grande Cascade, carrefour de la Croix Catelan;Hêtre pourpre;Purpurea;38;Bois de Boulogne (Pré Catelan)
(48.8880577555, 2.31595908796);17;Platanus;x acerifolia;Platanaceae;1840;30.0;595.0;Place Charles Filion, rue Cardinet;Platane commun;;41;Square des Batignolles
(48.8597396934, 2.39997847741);20;Aesculus;hippocastanum;Sapindaceae;;22.0;345.0;Rue du repos, rue des Rondeaux;Marronnier d'Inde;;47;Cimetière du Père Lachaise
(48.8622517606, 2.26098883991);16;Ginkgo;biloba;Ginkgoaceae;1893;18.0;215.0;;Arbre aux quarante écus;;64;Bois de Boulogne (Berge du lac inférieur)
(48.8336849895, 2.42111102704);12;Ginkgo;biloba;Ginkgoaceae;1865;25.0;255.0;;Arbre aux quarante écus;;84;Bois de Vincennes (Ecole chiens guide d'aveugle)
(48.8648376291, 2.36062929978);3;Corylus;colurna;Betulaceae;1882;20.0;210.0;Rue du Temple, rue de Bretagne, Rue Perrée, rue Eugène-Spuller;Noisetier de Byzance;;1;Square du Temple
(48.856902513, 2.33666989768);6;Catalpa;bignonioides;Bignoniaceae;;15.0;260.0;Rue de Seine, rue Mazarine;Catalpa commun;;5;Square Gabriel Pierné
(48.8577766649, 2.29329076205);7;Platanus;orientalis;Platanaceae;1814;20.0;700.0;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Platane d'Orient;;8;Parc du Champs de Mars
(48.8399672948, 2.43375148978);12;Fagus;sylvatica;Fagaceae;1865;20.0;530.0;avenue Daumesnil, Esplanade du Château de Vincennes;Hêtre pleureur;Pendula;20;Bois de Vincennes (square Carnot)
(48.827737189, 2.3592096955);13;Cedrus;atlantica;Pinaceae;1939;25.0;350.0;128-160 avenue de Choisy, rue Georges-Eastman, rue Charles-Moureu, rue du Docteur-Magn;Cèdre bleu de l'Atlas;Glauca;24;Parc de Choisy
(48.8723867386, 2.27912885453);16;Zelkova;carpinifolia;Ulmaceae;1852;30.0;395.0;Avenue Foch;Faux orme de Sibérie;;29;Avenue Foch
(48.8619170093, 2.2924448277);16;Paulownia;tomentosa;Paulowniaceae;;20.0;420.0;Place du Trocad‚ro et du 11 Novembre, rue Benjamin Franklin, avenue Albert de Mun;Paulownia;;35;Jardin du Trocadéro
(48.8716117578, 2.24933653506);16;Araucaria;araucana;Araucariaceae;1907;9.0;140.0;Allée de Longchamp, route de Sèvres à Neuilly;Désespoir du singe;;39;Bois de Boulogne (Bagatelle)
(48.8691433358, 2.24587597613);16;Platanus;x acerifolia;Platanaceae;1847;40.0;480.0;Allée de Longchamp, route de Sèvres à Neuilly;Platane commun;;40;Bois de Boulogne (Bagatelle)
(48.8661956075, 2.26238964912);16;Platanus;orientalis;Platanaceae;1859;25.0;375.0;Ile du lac inférieur;Platane d'Orient;;49;Bois de Boulogne (île du lac inférieur)
(48.8215800145, 2.45494779675);12;Zelkova;carpinifolia;Ulmaceae;;12.0;245.0;Route de la Ferme, route de la Pyramide;Faux orme de Sibérie;;50;Arboretum de Ecole du Breuil
(48.8727584235, 2.2873548507);16;Platanus;x acerifolia;Platanaceae;1852;30.0;525.0;Avenue Foch;Platane commun;;55;Avenue Foch
(48.8588189763, 2.25832952119);16;Magnolia;grandiflora;Magnoliaceae;1863;12.0;;Allée de Longchamp, carrefour des cascades;Magnolia à grandes fleurs;;66;Bois de Boulogne (Berge du lac inférieur)
(48.86260617, 2.23782412563);16;Zelkova;carpinifolia;Ulmaceae;1896;16.0;260.0;;Faux orme de Sibérie;;75;Bois de Boulogne (Moulin de Longchamp)
(48.8395160905, 2.43350820893);12;Platanus;x acerifolia;Platanaceae;1918;32.0;570.0;avenue Daumesnil, Esplanade du Château de Vincennes;Platane commun;;82;Bois de Vincennes (Square Carnot)
(48.833545551, 2.41033694606);12;Platanus;orientalis;Platanaceae;1860;22.0;475.0;route de la ceinture du Lac Daumesnil;Platane d'Orient;;86;Bois de Vincennes (Lac Daumesnil/porte Dorée)
(48.8302532096, 2.41400587444);12;Acer;opalus;Sapindaceae;1870;15.0;160.0;Ile de Bercy;Erable d'Italie;;91;Bois de Vincennes (Ile de Bercy)
```

## 1.8.1 Districts containing trees (very easy)

```bash
yarn jar hadoop-examples-mapreduce.jar districts /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Districtscontainingtrees
24/07/16 18:07:17 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:07:17 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146037840, maxDate=1721750837840, sequenceNumber=2097, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:07:17 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146037906, maxDate=1721750837906, sequenceNumber=1960, masterKeyId=10))
24/07/16 18:07:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146037840, maxDate=1721750837840, sequenceNumber=2097, masterKeyId=23)
24/07/16 18:07:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146037906, maxDate=1721750837906, sequenceNumber=1960, masterKeyId=10)
24/07/16 18:07:18 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
24/07/16 18:07:18 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1247
24/07/16 18:07:18 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:07:18 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:07:18 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1247
24/07/16 18:07:18 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146037906, maxDate=1721750837906, sequenceNumber=1960, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146037840, maxDate=1721750837840, sequenceNumber=2097, masterKeyId=23)]
24/07/16 18:07:18 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:07:18 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:07:19 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1247
24/07/16 18:07:19 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1247/
24/07/16 18:07:19 INFO mapreduce.Job: Running job: job_1720701352744_1247
24/07/16 18:07:25 INFO mapreduce.Job: Job job_1720701352744_1247 running in uber mode : false
24/07/16 18:07:25 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:07:31 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:07:37 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:07:37 INFO mapreduce.Job: Job job_1720701352744_1247 completed successfully
24/07/16 18:07:37 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=477
		FILE: Number of bytes written=613803
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=44
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11514
		Total time spent by all reduces in occupied slots (ms)=14912
		Total time spent by all map tasks (ms)=3838
		Total time spent by all reduce tasks (ms)=3728
		Total vcore-milliseconds taken by all map tasks=3838
		Total vcore-milliseconds taken by all reduce tasks=3728
		Total megabyte-milliseconds taken by all map tasks=5895168
		Total megabyte-milliseconds taken by all reduce tasks=7634944
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=277
		Map output materialized bytes=477
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=477
		Reduce input records=97
		Reduce output records=17
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=61
		CPU time spent (ms)=1030
		Physical memory (bytes) snapshot=1544560640
		Virtual memory (bytes) snapshot=6700625920
		Total committed heap usage (bytes)=1615855616
		Peak Map Physical memory (bytes)=1196998656
		Peak Map Virtual memory (bytes)=3110113280
		Peak Reduce Physical memory (bytes)=347561984
		Peak Reduce Virtual memory (bytes)=3590512640
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=44
```

```bash
hdfs dfs -ls
Found 18 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 .staging
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   59487283 2024-07-16 18:06 hadoop-examples-mapreduce.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:49 output-districts
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio      16680 2024-07-16 17:59 trees.csv
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt

hdfs dfs -ls Districtscontainingtrees
Found 2 items
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees/_SUCCESS
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio         44 2024-07-16 18:07 Districtscontainingtrees/part-r-00000

hdfs dfs -cat Districtscontainingtrees/part-r-00000
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9
```

## 1.8.2 Show all existing species (very easy)

```bash
yarn jar hadoop-examples-mapreduce.jar species /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Showallexistingspecies
24/07/16 18:09:55 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:09:55 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146195547, maxDate=1721750995547, sequenceNumber=2098, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:09:55 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146195604, maxDate=1721750995604, sequenceNumber=1961, masterKeyId=10))
24/07/16 18:09:55 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146195547, maxDate=1721750995547, sequenceNumber=2098, masterKeyId=23)
24/07/16 18:09:55 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146195604, maxDate=1721750995604, sequenceNumber=1961, masterKeyId=10)
24/07/16 18:09:55 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
24/07/16 18:09:55 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1248
24/07/16 18:09:56 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:09:56 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:09:56 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1248
24/07/16 18:09:56 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146195604, maxDate=1721750995604, sequenceNumber=1961, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146195547, maxDate=1721750995547, sequenceNumber=2098, masterKeyId=23)]
24/07/16 18:09:56 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:09:56 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:09:56 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1248
24/07/16 18:09:56 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1248/
24/07/16 18:09:56 INFO mapreduce.Job: Running job: job_1720701352744_1248
24/07/16 18:10:02 INFO mapreduce.Job: Job job_1720701352744_1248 running in uber mode : false
24/07/16 18:10:02 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:10:08 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:10:11 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:10:12 INFO mapreduce.Job: Job job_1720701352744_1248 completed successfully
24/07/16 18:10:13 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=1195
		FILE: Number of bytes written=615225
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=451
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11202
		Total time spent by all reduces in occupied slots (ms)=5332
		Total time spent by all map tasks (ms)=3734
		Total time spent by all reduce tasks (ms)=1333
		Total vcore-milliseconds taken by all map tasks=3734
		Total vcore-milliseconds taken by all reduce tasks=1333
		Total megabyte-milliseconds taken by all map tasks=5735424
		Total megabyte-milliseconds taken by all reduce tasks=2729984
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=995
		Map output materialized bytes=1195
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=45
		Reduce shuffle bytes=1195
		Reduce input records=97
		Reduce output records=45
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=66
		CPU time spent (ms)=1030
		Physical memory (bytes) snapshot=1551020032
		Virtual memory (bytes) snapshot=6701785088
		Total committed heap usage (bytes)=1609039872
		Peak Map Physical memory (bytes)=1198899200
		Peak Map Virtual memory (bytes)=3111424000
		Peak Reduce Physical memory (bytes)=352120832
		Peak Reduce Virtual memory (bytes)=3590361088
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=451
```

```bash
hdfs dfs -ls
Found 19 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 .staging
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 Showallexistingspecies
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   59487283 2024-07-16 18:06 hadoop-examples-mapreduce.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:49 output-districts
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio      16680 2024-07-16 17:59 trees.csv
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt

hdfs dfs -ls Showallexistingspecies
Found 2 items
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 Showallexistingspecies/_SUCCESS
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        451 2024-07-16 18:10 Showallexistingspecies/part-r-00000

hdfs dfs -cat Showallexistingspecies/part-r-00000
araucana
atlantica
australis
baccata
bignonioides
biloba
bungeana
cappadocicum
carpinifolia
colurna
coulteri
decurrens
dioicus
distichum
excelsior
fraxinifolia
giganteum
giraldii
glutinosa
grandiflora
hippocastanum
ilex
involucrata
japonicum
kaki
libanii
monspessulanum
nigra
nigra laricio
opalus
orientalis
papyrifera
petraea
pomifera
pseudoacacia
sempervirens
serrata
stenoptera
suber
sylvatica
tomentosa
tulipifera
ulmoides
virginiana
x acerifolia
```

## 1.8.3 Number of trees by kinds (very easy)

```bash
yarn jar hadoop-examples-mapreduce.jar treesbyspecies /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Numberoftreesbykinds
24/07/16 18:12:17 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:12:17 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146337252, maxDate=1721751137252, sequenceNumber=2099, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:12:17 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146337315, maxDate=1721751137315, sequenceNumber=1962, masterKeyId=10))
24/07/16 18:12:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146337252, maxDate=1721751137252, sequenceNumber=2099, masterKeyId=23)
24/07/16 18:12:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146337315, maxDate=1721751137315, sequenceNumber=1962, masterKeyId=10)
24/07/16 18:12:17 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
24/07/16 18:12:17 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1249
24/07/16 18:12:17 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:12:17 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:12:17 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1249
24/07/16 18:12:17 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721146337315, maxDate=1721751137315, sequenceNumber=1962, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721146337252, maxDate=1721751137252, sequenceNumber=2099, masterKeyId=23)]
24/07/16 18:12:17 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:12:17 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:12:18 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1249
24/07/16 18:12:18 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1249/
24/07/16 18:12:18 INFO mapreduce.Job: Running job: job_1720701352744_1249
24/07/16 18:12:24 INFO mapreduce.Job: Job job_1720701352744_1249 running in uber mode : false
24/07/16 18:12:24 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:12:30 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:12:36 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:12:36 INFO mapreduce.Job: Job job_1720701352744_1249 completed successfully
24/07/16 18:12:36 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=1583
		FILE: Number of bytes written=616025
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=542
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11565
		Total time spent by all reduces in occupied slots (ms)=15016
		Total time spent by all map tasks (ms)=3855
		Total time spent by all reduce tasks (ms)=3754
		Total vcore-milliseconds taken by all map tasks=3855
		Total vcore-milliseconds taken by all reduce tasks=3754
		Total megabyte-milliseconds taken by all map tasks=5921280
		Total megabyte-milliseconds taken by all reduce tasks=7688192
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=1383
		Map output materialized bytes=1583
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=45
		Reduce shuffle bytes=1583
		Reduce input records=97
		Reduce output records=45
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=64
		CPU time spent (ms)=1030
		Physical memory (bytes) snapshot=1528938496
		Virtual memory (bytes) snapshot=6704775168
		Total committed heap usage (bytes)=1536163840
		Peak Map Physical memory (bytes)=1191686144
		Peak Map Virtual memory (bytes)=3113013248
		Peak Reduce Physical memory (bytes)=337252352
		Peak Reduce Virtual memory (bytes)=3591761920
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=542
```

```bash
hdfs dfs -ls
Found 20 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:12 .staging
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:12 Numberoftreesbykinds
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 Showallexistingspecies
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   59487283 2024-07-16 18:06 hadoop-examples-mapreduce.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:49 output-districts
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio      16680 2024-07-16 17:59 trees.csv
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt

hdfs dfs -ls Numberoftreesbykinds
Found 2 items
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:12 Numberoftreesbykinds/_SUCCESS
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        542 2024-07-16 18:12 Numberoftreesbykinds/part-r-00000

hdfs dfs -cat Numberoftreesbykinds/part-r-00000
araucana	1
atlantica	2
australis	1
baccata	2
bignonioides	1
biloba	5
bungeana	1
cappadocicum	1
carpinifolia	4
colurna	3
coulteri	1
decurrens	1
dioicus	1
distichum	3
excelsior	1
fraxinifolia	2
giganteum	5
giraldii	1
glutinosa	1
grandiflora	1
hippocastanum	3
ilex	1
involucrata	1
japonicum	1
kaki	2
libanii	2
monspessulanum	1
nigra	3
nigra laricio	1
opalus	1
orientalis	8
papyrifera	1
petraea	2
pomifera	1
pseudoacacia	1
sempervirens	1
serrata	1
stenoptera	1
suber	1
sylvatica	8
tomentosa	2
tulipifera	2
ulmoides	1
virginiana	2
x acerifolia	11
```

## 1.8.4 Maximum heigt per kind of tree (average)

```bash
yarn jar hadoop-examples-mapreduce.jar maxheight /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Maximumheightperkindoftree
24/07/16 18:53:59 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:53:59 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148839895, maxDate=1721753639895, sequenceNumber=2101, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:53:59 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148839954, maxDate=1721753639954, sequenceNumber=1964, masterKeyId=10))
24/07/16 18:53:59 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148839895, maxDate=1721753639895, sequenceNumber=2101, masterKeyId=23)
24/07/16 18:53:59 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148839954, maxDate=1721753639954, sequenceNumber=1964, masterKeyId=10)
24/07/16 18:54:00 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1250
24/07/16 18:54:00 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:54:00 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:54:00 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1250
24/07/16 18:54:00 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148839954, maxDate=1721753639954, sequenceNumber=1964, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148839895, maxDate=1721753639895, sequenceNumber=2101, masterKeyId=23)]
24/07/16 18:54:00 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:54:00 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:54:01 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1250
24/07/16 18:54:01 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1250/
24/07/16 18:54:01 INFO mapreduce.Job: Running job: job_1720701352744_1250
24/07/16 18:54:07 INFO mapreduce.Job: Job job_1720701352744_1250 running in uber mode : false
24/07/16 18:54:07 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:54:13 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:54:20 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:54:20 INFO mapreduce.Job: Job job_1720701352744_1250 completed successfully
24/07/16 18:54:20 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=727
		FILE: Number of bytes written=615051
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=675
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11856
		Total time spent by all reduces in occupied slots (ms)=15124
		Total time spent by all map tasks (ms)=3952
		Total time spent by all reduce tasks (ms)=3781
		Total vcore-milliseconds taken by all map tasks=3952
		Total vcore-milliseconds taken by all reduce tasks=3781
		Total megabyte-milliseconds taken by all map tasks=6070272
		Total megabyte-milliseconds taken by all reduce tasks=7743488
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=1369
		Map output materialized bytes=727
		Input split bytes=118
		Combine input records=96
		Combine output records=45
		Reduce input groups=45
		Reduce shuffle bytes=727
		Reduce input records=45
		Reduce output records=45
		Spilled Records=90
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=66
		CPU time spent (ms)=1080
		Physical memory (bytes) snapshot=1529655296
		Virtual memory (bytes) snapshot=6704599040
		Total committed heap usage (bytes)=1528299520
		Peak Map Physical memory (bytes)=1193373696
		Peak Map Virtual memory (bytes)=3111313408
		Peak Reduce Physical memory (bytes)=336281600
		Peak Reduce Virtual memory (bytes)=3593285632
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=675
```

```bash
hdfs dfs -ls
Found 21 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:54 .staging
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:54 Maximumheightperkindoftree
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:12 Numberoftreesbykinds
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 Showallexistingspecies
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   59487283 2024-07-16 18:06 hadoop-examples-mapreduce.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:49 output-districts
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio      16680 2024-07-16 17:59 trees.csv
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt

hdfs dfs -ls Maximumheightperkindoftree
Found 2 items
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:54 Maximumheightperkindoftree/_SUCCESS
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        675 2024-07-16 18:54 Maximumheightperkindoftree/part-r-00000

hdfs dfs -cat Maximumheightperkindoftree/part-r-00000
araucana	9.0
atlantica	25.0
australis	16.0
baccata	13.0
bignonioides	15.0
biloba	33.0
bungeana	10.0
cappadocicum	16.0
carpinifolia	30.0
colurna	20.0
coulteri	14.0
decurrens	20.0
dioicus	10.0
distichum	35.0
excelsior	30.0
fraxinifolia	27.0
giganteum	35.0
giraldii	35.0
glutinosa	16.0
grandiflora	12.0
hippocastanum	30.0
ilex	15.0
involucrata	12.0
japonicum	10.0
kaki	14.0
libanii	30.0
monspessulanum	12.0
nigra	30.0
nigra laricio	30.0
opalus	15.0
orientalis	34.0
papyrifera	12.0
petraea	31.0
pomifera	13.0
pseudoacacia	11.0
sempervirens	30.0
serrata	18.0
stenoptera	30.0
suber	10.0
sylvatica	30.0
tomentosa	20.0
tulipifera	35.0
ulmoides	12.0
virginiana	14.0
x acerifolia	45.0
```

## 1.8.5 Sort the trees height from smallest to largest

```bash
yarn jar hadoop-examples-mapreduce.jar sortheight /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Sortthetreesheightfromsmallesttolargest
24/07/16 18:56:17 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:56:17 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148977661, maxDate=1721753777661, sequenceNumber=2102, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:56:17 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148977727, maxDate=1721753777727, sequenceNumber=1965, masterKeyId=10))
24/07/16 18:56:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148977661, maxDate=1721753777661, sequenceNumber=2102, masterKeyId=23)
24/07/16 18:56:17 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148977727, maxDate=1721753777727, sequenceNumber=1965, masterKeyId=10)
24/07/16 18:56:17 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1251
24/07/16 18:56:18 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:56:18 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:56:18 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1251
24/07/16 18:56:18 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721148977727, maxDate=1721753777727, sequenceNumber=1965, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721148977661, maxDate=1721753777661, sequenceNumber=2102, masterKeyId=23)]
24/07/16 18:56:18 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:56:18 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:56:18 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1251
24/07/16 18:56:19 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1251/
24/07/16 18:56:19 INFO mapreduce.Job: Running job: job_1720701352744_1251
24/07/16 18:56:25 INFO mapreduce.Job: Job job_1720701352744_1251 running in uber mode : false
24/07/16 18:56:25 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:56:31 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:56:34 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:56:34 INFO mapreduce.Job: Job job_1720701352744_1251 completed successfully
24/07/16 18:56:34 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=4100
		FILE: Number of bytes written=622155
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=3994
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11412
		Total time spent by all reduces in occupied slots (ms)=5624
		Total time spent by all map tasks (ms)=3804
		Total time spent by all reduce tasks (ms)=1406
		Total vcore-milliseconds taken by all map tasks=3804
		Total vcore-milliseconds taken by all reduce tasks=1406
		Total megabyte-milliseconds taken by all map tasks=5842944
		Total megabyte-milliseconds taken by all reduce tasks=2879488
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=3902
		Map output materialized bytes=4100
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=28
		Reduce shuffle bytes=4100
		Reduce input records=96
		Reduce output records=96
		Spilled Records=192
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=65
		CPU time spent (ms)=1060
		Physical memory (bytes) snapshot=1537863680
		Virtual memory (bytes) snapshot=6698692608
		Total committed heap usage (bytes)=1548222464
		Peak Map Physical memory (bytes)=1198743552
		Peak Map Virtual memory (bytes)=3111526400
		Peak Reduce Physical memory (bytes)=339120128
		Peak Reduce Virtual memory (bytes)=3587166208
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=3994
```

```bash
hdfs dfs -ls
Found 22 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:43 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:56 .staging
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:07 Districtscontainingtrees
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:54 Maximumheightperkindoftree
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:12 Numberoftreesbykinds
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:10 Showallexistingspecies
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:56 Sortthetreesheightfromsmallesttolargest
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio   59487283 2024-07-16 18:06 hadoop-examples-mapreduce.jar
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 17:49 output-districts
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio      16680 2024-07-16 17:59 trees.csv
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 17:10 user
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt

hdfs dfs -ls Sortthetreesheightfromsmallesttolargest
Found 2 items
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-16 18:56 Sortthetreesheightfromsmallesttolargest/_SUCCESS
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       3994 2024-07-16 18:56 Sortthetreesheightfromsmallesttolargest/part-r-00000

hdfs dfs -cat Sortthetreesheightfromsmallesttolargest/part-r-00000
3 - Fagus sylvatica (Fagaceae)	2.0
89 - Taxus baccata (Taxaceae)	5.0
62 - Cedrus atlantica (Pinaceae)	6.0
39 - Araucaria araucana (Araucariaceae)	9.0
44 - Styphnolobium japonicum (Fabaceae)	10.0
32 - Quercus suber (Fagaceae)	10.0
95 - Pinus bungeana (Pinaceae)	10.0
61 - Gymnocladus dioicus (Fabaceae)	10.0
63 - Fagus sylvatica (Fagaceae)	10.0
4 - Robinia pseudoacacia (Fabaceae)	11.0
93 - Diospyros virginiana (Ebenaceae)	12.0
66 - Magnolia grandiflora (Magnoliaceae)	12.0
50 - Zelkova carpinifolia (Ulmaceae)	12.0
7 - Eucommia ulmoides (Eucomiaceae)	12.0
48 - Acer monspessulanum (Sapindacaees)	12.0
58 - Diospyros kaki (Ebenaceae)	12.0
33 - Broussonetia papyrifera (Moraceae)	12.0
71 - Davidia involucrata (Cornaceae)	12.0
36 - Taxus baccata (Taxaceae)	13.0
6 - Maclura pomifera (Moraceae)	13.0
68 - Diospyros kaki (Ebenaceae)	14.0
96 - Pinus coulteri (Pinaceae)	14.0
94 - Diospyros virginiana (Ebenaceae)	14.0
91 - Acer opalus (Sapindaceae)	15.0
5 - Catalpa bignonioides (Bignoniaceae)	15.0
70 - Fagus sylvatica (Fagaceae)	15.0
2 - Ulmus carpinifolia (Ulmaceae)	15.0
98 - Quercus ilex (Fagaceae)	15.0
28 - Alnus glutinosa (Betulaceae)	16.0
78 - Acer cappadocicum (Sapindaceae)	16.0
75 - Zelkova carpinifolia (Ulmaceae)	16.0
16 - Celtis australis (Cannabaceae)	16.0
64 - Ginkgo biloba (Ginkgoaceae)	18.0
83 - Zelkova serrata (Ulmaceae)	18.0
23 - Aesculus hippocastanum (Sapindaceae)	18.0
60 - Fagus sylvatica (Fagaceae)	18.0
34 - Corylus colurna (Betulaceae)	20.0
51 - Platanus x acerifolia (Platanaceae)	20.0
43 - Tilia tomentosa (Malvaceae)	20.0
15 - Corylus colurna (Betulaceae)	20.0
11 - Calocedrus decurrens (Cupressaceae)	20.0
1 - Corylus colurna (Betulaceae)	20.0
8 - Platanus orientalis (Platanaceae)	20.0
20 - Fagus sylvatica (Fagaceae)	20.0
35 - Paulownia tomentosa (Paulowniaceae)	20.0
12 - Sequoiadendron giganteum (Taxodiaceae)	20.0
87 - Taxodium distichum (Taxodiaceae)	20.0
13 - Platanus orientalis (Platanaceae)	20.0
10 - Ginkgo biloba (Ginkgoaceae)	22.0
47 - Aesculus hippocastanum (Sapindaceae)	22.0
86 - Platanus orientalis (Platanaceae)	22.0
14 - Pterocarya fraxinifolia (Juglandaceae)	22.0
88 - Liriodendron tulipifera (Magnoliaceae)	22.0
18 - Fagus sylvatica (Fagaceae)	23.0
24 - Cedrus atlantica (Pinaceae)	25.0
31 - Ginkgo biloba (Ginkgoaceae)	25.0
92 - Platanus x acerifolia (Platanaceae)	25.0
49 - Platanus orientalis (Platanaceae)	25.0
97 - Pinus nigra (Pinaceae)	25.0
84 - Ginkgo biloba (Ginkgoaceae)	25.0
73 - Platanus orientalis (Platanaceae)	26.0
65 - Pterocarya fraxinifolia (Juglandaceae)	27.0
42 - Platanus orientalis (Platanaceae)	27.0
85 - Juglans nigra (Juglandaceae)	28.0
76 - Pinus nigra laricio (Pinaceae)	30.0
19 - Quercus petraea (Fagaceae)	30.0
72 - Sequoiadendron giganteum (Taxodiaceae)	30.0
54 - Pterocarya stenoptera (Juglandaceae)	30.0
29 - Zelkova carpinifolia (Ulmaceae)	30.0
27 - Sequoia sempervirens (Taxodiaceae)	30.0
25 - Fagus sylvatica (Fagaceae)	30.0
41 - Platanus x acerifolia (Platanaceae)	30.0
77 - Taxodium distichum (Taxodiaceae)	30.0
55 - Platanus x acerifolia (Platanaceae)	30.0
69 - Pinus nigra (Pinaceae)	30.0
38 - Fagus sylvatica (Fagaceae)	30.0
59 - Sequoiadendron giganteum (Taxodiaceae)	30.0
52 - Fraxinus excelsior (Oleaceae)	30.0
37 - Cedrus libanii (Pinaceae)	30.0
22 - Cedrus libanii (Pinaceae)	30.0
30 - Aesculus hippocastanum (Sapindaceae)	30.0
80 - Quercus petraea (Fagaceae)	31.0
9 - Platanus orientalis (Platanaceae)	31.0
82 - Platanus x acerifolia (Platanaceae)	32.0
46 - Ginkgo biloba (Ginkgoaceae)	33.0
45 - Platanus orientalis (Platanaceae)	34.0
56 - Taxodium distichum (Taxodiaceae)	35.0
81 - Liriodendron tulipifera (Magnoliaceae)	35.0
17 - Platanus x acerifolia (Platanaceae)	35.0
53 - Ailanthus giraldii (Simaroubaceae)	35.0
57 - Sequoiadendron giganteum (Taxodiaceae)	35.0
26 - Platanus x acerifolia (Platanaceae)	40.0
74 - Platanus x acerifolia (Platanaceae)	40.0
40 - Platanus x acerifolia (Platanaceae)	40.0
90 - Platanus x acerifolia (Platanaceae)	42.0
21 - Platanus x acerifolia (Platanaceae)	45.0
```

## 1.8.6 District containing the oldest tree (difficult)


```bash
yarn jar hadoop-examples-mapreduce.jar oldesttree /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Districtcontainingtheoldesttree
24/07/16 18:59:28 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 18:59:28 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149168562, maxDate=1721753968562, sequenceNumber=2103, masterKeyId=23 on ha-hdfs:efrei
24/07/16 18:59:28 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149168630, maxDate=1721753968630, sequenceNumber=1966, masterKeyId=10))
24/07/16 18:59:28 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149168562, maxDate=1721753968562, sequenceNumber=2103, masterKeyId=23)
24/07/16 18:59:28 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149168630, maxDate=1721753968630, sequenceNumber=1966, masterKeyId=10)
24/07/16 18:59:28 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1252
24/07/16 18:59:29 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 18:59:29 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 18:59:29 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1252
24/07/16 18:59:29 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149168630, maxDate=1721753968630, sequenceNumber=1966, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149168562, maxDate=1721753968562, sequenceNumber=2103, masterKeyId=23)]
24/07/16 18:59:29 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 18:59:29 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 18:59:29 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1252
24/07/16 18:59:29 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1252/
24/07/16 18:59:29 INFO mapreduce.Job: Running job: job_1720701352744_1252
24/07/16 18:59:35 INFO mapreduce.Job: Job job_1720701352744_1252 running in uber mode : false
24/07/16 18:59:35 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 18:59:41 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 18:59:46 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 18:59:46 INFO mapreduce.Job: Job job_1720701352744_1252 completed successfully
24/07/16 18:59:46 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=1315
		FILE: Number of bytes written=616609
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=7
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11511
		Total time spent by all reduces in occupied slots (ms)=5792
		Total time spent by all map tasks (ms)=3837
		Total time spent by all reduce tasks (ms)=1448
		Total vcore-milliseconds taken by all map tasks=3837
		Total vcore-milliseconds taken by all reduce tasks=1448
		Total megabyte-milliseconds taken by all map tasks=5893632
		Total megabyte-milliseconds taken by all reduce tasks=2965504
	Map-Reduce Framework
		Map input records=98
		Map output records=77
		Map output bytes=1155
		Map output materialized bytes=1315
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=1315
		Reduce input records=77
		Reduce output records=1
		Spilled Records=154
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=69
		CPU time spent (ms)=1060
		Physical memory (bytes) snapshot=1536438272
		Virtual memory (bytes) snapshot=6701989888
		Total committed heap usage (bytes)=1524105216
		Peak Map Physical memory (bytes)=1198026752
		Peak Map Virtual memory (bytes)=3110998016
		Peak Reduce Physical memory (bytes)=338411520
		Peak Reduce Virtual memory (bytes)=3590991872
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=7
```

```bash
hdfs dfs -cat Sortthetreesheightfromsmallesttolargest/part-r-00000
3 - Fagus sylvatica (Fagaceae)	2.0
89 - Taxus baccata (Taxaceae)	5.0
62 - Cedrus atlantica (Pinaceae)	6.0
39 - Araucaria araucana (Araucariaceae)	9.0
44 - Styphnolobium japonicum (Fabaceae)	10.0
32 - Quercus suber (Fagaceae)	10.0
95 - Pinus bungeana (Pinaceae)	10.0
61 - Gymnocladus dioicus (Fabaceae)	10.0
63 - Fagus sylvatica (Fagaceae)	10.0
4 - Robinia pseudoacacia (Fabaceae)	11.0
93 - Diospyros virginiana (Ebenaceae)	12.0
66 - Magnolia grandiflora (Magnoliaceae)	12.0
50 - Zelkova carpinifolia (Ulmaceae)	12.0
7 - Eucommia ulmoides (Eucomiaceae)	12.0
48 - Acer monspessulanum (Sapindacaees)	12.0
58 - Diospyros kaki (Ebenaceae)	12.0
33 - Broussonetia papyrifera (Moraceae)	12.0
71 - Davidia involucrata (Cornaceae)	12.0
36 - Taxus baccata (Taxaceae)	13.0
6 - Maclura pomifera (Moraceae)	13.0
68 - Diospyros kaki (Ebenaceae)	14.0
96 - Pinus coulteri (Pinaceae)	14.0
94 - Diospyros virginiana (Ebenaceae)	14.0
91 - Acer opalus (Sapindaceae)	15.0
5 - Catalpa bignonioides (Bignoniaceae)	15.0
70 - Fagus sylvatica (Fagaceae)	15.0
2 - Ulmus carpinifolia (Ulmaceae)	15.0
98 - Quercus ilex (Fagaceae)	15.0
28 - Alnus glutinosa (Betulaceae)	16.0
78 - Acer cappadocicum (Sapindaceae)	16.0
75 - Zelkova carpinifolia (Ulmaceae)	16.0
16 - Celtis australis (Cannabaceae)	16.0
64 - Ginkgo biloba (Ginkgoaceae)	18.0
83 - Zelkova serrata (Ulmaceae)	18.0
23 - Aesculus hippocastanum (Sapindaceae)	18.0
60 - Fagus sylvatica (Fagaceae)	18.0
34 - Corylus colurna (Betulaceae)	20.0
51 - Platanus x acerifolia (Platanaceae)	20.0
43 - Tilia tomentosa (Malvaceae)	20.0
15 - Corylus colurna (Betulaceae)	20.0
11 - Calocedrus decurrens (Cupressaceae)	20.0
1 - Corylus colurna (Betulaceae)	20.0
8 - Platanus orientalis (Platanaceae)	20.0
20 - Fagus sylvatica (Fagaceae)	20.0
35 - Paulownia tomentosa (Paulowniaceae)	20.0
12 - Sequoiadendron giganteum (Taxodiaceae)	20.0
87 - Taxodium distichum (Taxodiaceae)	20.0
13 - Platanus orientalis (Platanaceae)	20.0
10 - Ginkgo biloba (Ginkgoaceae)	22.0
47 - Aesculus hippocastanum (Sapindaceae)	22.0
86 - Platanus orientalis (Platanaceae)	22.0
14 - Pterocarya fraxinifolia (Juglandaceae)	22.0
88 - Liriodendron tulipifera (Magnoliaceae)	22.0
18 - Fagus sylvatica (Fagaceae)	23.0
24 - Cedrus atlantica (Pinaceae)	25.0
31 - Ginkgo biloba (Ginkgoaceae)	25.0
92 - Platanus x acerifolia (Platanaceae)	25.0
49 - Platanus orientalis (Platanaceae)	25.0
97 - Pinus nigra (Pinaceae)	25.0
84 - Ginkgo biloba (Ginkgoaceae)	25.0
73 - Platanus orientalis (Platanaceae)	26.0
65 - Pterocarya fraxinifolia (Juglandaceae)	27.0
42 - Platanus orientalis (Platanaceae)	27.0
85 - Juglans nigra (Juglandaceae)	28.0
76 - Pinus nigra laricio (Pinaceae)	30.0
19 - Quercus petraea (Fagaceae)	30.0
72 - Sequoiadendron giganteum (Taxodiaceae)	30.0
54 - Pterocarya stenoptera (Juglandaceae)	30.0
29 - Zelkova carpinifolia (Ulmaceae)	30.0
27 - Sequoia sempervirens (Taxodiaceae)	30.0
25 - Fagus sylvatica (Fagaceae)	30.0
41 - Platanus x acerifolia (Platanaceae)	30.0
77 - Taxodium distichum (Taxodiaceae)	30.0
55 - Platanus x acerifolia (Platanaceae)	30.0
69 - Pinus nigra (Pinaceae)	30.0
38 - Fagus sylvatica (Fagaceae)	30.0
59 - Sequoiadendron giganteum (Taxodiaceae)	30.0
52 - Fraxinus excelsior (Oleaceae)	30.0
37 - Cedrus libanii (Pinaceae)	30.0
22 - Cedrus libanii (Pinaceae)	30.0
30 - Aesculus hippocastanum (Sapindaceae)	30.0
80 - Quercus petraea (Fagaceae)	31.0
9 - Platanus orientalis (Platanaceae)	31.0
82 - Platanus x acerifolia (Platanaceae)	32.0
46 - Ginkgo biloba (Ginkgoaceae)	33.0
45 - Platanus orientalis (Platanaceae)	34.0
56 - Taxodium distichum (Taxodiaceae)	35.0
81 - Liriodendron tulipifera (Magnoliaceae)	35.0
17 - Platanus x acerifolia (Platanaceae)	35.0
53 - Ailanthus giraldii (Simaroubaceae)	35.0
57 - Sequoiadendron giganteum (Taxodiaceae)	35.0
26 - Platanus x acerifolia (Platanaceae)	40.0
74 - Platanus x acerifolia (Platanaceae)	40.0
40 - Platanus x acerifolia (Platanaceae)	40.0
90 - Platanus x acerifolia (Platanaceae)	42.0
21 - Platanus x acerifolia (Platanaceae)	45.0
```

## 1.8.7 District containing the most trees (very difficult)

```bash
yarn jar hadoop-examples-mapreduce.jar maxtreedistrict /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/Districtcontainingthemosttrees
24/07/16 19:01:23 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 19:01:23 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149283212, maxDate=1721754083212, sequenceNumber=2105, masterKeyId=23 on ha-hdfs:efrei
24/07/16 19:01:23 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149283270, maxDate=1721754083270, sequenceNumber=1968, masterKeyId=10))
24/07/16 19:01:23 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149283212, maxDate=1721754083212, sequenceNumber=2105, masterKeyId=23)
24/07/16 19:01:23 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149283270, maxDate=1721754083270, sequenceNumber=1968, masterKeyId=10)
24/07/16 19:01:23 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
24/07/16 19:01:23 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1254
24/07/16 19:01:23 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 19:01:23 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 19:01:23 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1254
24/07/16 19:01:23 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149283270, maxDate=1721754083270, sequenceNumber=1968, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149283212, maxDate=1721754083212, sequenceNumber=2105, masterKeyId=23)]
24/07/16 19:01:23 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 19:01:23 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 19:01:24 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1254
24/07/16 19:01:24 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1254/
24/07/16 19:01:24 INFO mapreduce.Job: Running job: job_1720701352744_1254
24/07/16 19:01:30 INFO mapreduce.Job: Job job_1720701352744_1254 running in uber mode : false
24/07/16 19:01:30 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 19:01:36 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 19:01:39 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 19:01:39 INFO mapreduce.Job: Job job_1720701352744_1254 completed successfully
24/07/16 19:01:39 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=865
		FILE: Number of bytes written=614625
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=80
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11202
		Total time spent by all reduces in occupied slots (ms)=5504
		Total time spent by all map tasks (ms)=3734
		Total time spent by all reduce tasks (ms)=1376
		Total vcore-milliseconds taken by all map tasks=3734
		Total vcore-milliseconds taken by all reduce tasks=1376
		Total megabyte-milliseconds taken by all map tasks=5735424
		Total megabyte-milliseconds taken by all reduce tasks=2818048
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=665
		Map output materialized bytes=865
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=865
		Reduce input records=97
		Reduce output records=17
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=74
		CPU time spent (ms)=1010
		Physical memory (bytes) snapshot=1547870208
		Virtual memory (bytes) snapshot=6700769280
		Total committed heap usage (bytes)=1595932672
		Peak Map Physical memory (bytes)=1198960640
		Peak Map Virtual memory (bytes)=3113664512
		Peak Reduce Physical memory (bytes)=348909568
		Peak Reduce Virtual memory (bytes)=3587104768
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=80
```

```bash
hdfs dfs -cat Districtcontainingthemosttrees/part-r-00000
11	1
12	29
13	2
14	3
15	1
16	36
17	1
18	1
19	6
20	3
3	1
4	1
5	2
6	1
7	3
8	5
9	1
```

## 1.8.8 District containing the most trees (very difficult) - 2nd version

```bash
yarn jar hadoop-examples-mapreduce.jar maxtreedistrict2 /user/matthieu.freire.eleuterio/trees.csv /user/matthieu.freire.eleuterio/DistrictcontainingthemosttreesPhase2
24/07/16 19:02:35 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/16 19:02:35 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149355878, maxDate=1721754155878, sequenceNumber=2107, masterKeyId=23 on ha-hdfs:efrei
24/07/16 19:02:35 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149355936, maxDate=1721754155936, sequenceNumber=1970, masterKeyId=10))
24/07/16 19:02:35 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149355878, maxDate=1721754155878, sequenceNumber=2107, masterKeyId=23)
24/07/16 19:02:35 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149355936, maxDate=1721754155936, sequenceNumber=1970, masterKeyId=10)
24/07/16 19:02:36 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_1256
24/07/16 19:02:36 INFO input.FileInputFormat: Total input files to process : 1
24/07/16 19:02:36 INFO mapreduce.JobSubmitter: number of splits:1
24/07/16 19:02:36 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_1256
24/07/16 19:02:36 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1721149355936, maxDate=1721754155936, sequenceNumber=1970, masterKeyId=10), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1721149355878, maxDate=1721754155878, sequenceNumber=2107, masterKeyId=23)]
24/07/16 19:02:36 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/16 19:02:36 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/16 19:02:37 INFO impl.YarnClientImpl: Submitted application application_1720701352744_1256
24/07/16 19:02:37 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_1256/
24/07/16 19:02:37 INFO mapreduce.Job: Running job: job_1720701352744_1256
24/07/16 19:02:44 INFO mapreduce.Job: Job job_1720701352744_1256 running in uber mode : false
24/07/16 19:02:44 INFO mapreduce.Job:  map 0% reduce 0%
24/07/16 19:02:49 INFO mapreduce.Job:  map 100% reduce 0%
24/07/16 19:02:55 INFO mapreduce.Job:  map 100% reduce 100%
24/07/16 19:02:55 INFO mapreduce.Job: Job job_1720701352744_1256 completed successfully
24/07/16 19:02:55 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=976
		FILE: Number of bytes written=615195
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16798
		HDFS: Number of bytes written=6
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=11466
		Total time spent by all reduces in occupied slots (ms)=15124
		Total time spent by all map tasks (ms)=3822
		Total time spent by all reduce tasks (ms)=3781
		Total vcore-milliseconds taken by all map tasks=3822
		Total vcore-milliseconds taken by all reduce tasks=3781
		Total megabyte-milliseconds taken by all map tasks=5870592
		Total megabyte-milliseconds taken by all reduce tasks=7743488
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=776
		Map output materialized bytes=976
		Input split bytes=118
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=976
		Reduce input records=97
		Reduce output records=1
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=68
		CPU time spent (ms)=1090
		Physical memory (bytes) snapshot=1536139264
		Virtual memory (bytes) snapshot=6700277760
		Total committed heap usage (bytes)=1546649600
		Peak Map Physical memory (bytes)=1198977024
		Peak Map Virtual memory (bytes)=3111120896
		Peak Reduce Physical memory (bytes)=337162240
		Peak Reduce Virtual memory (bytes)=3589156864
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=16680
	File Output Format Counters
		Bytes Written=6
```

```bash
hdfs dfs -cat DistrictcontainingthemosttreesPhase2/part-r-00000
16	36
```
THANK YOU