package com.momalab.studlib.Speciality;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.momalab.studlib.Adapter.ModuleAdapter;
import com.momalab.studlib.Adapter.PagerAdapter;
import com.momalab.studlib.Contenent;
import com.momalab.studlib.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Physique extends AppCompatActivity implements SearchView.OnQueryTextListener, ModuleAdapter.ItemClickListener {

    private ModuleAdapter adapter;
    androidx.appcompat.widget.SearchView search;
    private String[] module;
    private ArrayList<String> a = new ArrayList<>();
    String[] gridList, uri, TDList, Turi, ExamList, ExamUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        search = findViewById(R.id.search_module);
        module = new String[]{"L1:S1:", "Mathematique 1/Analyse et algèbre", "Physique 1/Mécanique du point", "Chémie1/Structure de la matière", "Informatique 1", "Environnement"
                , "L1:S2:", "Mathematique 2/Analyse et algèbre 2", "Physique 2/Electricité", "Chémie2/Thermodynamique et cinétique chimique", "Informatique 2", "Energie renouvelable"
                , "L2:S3:", "Série et Equation differentielles", "Mécanique Analytique", "Vibrations et ondes", "Optique Géométrique et Physique", "TP MNP", "TP Optique Géométrique et Physique", "Méthodes Numériques et Programmation", "Cristallographie"
                , "L2:S4:", "Thermodynmique", "Fonction de la variable complexe", "Mécanique quantique", "Electromagnetisme", "TP Thérmodynamique", "Mécanique des fluides", "Electronique Générale", "Spéctroscopie"
                , "L3(Phy_Fondamentale):S5:", "Mécanique Quantique II", "Physique Statistique", "Relativité Restreinte", "Méthodes Mathématiques pour la Physique", "Ondes Electromagnétiques", "Physique Numérique", "Physique des Particules"
                , "L3:S6:", "Physique du Solide", "Physique Nucléaire", "Transfert de Chaleur", "Physique Atomique", "TP Physique Atomique", "TP de Spectroscopie/Optique Physique", "Nouveaux Matériaux", "éthique et déontologie"
                , "M1(Phys_Appl):S1:", "Physique des semi-conducteurs", "Spectroscopie atomique et moléculaire", "Physique statistique et mécanique quantique", "Base mathématiques pour la physique", "Technique de caractérisation analyse des matériaux I", "Traitement de signal", "Laser"
                , "M1(Phys_Appl):S2:", "Interaction rayonnementmatière", "Matériaux fonctionnels", "Physique des surfaces et interfaces", "Instrumentations et détecteurs", "Technique de caractérisation/analyse des matériaux II", "Traitement d’image", "Programmation et traitement de données scientifiques", "Physique des plasmas", "Éléments d’électrotechnique"
                , "M2(Phys_Appl):S1:", "Matériaux et énergie photovoltaïque", "Thermique appliquée", "Énergie éolienne", "Capteurs et métrologie", "Technique d’élaboration des matériaux (massif, couches minces)", "Gisement solaire", "TP Énergie photovoltaïque"};


        a.addAll(Arrays.asList(module));
        setRecyclerView();
        search.setImeOptions(EditorInfo.IME_ACTION_DONE);
        search.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.listOfmodule);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ModuleAdapter(a, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClickListener(int j) {
        switch (j) {
            case 1:///math1
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 2://phy1
                gridList = new String[]{"PhysI_Chap-I", "PhysI_Chap-II", "PhysI_Chap-III", "PhysI_Chap-IV", "phy arab 1", "phy arab 2", "phy FR 1", "phys FR 1", "Polycop"};
                uri = new String[]{"https://drive.google.com/open?id=1JEaSuT159v0AB5i0L4CJ4Ots6OIKmIEo", "https://drive.google.com/open?id=1WlW3HoHJfQTWXle4nNv7XeuNc-vL6OtI", "https://drive.google.com/open?id=1WEDYc8ZQ639UNvAqary2e4TQpgQChjDI", "https://drive.google.com/open?id=16VfubgG8vjAXD15fVo3Y8q1aw6gTFHbj", "https://drive.google.com/open?id=10Fwc47plql3VHVAL4Rt2Vr-Eoa2G5and", "https://drive.google.com/open?id=1cShdttDdC5jqE-Y9XSZMq5kKPyKs7YkD", "https://drive.google.com/open?id=1V-8OrtEXH-Vfnwzw0FBKMiIXhyKZY_M1", "https://drive.google.com/open?id=1rqjPASQTYO0Zj-b6bUj2pl7cFYElsEH4", "https://drive.google.com/open?id=1qNCEi_dUkYKFliEgwystDEZXc_N1HbOt"};
                TDList = new String[]{"TD+corr", "poly-TD"};
                Turi = new String[]{"https://drive.google.com/open?id=1p-uQsnkhJ1sQ3xL_tyB8ON5J4YH1dsqt", "https://drive.google.com/open?id=1nP_VvAQIAXuFZur6LaucA23z_PYohm-e"};
                ExamList = new String[]{"exam1+corr", "exam2", "exam3+corr", "exam4", "exam5", "Examen 2016+corr", "Examen Rattr+Corrigé Phys 1_ 1ère Année ST_08-09", "Examen+Corrigé Phys 1_ 1ère Année ST_07-08", "Examen+Corrigé Phys 1_ 1ère Année ST-SM_06-07", "interro physique 1", "rattrapage + corrigé de physique 1 ST", "solution"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1MtIEoaeXB0zalWfNOAEtOMAaBxAVGbKe", "https://drive.google.com/open?id=12UNiDzkDAKmrNFVmfwLlWzid6LuDISqf", "https://drive.google.com/open?id=1i6RIkTyGt_K0cfngOUvTN8k_zNCepMZN", "https://drive.google.com/open?id=1gDEaT7D0IDs1w5_re83kRYH9ydnoNcdd", "https://drive.google.com/open?id=1Sp6ZYhXOs68dFuX-X7sKNgQuDrzJHuYS", "https://drive.google.com/open?id=1DocwoKybYCil1Y-tuZn3yrILxdmQ8P9J", "https://drive.google.com/open?id=1ro8s2jFOQGkXJRrno5ycb5aFhMDM7Y6N", "https://drive.google.com/open?id=1uF0k6bMJopwgbDq9dgALX7TNJlJ9Heus", "https://drive.google.com/open?id=1q2QyyNzatYja_BySekTUcLv0ccp24qbN", "https://drive.google.com/open?id=16O-UCp2-tzb80CrFECpoLBU82eYIPMh_", "https://drive.google.com/open?id=1A36IkMTWowWsD8Wr2MpbKIM94GhojuII", "https://drive.google.com/open?id=1Jr15diILXn4FpARTo3khmSsewH6fAkZu"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 3://chemie1
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 4:///info
                gridList = new String[]{"info_generale_cours_sm", "Informatique_pour_debutants_FR-Extrait", "Organigramme"};
                uri = new String[]{"https://drive.google.com/open?id=1IRaQcf7LVJaBPr1oGAq_jxpwuYeXUCb4", "https://drive.google.com/open?id=12-Bt4OCK3RcqH2QyPAfDN1Gq9vrFgOQE", "https://drive.google.com/open?id=1M-G2htiKX1yHbUsmcpUrlKxZXr3E_LXp"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 5:///env
                gridList = new String[]{"Chapitre II", "Chapitre III", "Chapitre IV", "Chapitre V", "Chapitre VI ", "Chapitre VII"};
                uri = new String[]{"https://drive.google.com/open?id=1Bg997cY9kb71NGxqA5ca18f-roNaatpm", "https://drive.google.com/open?id=1VxHD_qoTzZZADDEPo4KYghTwc1rooTeP", "https://drive.google.com/open?id=1xiCKrqiq5AgfbRmjORq4VSAPJ4Sn3pxc", "https://drive.google.com/open?id=1_css3ig1kGFv5QjAwbJ4-bRCycdIX4eK", "https://drive.google.com/open?id=14BU_xVJlW4nzVKnU8_rZ1nZhfOmKJIbM", "https://drive.google.com/open?id=19S5O1qvEnxKJ9jiXCFAfOU_4fSgNkoEP"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 7:////math2
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 8:////phy2
                gridList = new String[]{"Chap-I", "Chap-II", "Chap-III", "Chap-IV", "Conduteurs en équilibre-AR", "cours +exercices +examen  electrostatique ", "Electrocinétique_AR", "Electromagnétisme_AR", "Electrostatique_AR", "Electrostatique_et_electrocinetique", ""};
                uri = new String[]{"https://drive.google.com/open?id=1CgPEaTdMvDHFp15ZhZMQzvmdNmkc5rMk", "https://drive.google.com/open?id=1cnMToyY70pTvRZKHNNd9O9GzK3q3_mgY", "https://drive.google.com/open?id=1nvY8Oy3MdsXy6oubkHapLUgVmuDhAx_p", "https://drive.google.com/open?id=1JmcxqUiNnSf8KOcjgSuAOf2MsN65jviW", "https://drive.google.com/open?id=1zB3N4XSvIuxGO3dkcqzkgIrwFUAh2c0v", "https://drive.google.com/open?id=1o5igSurmkCS6kCjq4GBNd_EveHRtcJVq", "https://drive.google.com/open?id=1LZOn9R3W0XOV_bbLGeYLJ5ZEDHHFRlmD", "https://drive.google.com/open?id=1Nvp1SATSDseZvWIgbGQhZij7WoVge3AX", "https://drive.google.com/open?id=1mPA-kwKEscWP9jYltkwU2vTObeDX9A2s", "https://drive.google.com/open?id=1NV2y6KSkNlBgEFDiA75gQ6lUehyWVYgA"};
                TDList = new String[]{"série 1 ", "série 2 ", "série 3 ", "série 4 ", "série 5 ", "les series+solution elec s2", "TD corriges de Electrostatique", "TDelectrostatique"};
                Turi = new String[]{"https://drive.google.com/open?id=157wd5ngSTFsLgMCujQsHUqogYz7xdP1I", "https://drive.google.com/open?id=1S9wnx_N2W_myfubitknFhbba6IX4-OlL", "https://drive.google.com/open?id=1T9SpmBZoqt2J1Lbi4HG1TbUnnT7IgLHa", "https://drive.google.com/open?id=1MqFBG3B9Dw1MK1tPmMgRtP1v-H6Ct86w", "https://drive.google.com/open?id=19ZyhOH_3bebT58rwe3B_Fd4Cxqu2d5BT", "https://drive.google.com/open?id=1PMgNxyFMVndBwwsf8NOipsuNhYP0cCZ6", "https://drive.google.com/open?id=1f8AMToXdF-NGcvhWB6KfcHWF279lSJea", "https://drive.google.com/open?id=1q0pK3tVHcD8puCHMU-8PymwhD4ZRkHus"};
                ExamList = new String[]{"2014-2015", "2014-2015_corr", "Contrôle Continu 2013-2014", "Contrôles FSM 2004-2015", "Electrostatique_EXO_Corrigés", "Electrostatique_EXO_Enoncées", "examen st-sm", "Examen+Corrigé Physique 2 1ère SM 2010-2011", "examen2", "examen3", "examen4", "Examens FSR 2002-2015", "examens S2", "Normal 2012-2013", "Normal 2015-2016", "Normal 2016-2017", "rattrapage", "Sujet et corrigé examen physique 2", "2015-2016"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1SyywvrCGMDz3ogaLMQz3sOS09hJFyOmS", "https://drive.google.com/open?id=10OW9bvBc8a8BQ8UvteNCdIqrEtemySZ1", "https://drive.google.com/open?id=1u9f4j-0B2m4Hvd84093yCX9SKNi0yMqe", "https://drive.google.com/open?id=1GwpHwQXWpihknFIsWMAfOJ6D_F5IA7gZ", "https://drive.google.com/open?id=1jAxiqki7D04bQ4V9fQAC7ZmZIuyoqQbi", "https://drive.google.com/open?id=1JUGasbdqaUuZGc_V5p4fDRrxxF-CYtYw", "https://drive.google.com/open?id=1YyCaxl6CIODCjU8V4tONFr536sfU4119", "https://drive.google.com/open?id=1uVJ6d1DT_2o4yL4xIMxBqx6RaKvZAVDF", "https://drive.google.com/open?id=1qTbuCpYROkmE8OEnYJNU8ZFQ8HLiX3Uu", "https://drive.google.com/open?id=1LxFtpCLWdCPlX6A_RI-7Px-fa1FjIHEW", "https://drive.google.com/open?id=1dSK4p30d-hhvub87Sh8VMrdV0TXcLPhq", "https://drive.google.com/open?id=1a3rgjFFpG8k3EUCChrLL_9T9r3a-043b", "https://drive.google.com/open?id=1oBzQWaU-06i3IIR-SHHUALUfyGAiawj6", "https://drive.google.com/open?id=1ny8YsR8S6qM1T_LTA69mwAmLyJAurhU_", "https://drive.google.com/open?id=1h85rK6nbcP6fGcC2_TZA5YhqmRn61Z4B", "https://drive.google.com/open?id=1wZ5KWhJvWhUkeOlpwsP0z4CwdBpIqJgg", "https://drive.google.com/open?id=1bhr-bM3T9dY_AZd_mhyV50akQul7KqGY", "https://drive.google.com/open?id=1FCpiNiSveu8kACb2ai4ysCdmQuH13TZL", "https://drive.google.com/open?id=1GejM_DRo6ePzDw0LNiaiZ28hPC51zOX6"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 9://chem2
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 10://info2
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 11://renouv
                gridList = new String[]{"chapitre 1", "chapitre 2", "chapitre 3", "chapitre 4", "chapitre 5", "chapitre 6", "chapitre 7", "chapitre 8"};
                uri = new String[]{"https://drive.google.com/open?id=1Zo8nY-opMg3reyTXGsNaSEDygv_fN3W2", "https://drive.google.com/open?id=1MRxYa4rLkNVBJk7-YQz6v0FD-Hr7LGgu", "https://drive.google.com/open?id=1fi2SPTuJbxUyQeGkX_QOAg3O7P5vzGlB", "https://drive.google.com/open?id=1Puqyb5MRDrPTLkMxRfkKDtj8VtbV18sd", "https://drive.google.com/open?id=1bfaBprIL_jNEVOkueoS2ej9PBnCebziY", "https://drive.google.com/open?id=1HDRxqXv5PZj_SlbfKEuJ4eQzipvFO8dW", "https://drive.google.com/open?id=1sTFxwiRG5v3pNAa9W9MlmRCqJ-3mZ9W7", "https://drive.google.com/open?id=1TIlXYmh4wHs2X5RUE4r75AYaJCMxLndC"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;

            case 13:////serie
                gridList = new String[]{"ch_intimp", "ch_series", "cour series entieres", "cours_outils_mathematiques_e_fromager", "cours2", "cours4", "Equation_Diff", "Formulaire et méthodes", "Intégrales doubles", "Int-multiple", "LectureNotes", "math de physique livre", "orcours", "Polycopie_Math", "résumé + exercices corrigés en séries numerique - université de Bejaia", "rev-sec-princip", "varcomp"};
                uri = new String[]{"https://drive.google.com/open?id=1YD8bg3bXHrtCSmxVTnLPSag0ibEFn6QD", "https://drive.google.com/open?id=1NALwYDa3OClFhM9GKqDgc5gthF6uDQ16", "https://drive.google.com/open?id=1VieR1Gp5S0DksHtaD9CrF4ybuC_decvL", "https://drive.google.com/open?id=1JbkLnGfQ3pHXwGw7_NdbkwlZH26x5xZF", "https://drive.google.com/open?id=1WQdxEA_NdgxsBY3lOxyzN2zGpaWAkUDM", "https://drive.google.com/open?id=1INbjnUzAF_388y6BTplLDcymLU4Mjzhv", "https://drive.google.com/open?id=1bUaH0Xz7LJK6X7AAWY6wwahosI3sImGQ", "https://drive.google.com/open?id=1VKWeT99psmTOaeGkMmqWODNPaE0zbR0n", "https://drive.google.com/open?id=1SGYq34XhTk258KIF3RQerKVFoVhQJhTk", "https://drive.google.com/open?id=1_jZyjT3Dj3bAphnOjzAYgVjNi1hYt4Gq", "https://drive.google.com/open?id=1DpPlZt5SsgJwToxmD4XUh8drdDzOem1y", "https://drive.google.com/open?id=1Y2hHe-wZ7-xvnhOJnfyiEKB2CI-VMXsa", "https://drive.google.com/open?id=1vDwBT4Dl7Pw4gX9uNWYw-tDETw8TEJyA", "https://drive.google.com/open?id=1ml0ugZcgbvs13BoLeoPVuOhgqH9sbDCv", "https://drive.google.com/open?id=10IK6t1QqaFCHB_G7CAHpUoJLHh-AahS8", "https://drive.google.com/open?id=1SNE5mQAa2tRivJnwLiuP5e6oHFPsoDtZ", "https://drive.google.com/open?id=1TLz2B471jamgAxkJnOWOsz6LED99Ef2a"};
                TDList = new String[]{"SerieN1FonctsElemtrsS2013Dsol", "SerieN2DerivationS2014Dsol", "SerieN3IntegrationS2014Dsol", "SerieN4FormuleIntegraleCauchyS2014Dsol", "SerieN5SeriesEntiereLaurentS2014Dsol", "SerieN6ResidusS2014Dsol", "serie 1 ac", "serie 5", "exercices_corriges_integrales_generalisees", "exercices_corriges_series_numeriques", "td2-fonctions_holomorphes-corr", "TDmathchimie2"};
                Turi = new String[]{"https://drive.google.com/open?id=1M_UHDwOzIk95WdipFNCV41YltRJ8Os3K", "https://drive.google.com/open?id=1YYoBXUKS4U3_HKA_1SDzj02sLrNzy0By", "https://drive.google.com/open?id=1yikdaiHkEWo04LX_fMnR_kG93iZMOLEl", "https://drive.google.com/open?id=1lctUosZ8AzH9S2FZpKvm5xlNbVxUKd9y", "https://drive.google.com/open?id=168TIFhkEeXhPbvcXnZZ5oO18adD_b7vv", "https://drive.google.com/open?id=1_390il30DRnC7joZRkQm1EcLEyiGRVhL", "https://drive.google.com/open?id=1vgfrouL3WDzsDJibFey99bP4ztg8s5pt", "https://drive.google.com/open?id=170gPHoLkGfwui9qoW4p5Cg8Oc7Zb-Jmd", "https://drive.google.com/open?id=1VX6I3ow2fYA1ZX2ruSZhtt1BN9kdrVBn", "https://drive.google.com/open?id=1YpoJAyqc_jP6qUsOg_oP_CrS1j5OXvZS", "https://drive.google.com/open?id=1IcRlC4quwJAbaqE0u9JlVr2KMLc-5e6p", "https://drive.google.com/open?id=1pFwUeGdXClUCORImyejgzMt7FHe1jl8Q"};
                ExamList = new String[]{"Test1TDs2014formAsol", "Test1TDs2014formBsol", "Test2TDs2014formAsol", "Test2TDs2014formBsol", "FinalExam-2014Dsol", "devoir + corrigé 1", "examen d’intégrales et séries + corrigé-université de nice", "orca_", "orca_2", "orca_3", "orca_4"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1puYg5TdThPaDNa51BTrM934pEJgDLU-8", "https://drive.google.com/open?id=1QGYeKhWXwsMAlTz4iprknaBDT45c_vgR", "https://drive.google.com/open?id=1lWiJTzu9Ms7bKQI5DCvDu42TKkiVLCKB", "https://drive.google.com/open?id=1gKO0jQYrYB58EHrtVMr5x1pLEKqUJxqK", "https://drive.google.com/open?id=15dGgzzNFwdcvS0DkcuEcKQ_0qW4OfgWq", "https://drive.google.com/open?id=1MFiseNZU2hq8aQnXV5jVrk_zrWumx8WI", "https://drive.google.com/open?id=16LWKR_Pw7W8QuPraWPtslDfeqS2ymCbl", "https://drive.google.com/open?id=1_pP75k3LPae6Qa0oea2IPebQocKVP9Mt", "https://drive.google.com/open?id=1J_wT-Cx6c2Ye1y6xgG_vZlDyueZdkIzP", "https://drive.google.com/open?id=15J1zcHa7Fi813ewbsPXA4GHbFJpj7hOz", "https://drive.google.com/open?id=1wbVX6hE47Y8Gf55x7KNyKrCEx2bkyIdV"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 14:///mec anal
                gridList = new String[]{"CHAPITRE I-FORMALISME DE LAGRANGE", "CHAPITRE II-CALCUL VARIATIONNEL", "Chapitre 2_scanner", "mec", "Physique_Resum", "theorie_pendule_double", "ppv", "Me_An_livre", "mécanique analytique_livre", "PHY7-Mecanique-Solide-Analytique"};
                uri = new String[]{"https://drive.google.com/open?id=1qvRq0vulolre97yzDHX0UHdOGknH3B5G", "https://drive.google.com/open?id=1w6PeLKqn2fkTzvRABK-xhm48wJVpPop9", "https://drive.google.com/open?id=1574jDA9qwCNTuL3HYR5K61oGX3CW-36E", "https://drive.google.com/open?id=1v985X70Rpq1TxYaaiohn5P0kVhiLVDu9", "https://drive.google.com/open?id=1yoZDmB-lfObyWDZMo6to62I3OB4Ifva6", "https://drive.google.com/open?id=1__OMmx_VIGUE35U_mB7eSAQDClGt4l7x", "https://drive.google.com/open?id=1C8F5_R32GAc_Rm9XvxmEvS407B088KNR", "https://drive.google.com/open?id=1NBYne4_dsz0S2gndadc7gXUE5SoF68l0", "https://drive.google.com/open?id=17Pprr7IsU874GMttAtv6omYHaXb5vw_T", "https://drive.google.com/open?id=1NM4sJULDNPKRq8EcuMQUgFghyNc1wbxP"};
                TDList = new String[]{"M-ANALYTIQUE-SERIE-1-CORRIGE", "M-ANALYTIQUE-SERIE-2-CORRIGE", "TD 01", "TD 02", "TD2", "TD-MecaAna-L2", "Serie03", "Serie04", "Corrige03", "Corrige04", "poly_td_ma", "Mécanique Analytique-TD", "Mécanique Analytique-TD (3)", "Mécanique Analytique-TD (4)", "L3_TD_Meca_Lagrangienne"};
                Turi = new String[]{"https://drive.google.com/open?id=1Mhl1Fb2jveZmaVwhpv-esKKtlC0NI5R1", "https://drive.google.com/open?id=1D4atJ5h0om6KS98cFzcOsXMNPR-9cb86", "https://drive.google.com/open?id=19u_lHxbH1ZLC8NJLMYhk9WGsY5fZjo4d", "https://drive.google.com/open?id=1elYN_Z7uj0JQmWKxmzPEUCh5ggcPiNMw", "https://drive.google.com/open?id=1w7DvbBhw-164fwRA_LeeslfEaNz64qzM", "https://drive.google.com/open?id=1gGPx96_DCC3Nim9ljdyu_94U_HgzHQjJ", "https://drive.google.com/open?id=1lOoZ32BCvmnbpHNUoQ_q_W0mjMX8HRwC", "https://drive.google.com/open?id=1tyNWoPhxjxbG6TwL5zYDX3Yk9bC2SmKQ", "https://drive.google.com/open?id=1KAw7ZBGCymLRhKX-2UNWWVw0vM0yvOn_", "https://drive.google.com/open?id=1C01eH5Wh_tD3kX8DZHQFmVzcy98wmqKu", "https://drive.google.com/open?id=16e5SPubslLbPKOlNOQ1ohMXR_oXJ4fkf", "https://drive.google.com/open?id=1gMEaNem64aq8-xmk1fnC3lDYz6Vzrjmu", "https://drive.google.com/open?id=170L6wMvPFpgw5thIppCQLA13g-oVHhfX", "https://drive.google.com/open?id=12ealgc87YRLG_AUSm9s1BZZRl4X2JP5Q", "https://drive.google.com/open?id=1IxyNKwRIzLnB6m86xAmepbnqMmZCxZh7"};
                ExamList = new String[]{"3 examens + corrigéecole nationale preparatoire aux etudes d'ingeniorat", "CONTROLE-MECANIQUE-ANALYTIQUE-SMP-S5", "CORRIGE-CONTROLE-MECANIQUE-ANALYTIQUE-SMP-S5", "examen université ferhat abbas-setif", "Examen_phys03_2009-2010", "examens et rattrapages corrigés de physique 3 USTO", "Mécanique Analytique-Examens"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1POAAlVbKKTagrxlHaTQZaImwTy_-9qgZ", "https://drive.google.com/open?id=1VRRgVkhZOFy8OjitKOehR4gz6g9Br3hY", "https://drive.google.com/open?id=1YLpndWP23PpZ58UsAhSuXs9lSj-fgd4u", "https://drive.google.com/open?id=1rum7Jq6PuCZsZ_d50yk4ql6MnxvqDk1y", "https://drive.google.com/open?id=1f15s5KcJ8u3uYnx7UwcF_AWhI5GLK-Zf", "https://drive.google.com/open?id=1bmQRHgPlpBg28r7WSjW0-pZf749IskHi", "https://drive.google.com/open?id=1YHePjIPtnzCWZXtMOj6LqPvgT6Yh5bXD"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 15://vom
                gridList = new String[]{"chapitre1", "chapitre2", "chapitre3", "chapitre4", "chapitre5", "vibrations_et_ondes-Pr_Djelouah", "polycopié Benabadji Final", "polycopi_kadri", "VibOndes", "avantpropos", "amphi1", "pdf_recueil"};
                uri = new String[]{"https://drive.google.com/open?id=12gwGwy6ZLFpVLLOwGA8Mh8I6_pvlhtGZ", "https://drive.google.com/open?id=1LaiOXXmHcQikkujFw4pTmrVqHfU89SRd", "https://drive.google.com/open?id=1QfZZZUBaxgAl_RNWKWmTCDgqzkwd0W-z", "https://drive.google.com/open?id=135LYt71O0kYOfFEhxVAXXDf_LwxPpvl9", "https://drive.google.com/open?id=1MSfH_3b3-uTpQJ9niZUKBcPrRgDA3TcX", "https://drive.google.com/open?id=1oKk1OhPJPKIccfXpb52_O12DwtbN-Dyu", "https://drive.google.com/open?id=1Pymxag5Jh6WDw4NbhrMgPn34iNvKA53a", "https://drive.google.com/open?id=1-2NggAcXGkZC37bxOPXkWpOGcN7Rjz2z", "https://drive.google.com/open?id=1PawUo4R76FIt4YD-G-0oB95MLm0KmkE3", "https://drive.google.com/open?id=1Kb29aemzXX5-kLmcIBWBuFusF75Z9dQQ", "https://drive.google.com/open?id=1hn2UGgxDPSP0OeEXeh6Vn8YnabX_CqWD", "https://drive.google.com/open?id=1fRdosOQS9f9jrXOwtKdKCs-6wmB1qoVz"};
                TDList = new String[]{"Série TD 00 avec corrction _Vibrations et Ondes", "Série TD 01 avec corrction _Vibrations et Ondes", "Série TD 02 avec corrction _Vibrations et Ondes", "Série TD 03 avec corrction _Vibrations et Ondes", "Série TD 04 avec corrction _Vibrations et Ondes", "Série TD 05 avec corrction _Vibrations et Ondes", "Série 1 VO", "Série 2 VO", "Série 3 VO", "Série 4 VO", "Série 5 VO", "ExeRevPhys3VibChap1", "ExeRevPhys3VibChap2", "ExeRevPhys3VibChap3", "ExeRevPhys3VibChap4", "ExeRevPhys3VibChap5", "CorrigéSérieTD0Phys3", "CorrigéSérieTD1Phys3", "CorrigéSérieTD2Phys3", "CorrigéSérieTD3Phys3", "CorrigéSérieTD4Phys3", "CorrigéSérieTD5Phys3", "exercices ondes et vibrations + corrigés"};
                Turi = new String[]{"https://drive.google.com/open?id=1I7FSWn33jdbvKzbTEEBQCm0DckBvFiXt", "https://drive.google.com/open?id=1MClqNGWabF5s2NZdrfshH2jWeuC8cys_", "https://drive.google.com/open?id=1DFL8SMc_E8MbzTq95TMpzXUAXaPGXKQ-", "https://drive.google.com/open?id=1nuLITUoNC5EzOaMvbdFQtSoXHa4jMKlM", "https://drive.google.com/open?id=16rwoXo-R3NKsXlSnxCklr9F4BgTWMQlG", "https://drive.google.com/open?id=1dDJI2LZNLV9rQLu_rP_OWc5u1xDrl1mB", "https://drive.google.com/open?id=19EtgFYN1BbwUVwWIV8aAVkG1edsIomJ8", "https://drive.google.com/open?id=1eYqjFGqaO6TEn_G48BpBL7uJsZTCvRb0", "https://drive.google.com/open?id=16k582GhQMjE6Wf-UwFL2qSzGWWn38dcV", "https://drive.google.com/open?id=1n4ejkf1gD2GMXFzRWFdVShZcM7iujz24", "https://drive.google.com/open?id=14d0LJ1Nh40ytzmcI_SQvg94NkBuxhSG1", "https://drive.google.com/open?id=1RGhJWZ6lK7LYf9K7Q67GMyBPmvQ7b0En", "https://drive.google.com/open?id=1rqP9aNJzLn7WBlBE3tVbIFiXPuulYrd0", "https://drive.google.com/open?id=1V4fStSWphH4NkfKO_2Aca1oYt1bjhMBX", "https://drive.google.com/open?id=12Yfus0oo6cQ2Q7PG2aWz5apyU1WnNkOn", "https://drive.google.com/open?id=1xmBTVYxx5Bfsu4_InRZc1a_wBpXny8Xl", "https://drive.google.com/open?id=1spO6HNLkQpqLPpR6zYho7idRWEeaQm0R", "https://drive.google.com/open?id=1GzQ9zytquSbSlAhVBYk_H8ZswsFPa3K9", "https://drive.google.com/open?id=1Ux8v4Q85GeBpKO3HPL5_mKpn94mTe42Q", "https://drive.google.com/open?id=15ZLKcUNeWu1j9aFCh2kL1FOYxFa6REMQ", "https://drive.google.com/open?id=1ys0ObdupE3_oAuoOZ6tB9GZixttudiNp", "https://drive.google.com/open?id=1GxVEc8s4oqMVs-z32j0AkqeENcGLmIkt", "https://drive.google.com/open?id=1ZQJe9V4SJnaYe1HGGjrxiz72UYkOXIpx"};
                ExamList = new String[]{"3 examens + corrigéecole nationale preparatoire aux etudes d'ingeniorat", "Corrigé Interrogation1aPhys3", "Corrigé Interrogation1bPhys3", "Corrigé Interrogation2aPhys3", "Corrigé Interrogation2bPhys3", "Corrigé Interrogation2cPhys3", "Corrigé+Rectification", "ExamenPhys3.2010", "ExamenPhys3.2011", "ExamenPhys3.2012", "ExamenPhys3.2012Rattrapage", "ExamenPhys3.2013", "ExamenPhys3.2013PourAbsents", "examens et rattrapages corrigés de physique 3 USTO", "Exercices Interaction Rayonnement Matière"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1yU96o29pSsjPPvXMNZTkn5U1ycoBzYxF", "https://drive.google.com/open?id=1x0Zy9SJ1gmII43_nyzjZdph2j_VFhrIo", "https://drive.google.com/open?id=1pyV_Xwp2PR7X7JhPNG1tPwPnXSRrAX2z", "https://drive.google.com/open?id=1A79gqbGVgVHjjAPxdqbOatjIYMri7DGa", "https://drive.google.com/open?id=1-xWwcR7HmJtKknWpnaWcmibll1afndM0", "https://drive.google.com/open?id=1woDXwZNlpHJlCzkr7R6aKPir2DOqF_CQ", "https://drive.google.com/open?id=1EmcgbfZRbq6DM8kJdpiF_4HrjjqStpgA", "https://drive.google.com/open?id=1svU8U5mHkPcjJ2xdseV19L4NSNY1FhK4", "https://drive.google.com/open?id=12Ko6X1fUhKpfcg9JoyGhWUExGIXpLO-f", "https://drive.google.com/open?id=1bLaDKHhGQI6jIf6gsHTm1xloiFIU2p87", "https://drive.google.com/open?id=1fNzbPVtfWBGLgLdIEJVc56I6wo5_BUxn", "https://drive.google.com/open?id=1iX6vGyUL7z1oYBa_IakBnuMRS2Hk5WpK", "https://drive.google.com/open?id=1cW8hNMkUOokwnrSc1FocBuvurQQOCqhw", "https://drive.google.com/open?id=1O7FF_xxhJ11ZMKGRi7P1khL4fTxVamzQ", "https://drive.google.com/open?id=17b6EdUN9qsXIdjK6PFkrl9ZRToSZOy39"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 16:///optique
                gridList = new String[]{"4-B-2-Chapitre_2", "21 La diffraction", "22 Généralités sur les interférences", "23 Interférences par division du front d'onde", "24 Interférences par division d'amplitude", "optique miroirs", "cpeu_fabry_perot", "cour1_papier", "Cours d’optique_ Simulations et exercices résolus avec Maple®, Matlab®, Mathematica®, Mathcad® -Springer Paris", "Cours Optique Géométrique", "cours_complet_wit", "Cours1OptGeoA", "Cours2_papier", "Cours2OptGeoA", "Cours3OptGeoA", "Cours4_papier-2", "Cours4_papier", "Cours5_papier", "Cours6_papier__Version  incomplete", "essentiel-circulaire", "fabry_perot", "fermat", "Images miroir sphérique_CPF0809", "interference_diffraction", "interferences", "livre optique géometrique", "M_spheriques", "miroir_sphérique", "miroirs1", "optique geometrique ch5", "Optique_Géométrique", "Physique-Chapitre12-miroir_plan_et_reflexion", "polytpoptl2s3", "theorie_focometrie", "الضوء"};
                uri = new String[]{"https://drive.google.com/open?id=18kAThmIIP8AA6_88jUfBfL3kPDi3CZsj", "https://drive.google.com/open?id=1nJ9_GXgtdDvSd0HXXTzIiApAZ-uC2Zyt", "https://drive.google.com/open?id=1n4ClF2lge-cf7OQqXq1xSNqvXsSKAzK4", "https://drive.google.com/open?id=1llsi4rnMV0uUoHscXwJF263QWOOUVgqa", "https://drive.google.com/open?id=19VMMFu1Mm7aKWznxs-9w0_cHcNAEagfd", "https://drive.google.com/open?id=1lsh3mM0nQrE8rJpb260mHx_qvKlT--_O", "https://drive.google.com/open?id=10_7bvcxmxrlCjV3rHiiUygXvSpEIYKKL", "https://drive.google.com/open?id=1a1tGuhYJdZdGvbG52y_iCh30a6ZAhI4a", "https://drive.google.com/open?id=1IB2S3DAYzPg17htqo1ScduMzHEU9aTY5", "https://drive.google.com/open?id=1lnoi9WY-sX0nO9yFWX-uWhA1DOjTePB7", "https://drive.google.com/open?id=1txBeUX8JFF0AJjpUKIv0XF5MVMFSLEyo", "https://drive.google.com/open?id=1LVTc8LcDPLxw0KBMrjqIyHLqgm6pdMVM", "https://drive.google.com/open?id=1wWCGY2DlH5CpXOsikONGrDvIGoJSCwRk", "https://drive.google.com/open?id=1OSexBtBr14JpD2D_F-oi1T22Hi0WkK9X", "https://drive.google.com/open?id=1KBIRLLj9yoV5Ji0ovlNfo4m3GBJTPaDM", "https://drive.google.com/open?id=1AbxedBnfHxq-DVd6j1wvJeLb9Mxci8Xw", "https://drive.google.com/open?id=1ETWg5USWSka9Zk58NJsmxmt5kR7OKDjl", "https://drive.google.com/open?id=1TQPAtxZSpzzyKexSAjTG6_9AKBifEkD4", "https://drive.google.com/open?id=1fkQxAKx4oJOL7te_bH8ssAZv7RNiGkRq", "https://drive.google.com/open?id=1pGFJP9L-KlrhcRsSmc-Xkx2bBqxHnwGb", "https://drive.google.com/open?id=1yXfY5fFgiSQGDkUwwXysP9piWXgp1XQf", "https://drive.google.com/open?id=1Anggjx5aLzMZiLIZbp_qHw6zPKbdoLI8", "https://drive.google.com/open?id=1S-l9LFp20csKKhz0tWBEYcwDYyFaRFmw", "https://drive.google.com/open?id=1UCxgr0x6mqkDpWPGZlM5XKKONisa1m14", "https://drive.google.com/open?id=1BQi1FdmZbXltBIaHvPL9F-Vfm6ddj98I", "https://drive.google.com/open?id=1PtSjyRFBeOaYphlXrrv8k_cAy7AnSfSO", "https://drive.google.com/open?id=1bSOxQEx_1X55ysjwVA0Wg9KW-IaL-ZBI", "https://drive.google.com/open?id=1VfT7G2Ql0WwSEQOtgDl0BVdw8ifOirde", "https://drive.google.com/open?id=1lNI05_KDtsplTSOVBv4HATgD1Qgbafld", "https://drive.google.com/open?id=1c4cL7HlDXJTn6GBPcmhaxTJuNuSaCrpH", "https://drive.google.com/open?id=1l9PPM_QI7VBsjOKgijSsZ6zHeXzWdBDp", "https://drive.google.com/open?id=1wqDffcI1MM2l52GGx7GClvativnJ78Wf", "https://drive.google.com/open?id=1XhC8nMP_X4r2sYZXfS57flvcIU1k23_4", "https://drive.google.com/open?id=1ifQkSHqnED5o6US-Hvn8mBJkO_k0ZBXe", "https://drive.google.com/open?id=1AoPuh-SY4vYPpTb-u90ubR_183IyCH2y"};
                TDList = new String[]{"corr TD1 et TD2", "Corr TD2 Optique", "Corr TD3 Prisme parite 1", "Corr TD3 prisme partie 2", "CorrectionTDOptGeoSVT2012VF", "E03-optique", "Exercice Optique G5-02", "Exercice Optique G5-03", "exo-corr-op", "exoptique_20089", "la série 2", "la série 3", "OPTIQUE   Serie n2", "optique_td2_supl", "Serie 1 VO", "TD + corrigé prisme SNV-USTHB", "TD", "TDOptique", "TDoptiquegeometrique", "TDSVTAutomne2012VF22", "tp sur phenomene de reffractions", "TPCours-reseau", "TPoptiquegeometriquelentillesminces", "TpPhysique03", "suppexos_og1_og2_optique_geometrique"};
                Turi = new String[]{"https://drive.google.com/open?id=1bfN4z7MelyVat7NTwfdJUnzXEdYrfY-D", "https://drive.google.com/open?id=1UjONsofY8968GyKlckXXxkC7WPSCJDGC", "https://drive.google.com/open?id=1Y8iBEE-Epzai0JuGIZiGDLQDEMsVmIjo", "https://drive.google.com/open?id=1j9uI2IMs-GNNJT9Eo1qrgtko1WKebXhn", "https://drive.google.com/open?id=1fkoRUIRubeWBZKsxHYV_oLT24zgu2vUP", "https://drive.google.com/open?id=1iLHsvgnUmZXiRtr86jYN9EVoFKsISECX", "https://drive.google.com/open?id=1RGpE19ywQ8JcjSvHGsq8iCURE8As2PHl", "https://drive.google.com/open?id=1esE5sx-LBgFprT-YxmEcL4sdYaNpCfU6", "https://drive.google.com/open?id=121rDmxy8KYW0Sx-w6mb4X2I_6j_0p0j2", "https://drive.google.com/open?id=1eJYyy5H4UkkQ2RYmpKo7ZuwcyHGC3CDi", "https://drive.google.com/open?id=1CaQNnHFQaQfyZQEIe7lpy7GlYK5z_fly", "https://drive.google.com/open?id=1FQdztoj6dmq06Hii8tpzScio6kpRN12k", "https://drive.google.com/open?id=1F3zdzHpQMTQzIffdce8nXXGurehoLLTr", "https://drive.google.com/open?id=12ouEq6b8HVn9vWbLxm-dhgiFsWSKtUDH", "https://drive.google.com/open?id=1newPUGTMewRL2QYcy8utUKLVSutye3w4", "https://drive.google.com/open?id=1GkKYFVddR4l2krUdThlIsGvYoI29gfiZ", "https://drive.google.com/open?id=1Mrb-znWkmY4ugjeLZ0Kwh6acYwzSfBOV", "https://drive.google.com/open?id=1uVFKvb1NV4Z70oVNNB4eE33sGrrtzlXk", "https://drive.google.com/open?id=1drkEY_wjTQwf6Gycx7kcaZjttQu6-TQO", "https://drive.google.com/open?id=1QkncaCLNUnZOw9rrxEFFvkcNiHB3f1EF", "https://drive.google.com/open?id=1vvMbl5ObJMetdMZqHSNNZcr3D4ZoNbqn", "https://drive.google.com/open?id=1iRRCpBkSVIkkI1AUWI11ZrgmHZCAPUH0", "https://drive.google.com/open?id=18bfK_gNOHSpCJvZ691LgYh7wvzkamUHP", "https://drive.google.com/open?id=1S4oiGN5Tmvx7yR49hkQ5063nUdT-52Qa", "https://drive.google.com/open?id=1RhEfl_VxYxO0VUKgBPegSEe54df1rNPQ"};
                ExamList = new String[]{"Examen Corrigé de Physique - Optique Géométrique"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1gK1wR0zxs8cb0ctBysV-uAllwNzRDu3x"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 17://tp mnp
                Toast.makeText(this, "Vide", Toast.LENGTH_SHORT).show();
                break;
            case 18:    //tp optique
                uri = new String[]{"https://drive.google.com/open?id=15QBcwf6dv8T33KpP_4emkw8wJh-y85Cb", "https://drive.google.com/open?id=1JbuDr9CISTKIDkPV4g9kC54q7zH1_VFB", "https://drive.google.com/open?id=16Iz4HjStnf6dL3gAKNWXSJjrW2uo8ea7", "https://drive.google.com/open?id=1lsbq9HQhD9-apn-2l-zHy2pXNK7Nhu4W", "https://drive.google.com/open?id=1KFAgtjoTCVwfwcNz3fCdj3GY6HAmQqwJ", "https://drive.google.com/open?id=1akk-mIeV6kXbDlmqPqXJX5up7VElUMWF", "https://drive.google.com/open?id=1i4hu4F1sZJwWCzwj_eo0XtqxjUMjwuNQ", "https://drive.google.com/open?id=1GvJXlZa81VRchkQaLCuF_2cMZKWfwEJX", "https://drive.google.com/open?id=1w8jHfU60Nl8-bWq_B9Upo3-5r_-svMlu", "https://drive.google.com/open?id=17TJiC_0_1YG5li2hmU6uKppBSfhBsUxU", "https://drive.google.com/open?id=1sDw3_OPfBkppMsJlX26oGx0Fw4agNVD5", "https://drive.google.com/open?id=10-LQLPqKu_mLTCPV_H_2zzbJ9-k2Mu0B", "https://drive.google.com/open?id=1eMoYHxsN2SDdXtcH4YNvpROQmfOYogCD"};
                gridList = new String[]{"20110507093632", "TP Fente de young et reseau", "TP Focometrie correction", "TP Focometrie", "TP Optique Physique SMP4 2015", "tp_focometrie", "tp_interf", "TP_Optique", "TP-Opt-TP1", "TP1_2", "TP7[c]_2008-2009", "TPinterferencesCorrige", "determination_de_la_distance_entre_deux_fentes_par_interferences"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 19://mnp
                gridList = new String[]{"alger1 SM AN cour ch3 EDO", "Anum", "Cours_integration", "Matlab", "Programme SM de module methode numerique et  programmation (MNP)"};
                uri = new String[]{"https://drive.google.com/open?id=1ZVh2nvFqAiIYo22z6tYDQXBpAr4gvO_a", "https://drive.google.com/open?id=1Z-oG4GocMmz2mPFCcNwFyOj83z0pjs3Y", "https://drive.google.com/open?id=1OT3H8SaN0vE9cmRuD-s1VLklj8eRPNkr", "https://drive.google.com/open?id=1iQYhF7ejSB7pRsgVwMs9TDVbFKQ5fzN8", "https://drive.google.com/open?id=1YHf1An8v1cp7qA_BImaiIh69G3sx1MCA"};
                TDList = new String[]{"TP1_MNP", "TP2_MNP", "TP3_MNP", "TP4_MNP", "alger1 A.N SM  serie TP1integrale num__riquedocx", "alger1 A.N SM  serie TD1integrale num__riquedocx", "ch1 exercice avec solution", "exercices-orrige", "solution serie3SMalger1EDO"};
                Turi = new String[]{"https://drive.google.com/open?id=1QWEoUokaahRGDJiumy0mzbcJXNMROnYR", "https://drive.google.com/open?id=1qLlLAao4e0fUCu6YZeyoh49aBRmonSlE", "https://drive.google.com/open?id=1MOpYAq_U_ipDDrjoOKljEmA-WDlBFlPO", "https://drive.google.com/open?id=1WbQ9diOaRtbcDhPOLec1VQYDjoVJNCyT", "https://drive.google.com/open?id=1Ztbk66L4ju4Gk4Eg3HZRBCNVNuqHewup", "https://drive.google.com/open?id=1WIRtRZGgBSa0OE4D0fhB7XF8IhSV0OVm", "https://drive.google.com/open?id=1fzu8X15ye2fxlBVElRHyXTFTCm7vzddK", "https://drive.google.com/open?id=1HECmQ8KZVy02JUCn3RqVpQlWpIQ7IYpV", "https://drive.google.com/open?id=1xX3gf86lPM3wDbGbfqQdmLyeRqitAmkd"};
                ExamList = new String[]{"devoir2MT40", "L2_controles"};
                ExamUri = new String[]{"https://drive.google.com/open?id=13PKbg6q7uKWaOuh5t3q74mLQ-yAqq6cP", "https://drive.google.com/open?id=1Q06vRCNR6tcBGd1qT07bisCAdkntP3jB"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 20:        //cristallo
                gridList = new String[]{"elements de cristallographie geometrique", "cristallographie", "CHA1-RESEAUX", "Capelle- Cristallographie-1", "Calculs_dans_les_reseaux_et_groupes_ponctuels"};
                uri = new String[]{"https://drive.google.com/open?id=1jwW6xpQHkpAw14miA48S9nml9k6vHnZM", "https://drive.google.com/open?id=1tE0NRp-tKxux0hFbMJFh9rLmqoWt1R4E", "https://drive.google.com/open?id=1WjkwyT6DghZ7W2jLU5tOw5u04QO9PrWX", "https://drive.google.com/open?id=1Rsl8_w11L8L1qaSTlgeG5esTG8HIsusg", "https://drive.google.com/open?id=11P_3vY8-VxTJgc8TQAYH9-MzgOfqfKb7"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 22:  //thermodynamique /fichie non inclu
                gridList = new String[]{"Chapitre 1 By ExoSup.com","Chapitre 2 By ExoSup.com","Chapitre 3 By ExoSup.com","Chapitre 4 By ExoSup.com","chapitre 5 By ExoSup.com","CHAPITRE01_CHIMIE02_SM","CoursThermodynamique_L2","CycleDiesel","Feuilletage","gasconstant","intèrison transfer thermique thermodynamic","IntrTransThermExtr","Isabelle Stengers-Thermodynamique _ La realite physique en crise","lec1","precis thermodynamique","ps2solns","TH interrogations + solutions 1","Thermo_2sem_poly","Thermo_theo_poly","Thermo1","thermo6","Thermodynamique 2e année MP-MP¨PC-PCPSI-PSIPT-PT","Thermodynamique et énergétique _ Tome 2, Problèmes résolus et exercices-PPUR (2008)","Thermodynamique PCSI_MPSI_PTSI","Thermodynamique_smp s4","thermodynamique-s2","ThermodynamiqueMPSI"};
                uri = new String[]{"https://drive.google.com/open?id=1oXwGgronkKIfuA85ohxO8P115cODcyw0","https://drive.google.com/open?id=1P9cmA821Fq8qmUq-TN6nAdac0FXPFQwv","https://drive.google.com/open?id=1ZkZrXX2tS0Oc6UeD_jUg-VHiIhPQq1m8","https://drive.google.com/open?id=1c6BX35gAYgotTul3xxRsbgNnpc6z_34s","https://drive.google.com/open?id=1hg5hRQpN0JaP-codkhIPyJOqjoZ7EMct","https://drive.google.com/file/d/1Ynvz02A1gi61oBpQTaxI8Kk8jlTRZAjK/view?usp=sharing","https://drive.google.com/open?id=1sK0q0LCF-fTo6yZe3Oi4ERfkJcAMrg8T","https://drive.google.com/open?id=1U4_yf694242opSZC34ab5QL9Un3LUbhQ","https://drive.google.com/open?id=1HRodmhuhJ6R4obPGMHGkIzWD5zQ0tOsw","https://drive.google.com/open?id=1ZmakgHdr7qXZdbafnpN1RK89dQ7X9uRH","https://drive.google.com/open?id=1IwSyhJJf2FjkXWv7DIYTjDVeSc7t0Bw2","https://drive.google.com/open?id=1c19mol1ZpOLzFFT7K5C7RcxMc6OjTgZg","https://drive.google.com/open?id=1yjCovwT3UY-nf5a7sjbJHzoiJSpdmWwv","https://drive.google.com/open?id=1XPDwfl6Vya1GFKYfRddCmJf88bfDYOYD","https://drive.google.com/open?id=1S8lnZIk_9Tu-QK8Oer8fMIC-vO8p2TLv","https://drive.google.com/open?id=12Zy9KGfhYjUCO9fGIdKhWw3uMve03Y_R","https://drive.google.com/open?id=1lHVBCXyGTM_CDC_V0fOdkWIsE0dMHK-B","https://drive.google.com/open?id=1ifzbD48bsWfenQ6MUVJglH47dqnSwzBm","https://drive.google.com/open?id=1RFOqv4uP8Hfux0MW-FQkLqDZrFm96hsK","https://drive.google.com/open?id=1pQd2Yyk25NBiO80CLff0nokfCMb0Wq-m","https://drive.google.com/open?id=1ArPC6QxK2dAqfR_lYdt3lJu5ohsUK_3E","https://drive.google.com/open?id=1OtVqnv0wUWp-GI52EdrxGmhYZ_hCISSN","https://drive.google.com/open?id=1EXg40WmXiVrCGOQyeGmZy5d0YBg7Xjn3","https://drive.google.com/open?id=1hDOlgUrY_j-AHqh0TDkAqukxlIiLLHTM","https://drive.google.com/open?id=1n83SbiNxX8FUe0H6zDZoC-PuZmaWWxdy","https://drive.google.com/open?id=1VaRiO31PCDz7wBwOlIO4IGhcRA2C0G5l","https://drive.google.com/open?id=1reBsptb2INlhSPsFl8ZbWo3RyaC2QL5G"};
                TDList = new String[]{"TP-Thermodynamique","Thermodynamique II","Thermodynamique II serie n°2","thermo serie 3","thermo 4","TD_Thermo_L2-1c","Solutions_Exercises_Lecture_3","precis thermodynamique","New Document","exo4-5002","Exercices-premier-et-deuxieme-principe","Cycle de carnot","Fiche-TD-n-01-Suite-L2-Physique-Thermodynamique-S4-2015-2016 (1)"};
                Turi = new String[]{"https://drive.google.com/open?id=1AqjTmhbSQd0UIFx2TK892AsEeorHTCTj","https://drive.google.com/open?id=1hw0xpKzzJ76Kz5rTo5yxX2U5aUgevfiT","https://drive.google.com/open?id=1r4o4jpR0qjOMFm3td4C-ZHc6b7fdrL30","https://drive.google.com/open?id=10YoRrxjAMDYpRvYBdUq6AEOctaTDG9-w","https://drive.google.com/open?id=1Ph-yY0gdhbIYED7caK0krTUJMpjJpoU2","https://drive.google.com/open?id=1v0659IxzU2tnrwmnrulyH5y4I7QCiKKG","https://drive.google.com/open?id=1JKXt3fha6hiYf33H2xmJfm-Fk73qltkW","https://drive.google.com/open?id=18oFtqGhHPLeDyqe8u4Zo0UWmCNADBkBu","https://drive.google.com/open?id=1KFu2Uh7JMuyBN61mo_DJjFYAhbLL0mPS","https://drive.google.com/open?id=13w9Dgj49LkL_PujgehYH-JDR4ccMbU3h","https://drive.google.com/open?id=1FVeEJ537rpiZ_Haes4kCpS_xl16B6PZh","https://drive.google.com/open?id=15HqBHc8I-GGEa4_eL7FtZYRMaPSCcTic","https://drive.google.com/open?id=1JfjQtQNjH5aUzzqYFKaLjnFIX-qDW5eQ"};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 23://fonction et variable complexe
                gridList = new String[]{"annexes maths","Analyse_Complexe_CHARPENTIER","chap_6","cours analyse et algébre","integrale","integrale2","les matrices ","s.t_Integrales2"};
                uri = new String[]{"https://drive.google.com/open?id=1Ci87w2QScNnFwD0OMFwwua4XeP80hGNw","https://drive.google.com/open?id=1c3jPtMDKeWfqvCjBDinsDt3M_36kCdvF","https://drive.google.com/open?id=1ZWVqDSC1bu1CRPedi4Z9KUOwkPPBuMgJ","https://drive.google.com/open?id=1yphP0g9lj3pz_eKdrE-D0VLzwWgrvku0","https://drive.google.com/open?id=1Zvsak1M8mHiJYMXiAtlzc_adDUTAGaPg","https://drive.google.com/open?id=16uQeInwgQP6Sw1yo2-zewdFDAgNXIjZX","https://drive.google.com/open?id=1d4O78gcqUTWNpZ9rRyYGvnB1Zv0q9sCX","https://drive.google.com/open?id=1VKVPuGLIivTgvtKiDtMm4rtDeC2PIMSP"};
                TDList = new String[]{"exercicesMaPC41"};
                Turi = new String[]{"https://drive.google.com/open?id=1sWL-mSm3skgReZFHEj9puOTk_3Dc6py3"};
                ExamList = new String[]{"14 examens en math1 et math2 USTHB","Examen math2-Corrigé","examen_corrigé 2010-2011 - Université de Bejaia","examen- Université Ziane Achour de Djelfa","intégration des fonctions numerique","rattrapage corrigé de maths 2 SM 2015 - Université de boumerdes"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1P17x0QK_swt3Ypz5mGkgG7b-PwcPOoOZ","https://drive.google.com/open?id=1c3A15kAadR-bCN4J88wehbRf3SkKVGEK","https://drive.google.com/open?id=19oMF9wuRCaR1mVZBXSBpYTTtXaDWNlF7","https://drive.google.com/open?id=1gllg9PBs_gk2CkgqTxs7jWKg1wUHKJoS","https://drive.google.com/open?id=13bx9OO6GAjhtWbDDxUJ3GulFETD3767P","https://drive.google.com/open?id=1lflwpbkXBcZd_iAdiEJW8ZATxMjMOcQT"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 24://MQ
                gridList = new String[]{"Chap1","Chap2","Chap2A","Chap2B","Chap3","Chap4","Chap5","Chap6","Chap09-ExosDualite","ComplChap1","cours","formalisme","histoir de la mecanique  Quanta","M.Q-equation shrodinger","Mécanique Quantique _ Tome 3, Corrigés Détaillés et Commentés des Exercices et Problèmes-De Boeck","Mecanique_quantique_-_3e_edition.jb.decrypted","MQ TD+COURS","Notes_02.03.2009","PHY311_cours2_plein_format","polytdmq2008","principes","Thomas Boyer-Kassem-Qu'est-ce que la Mécanique Quantique","CFJanv07"};
                uri = new String[]{"https://drive.google.com/open?id=11ltulWwUJRaH_4nnP882KNvpWQ_4wHhM","https://drive.google.com/open?id=1B74KkeeCi47efeH_PYGdIy2kXqbS60x1","https://drive.google.com/open?id=1l5s5lRiIioU36RCW5kxWz4iypPs20Hf3","https://drive.google.com/open?id=1CMIGsOoqxqQO9kjw8D0bwrJhNmT-PUPd","https://drive.google.com/open?id=1bgqJTwco8Dq4QkpE8bchZK28ViJ-AKXF","https://drive.google.com/open?id=1BQDGd6JdKwA24PVkPuRX8LohY2wDNo5f","https://drive.google.com/open?id=1PkycuBBYrfBXlA-hcZWQ5xusbYAChLG9","https://drive.google.com/open?id=1uNK-Wt8cVi6aKGvzVgz6b0EHXymmp2GZ","https://drive.google.com/open?id=1pp4zPMjg2PptrBi54TNDBWBGf7emr_HW","https://drive.google.com/open?id=1nATkXzRhkZut-4UrI21VtbexTFJTl6F2","https://drive.google.com/open?id=1Joi8yi6338zaqUPY4oyn5qTaAVYILOnP","https://drive.google.com/open?id=1LX3xDktdlYtUd72QfQs8PCaNA_p4N_l5","https://drive.google.com/open?id=1ZWLpiFBywn_fyc8fr4PdC_Rq0YiGeIgs","https://drive.google.com/open?id=1pCeP_YLpSDSJ_hOnxBUA79e7fw5skIqI","https://drive.google.com/open?id=1IYACrVkQBxOX8J1xSemkwqMVc-X2ol1C","https://drive.google.com/open?id=1sncrADrJ3X4GrUpKjV1TRjeZlQb9DRZn","https://drive.google.com/open?id=1gA1PMwMZD_gKf0CPy9Qgy27DoeZ7Pm2V","https://drive.google.com/open?id=1fYUZw45XwBC2tA1XOcDQseLq7l9km-qD","https://drive.google.com/open?id=1iTb5wjpZIctvATl8FD-Tdinx2p97fwBa","https://drive.google.com/open?id=1RKox-atsByzgtMQ_cf1Lawb7AmLS59FC","https://drive.google.com/open?id=1Krhj1ZGTLIllLN-FOBGOhe_CcJL1JvtE","https://drive.google.com/open?id=1AB3qTWt8MJJuypE9ZKjskLYsfKiUlZxB","https://drive.google.com/open?id=12KULveugzbE8eyZE8hEeiH0ELWILQHo1"};
                TDList = new String[]{"Cor_CC2","Corr Physique 16 Quantique","CorrCFJanv07","Correction Ex09+Ex01 Série02","Correction_des_exercices_DUALITE_ONDE","corrige_TD1_3","Exercices et Problèmes corrigés (Macaniques Quantique )","La_mecanique_quantique_Problemes_resolus_T1","MQ-Complément de la série 1 avec Corrigé","MQ-Complément-de-la-série-1-avec-Corrigé","MQ-TD-Complément-de-la-série-2-avec-Corrigé","TD-MQ-COR-EQU-SCHROD-PUIT-POT-SMC09-10","TD-MQ-COR-RAYONM-CORP-NOIR-SMC09-10","TD1","td2mq-pc"};
                Turi = new String[]{"https://drive.google.com/open?id=1K2zp3kQY_fR25ODR8g4iKdqN6ojhA4vb","https://drive.google.com/open?id=1bJ-svRge_DrSX3ozB8tlBVWJB8zgKhKT","https://drive.google.com/open?id=1Yakw3u-AsM0ZCdVTBR1NQjaMCneqnl_P","https://drive.google.com/open?id=1sKkt4PkMaASRxSMy2IigDCkigcxFZIsJ","https://drive.google.com/open?id=14XmEqIxEubG3d8FPyZaDNnJgHVqNW2PA","https://drive.google.com/open?id=18ChStQPLJlag6W80gCKhrj7hUJOTIcFb","https://drive.google.com/open?id=12BWsWWOn7N2Stbifdidr-DVNNGKZp0Hz","https://drive.google.com/open?id=1i7j4ogaiwNPimKC-1TsEaqYt3UVyyo5w","https://drive.google.com/open?id=1byAKiSejs5Hp1qhl2eew_is-c9vsW_N2","https://drive.google.com/open?id=1FQ88FIA-uRy-1hHJcKYW1vXwbR3LiUaG","https://drive.google.com/open?id=1r745EwoXDrnEM_932qCkjofK0SfZh0hZ","https://drive.google.com/file/d/1tpnstTjcnQFZTEPnVB7GlaTLv-H-ky-b/view?usp=sharing","https://drive.google.com/open?id=12i5gclN_DfNb60lKTpgwQrMWvT-OqdPr","https://drive.google.com/open?id=1CN4KsBoT9Rz0D2sdIRGhYnCuVbEUtfJU","https://drive.google.com/open?id=1uxlqL-MD7vmfmA5Xt-n5I2WIXAP4LI3U"};
                ExamList = new String[]{"ctr 2 cor mq smp 2010 man","ctr rat cor mq smp 2011","EXAMEN_2011_texte_corrige","Mécanique-quantique-sujets-dexamen-corrigés","sujets_mécanique_quantique_2017_(exam-ratt)[1]"};
                ExamUri = new String[]{"https://drive.google.com/open?id=1Xtt37fAwNZWaYnQsneiDSkuCnXfP5PIJ","https://drive.google.com/open?id=1zwnFdlVcthput3UmtwXYUMmWvM4DS9pf","https://drive.google.com/open?id=1e8K7-CBEzdZrFiUBslWOPgf9FC3Xumpd","https://drive.google.com/open?id=1uAAfjj8ZDaxYfgBGhmZQyZhQYTWA5P3K","https://drive.google.com/open?id=1NpTeKxqORupCjiwaGJYpxzJ87oDTZtqw"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;

            case 25://electromagnetisme
                gridList = new String[]{"Tous les cours EM","SMP 3","Richard Feynman, Robert Leighton, Matthew Sands-Exercices pour le cours de physique de Feynman - 900 exercices corrigés-Dunod (2015)","Precis Electromagnetisme MP","Ondes dans les plasmas","notions_d_electromagnetisme","mini manuel","Michel Hulin-Electromagnetisme 1 _ les equations de Maxwell-Armand Colin","cours_electromagnetisme","cours_electromagnetisme_djelouah","cours_electromagnetisme (1)","cours_D01","annales"};
                uri = new String[]{"https://drive.google.com/open?id=1FzB47ZMJ9-zVaEb31YOQeyQaQcEknHXv","https://drive.google.com/open?id=1zMgLtI0TT7vT66WGryMVccp6pgrOzHHk","https://drive.google.com/open?id=11CiqreXuAliGsuFr4HkNZPA3I0CrMwTQ","https://drive.google.com/open?id=1yJTLAw6rheDNbDYf6QRKHUDGoDZGxMjs","https://drive.google.com/open?id=1G04XkPJz94mPFc5g14ffDNFM8VckZqgc","https://drive.google.com/open?id=1SzmCcRwT7nln95ElCtP3DDxGX6XxEkSc","https://drive.google.com/open?id=1e4kk1b2LjmlRGZuGE7XY6Ww2XhlUf8yK","https://drive.google.com/open?id=1W-pxkPiHhleZsw1cybfZ5Dkm-nAiUaHh","https://drive.google.com/open?id=1F1i11F1N8A240CHVMuH7PBIPIke9T04j","https://drive.google.com/open?id=1j9BbRoDvi9fiW1Iy6LhG09_WCD7jsWZK","https://drive.google.com/open?id=1S-Gh1DYr1IWsw52zM3k5YI8J3iNtk9i2","https://drive.google.com/open?id=1w3Ow4iO8zHoKwJRMVdcHeMZg0hc4WaNd","https://drive.google.com/open?id=1AicbzZ5gOutbsIsScNYkuKhlNM6e_NMW"};
                TDList = new String[]{"corrige-ex2012.b","Quiz1_fev13_cor","Quiz1_mars12_cor","Quiz1_mars14_cor","Quiz2_avril12_cor","TDs Electromag"};
                Turi = new String[]{"https://drive.google.com/open?id=1GsbruiURfSVgsoCs2Sai_Cz0lLUtnMDJ","https://drive.google.com/open?id=1a4Pbxd_XWwp2_C5f6x3_vFvJSnENeb3X","https://drive.google.com/open?id=1udBVUXJny80dRUUvkctqbmExLEMzzu7F","https://drive.google.com/open?id=1OSLnDIRzoOA-aC8vFmQ-eTlRmkrcH2e3","https://drive.google.com/open?id=1JI1b11d_Z5pCrdWrzu_XgRQdiOqfLmtU","https://drive.google.com/open?id=1-yxJH8fOSz1urjgt2oYEifeRQewaI1X9"};
                ExamList = new String[]{"CC_2013_2014","Controle_2012_2013","Controle_de_Rattrapage_2012_2013","CR_2013_2014","Examens corriges de Electricite 2","inbound-714389730","inbound-1871909293","inbound79144897","inbound808539695","inbound1427831083","inbound2126409566","L2S4_Exam_13mai14"};
                ExamUri = new String[]{"https://drive.google.com/open?id=16l6dZYNkjbInq1-iWPXF_qbCXSRHVWTf","https://drive.google.com/open?id=12xJXd5lM0RqUnDqQMX-zxhvNn5yYHIqy","https://drive.google.com/open?id=1xo2_0LpuMbxAMUSFJYGsOb4L82iZ6xMI","https://drive.google.com/open?id=1vZPM2tN5QQCVjst2hvzVMF2xmYoLrA8f","https://drive.google.com/open?id=1A_U2gQ4J06UkDL7NwNvkUSmFFt8zxvJs","https://drive.google.com/open?id=1VAuiKp0F92s6Xxo8hMudXFTIVMVOcNsk","https://drive.google.com/open?id=15uCgApbGyw716UoCniWG4z5fdMpnZzhg","https://drive.google.com/open?id=1FBMp7SWw2nKXozpKMvidlAKR-L6utWOT","https://drive.google.com/open?id=1ltuHqIZdKCUbFWCO5yt5rfZmIV0pKMU6","https://drive.google.com/open?id=1nUhxgktncD0Jt2FCijTHqvEsFd8Ls036","https://drive.google.com/open?id=1q0i770LcBYXGifb98Kr_A4XeKFmxmDdB","https://drive.google.com/open?id=1cjBhArToGtn62PpbkcKd8xyxlGLt2oE4"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 26://tp thermo
                gridList = new String[]{"tp 1 thermodynamique","tp 2 thermodynamique","tp 2","page de garde","page de garde 2","thermodynamique","Arab_Course"};
                uri = new String[]{"https://drive.google.com/open?id=1TjO1RVUYZQPlVQIGpeXTkzOPstCCjMPY","https://drive.google.com/open?id=1XwdgJJbN-_1zF-JWNInkUGjDWDnHTyZ2","https://drive.google.com/open?id=1iTnKETySrAgrDZuhqA_l6y4__WY1fEu2","https://drive.google.com/open?id=1dqMli1ccabAkxJqiCSjkb5PF0ivl4-sK","https://drive.google.com/open?id=1xzWMajo1PKo8bgoN9P4qiRuqIla09QCb","https://drive.google.com/open?id=1xnCSCJM-G8CK1DtGlCu7wwF-Zt8MkUx1","https://drive.google.com/open?id=1Eqhrt0-cKPK8g9q89-6A8LD9ka77egmk"};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 27://mdf
                gridList = new String[]{"Chap1","Chap2part1","Chap2part2","chap3mdf","chap3mdf2","cinéfluide1","cinéfluide2","cinéfluide3","Cours_Mecanique_des_fluides","FA","Hydro3","Loi fondamentale de l'hydrostatique","MDF TOUS LES COURS","mdf","Mec-des-fluides","Mécaf1","Mécaf2","Mécaf3","Mécaf4","Mécaf5","Mécaf6","Mécaf7","Mécaf9","Mécaf10","Mécaf11","Mécaf12","Mécaf13","Mécaf14","Mécaf15","Mécaf16","Mécaf17","Mécaf18","Mécaf19","Mécaf20","Mécaf21","mecafluBTS","MecaFluides5sur6","mecanique des fluide par louisnar"};
                uri = new String[]{"https://drive.google.com/open?id=14aVNEZMi3PwSGSXBe42cLJ4gxXE30v-0","https://drive.google.com/open?id=1ixr8Ids0wfDgUtDF_OVLK2Cx0-79nqAq","https://drive.google.com/open?id=1-VTDecCrQcGiK1N97oJsFHwR-2OmFAhU","https://drive.google.com/open?id=17MXBIe7NLxMOItO9RakoybO_pZOEmS0n","https://drive.google.com/open?id=1LGHZ7p_xvnovDrhJbaWQ3nYm9LA_e-I-","https://drive.google.com/open?id=1suhTTWrJ1aJw9BS9_LODkPYm8tb0qaHU","https://drive.google.com/open?id=1vTeAfSmO6d_tjuWyIm39XitfRBZb4HzE","https://drive.google.com/open?id=1FDJYE40QmhMZ0VF0Q1myy0dwSLLhO2aF","https://drive.google.com/open?id=1gTWrEWiGi2EviQy5IHq10ijO9Wf4ZcLa","https://drive.google.com/open?id=1hz1TcFROxxsL-MW1IZPQABV4lc8LCApz","https://drive.google.com/open?id=1Ml7kmEG7e8sUBYEbLtHdmfuUT5cb9o0V","https://drive.google.com/open?id=1pkdJRV1DClSM98XA3VwF7jRDwzbsyode","https://drive.google.com/open?id=1PijOU-tKqnKNgMBvCMD2R8rDdIXFylu8","https://drive.google.com/open?id=1VAbQS4O24_ZaE661yvYvvJN_OCXEpYd5","https://drive.google.com/open?id=1EaDchvSl1AIMyyJAmfn9-nFuevCYZD3J","https://drive.google.com/open?id=1YjA9_EsgTAB1bz0Lc5HwDSeMvsbd44jT","https://drive.google.com/open?id=1wvlewEs5330MiWoI69oV9FUMypn6QWeK","https://drive.google.com/open?id=1FkI2VRHY7JNfgpve4aOkhsHQRkxjNTSN","https://drive.google.com/open?id=1SIHOKIuVrz4Di1FKnAzkdOb9Dq0GCZoM","https://drive.google.com/open?id=1BFQnLO6dNTp_MpKmaV6m0gXuhwUFnAIF","https://drive.google.com/open?id=1cd9s8aT_s54j1TStQ0gr8cjltaznlqFE","https://drive.google.com/open?id=1hwuqTZnw06JKjDd7MGN-VLouO_GhzQQ9","https://drive.google.com/open?id=10Sds0nvhcJ-gNZDQQNg75N8fF8YeEA8u","https://drive.google.com/open?id=19AGzsoTcOFj3HQvzeO-IhBQHoF9d3mWj","https://drive.google.com/open?id=1K-OkhfqxU9-ypRySZnv_GIg2XHZsQmSe","https://drive.google.com/open?id=1v8ycFw4HHcEBH6IoURV6JlCJtnQoqqaH","https://drive.google.com/open?id=1hL0Fch2oveNQ53wggvbaVxWnaLxIJxIX","https://drive.google.com/open?id=1lkQth6j5MS_c620skdS6B6aQenXX-feL","https://drive.google.com/open?id=1ClxKTbQBbursLpzmDgvdgTTqctZnEg9o","https://drive.google.com/open?id=1jUftVSkazkE7W87FzAYfFEUA-_L2aEig","https://drive.google.com/open?id=1xxQ1S7zq3DWxCMXWFUWf_HqmvAIPbsCP","https://drive.google.com/open?id=1V23PoFUFeIOKmfbzZhxm91FFnIFhnfls","https://drive.google.com/open?id=1yqAYMDT-RVIJD8fsCMaIG4KLGLKqQJTo","https://drive.google.com/open?id=1D3sTrnbW6U8ggZkN9cEK9-Y0lbOWFy0k","https://drive.google.com/open?id=1Ldqa9lT1zC3z34Hm5Fp8KANA3jcd6Y9J","https://drive.google.com/open?id=1SFfL4NG0BxbcThDFc1QP0drVl-iWBqWW","https://drive.google.com/open?id=1GWdCjpgcpTNhiyAry4B18uJPUAOm9aXj","https://drive.google.com/open?id=1bn9VNIeUHtbIwXJtPUyEdNRB4IzUUCBe"};
                TDList = new String[]{"27 exercices en mecanique des fluides - université d'Angers","41 exercices + corrigés en mécanique des fluides - université Joseph Fourier","comolet_exo_01","comolet_exo_02","exercices sur hydrostatique , dynamique des fluides parfaits et réels","exercices sur quantité de mouvement","mdf-tdcorrigés-usthb","TD01","TD02","TD03","TP02","TP02sol"};
                Turi = new String[]{"https://drive.google.com/open?id=1P23fPZGWc5W1HtY0TYRrBDhH-CNH5Uv6","https://drive.google.com/open?id=1GJ_RRKQLr-GPKfyE7F7jWm1StM--2Xqg","https://drive.google.com/open?id=1lFzm4XybAm4XviAkultaMDXGi0z8FvCZ","https://drive.google.com/open?id=1o88LyauZtQZ3oG-dbO8TEk-PxAmM5aG7","https://drive.google.com/open?id=1NQyd6GGBFkyc6fAFWFNhIi9Yi8bmJPj7","https://drive.google.com/open?id=1Zf0bBC6X0thSCwR2j0xgtbO-609imlV_","https://drive.google.com/open?id=1PPb8hqkIXF-y0ujZaIiXhCRl2Rc2ecAj","https://drive.google.com/open?id=1f2JROxTL033LKAXRNyPg9zaH2abLDRB0","https://drive.google.com/open?id=10gahsK1OgsJ_Po6ho5Zt2ZU5t_QOoPdo","https://drive.google.com/open?id=1g-8vtDTFOZXUFeSClcgsu3e3yb86IywB","https://drive.google.com/open?id=14xSqnS4hNkRLK9ivuNSUZfJPUkJWHy68","https://drive.google.com/open?id=1F7Z-4zRGka_20psEJs0iCAUssDvuuIQw"};
                ExamList = new String[]{"Examen 02-03","Examen 05-06","Examen 06-07","examen MDF - ecole polytechnique federale de la usanne","examen MDF + corrigé 2009 - ecole polytechnique federale de la usanne","examen MDF- ecole polytechnique federale de la usanne","examen- ecole polytechnique federale de la usanne","Interro","Sujets MDF"};
                ExamUri = new String[]{"https://drive.google.com/open?id=12w3ETAHMCyXAecuDiv46nAQA4mhDEAgv","https://drive.google.com/open?id=1ql1moNUCKcFnUQUffdqdrJQWORwnQYu1","https://drive.google.com/open?id=1E-abPbj4u49UbQYZTJ7Zx6yX359qkyKP","https://drive.google.com/open?id=1qcsRqJu74BfLhJyseJSye-sqwDm4ul1a","https://drive.google.com/open?id=1uN9fwadvjuTbz0yK7LGPxeRFiSJZohBb","https://drive.google.com/open?id=1p9-XBE0dnTpdWMQafR7GDrTL9TvM4az1","https://drive.google.com/open?id=1jErzKVihCuPuTCvEpwXJpMnVJOtQys3a","https://drive.google.com/open?id=1vNkFYjYFNCL1DdQsJBn6qQHoMaOOb9eI","https://drive.google.com/open?id=1ozGBnxItPtS9lBNQmOwTpYAP1666TKK5"};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 28://electronique /tp non inclu
                gridList = new String[]{"CH3 cour avec exercice  quadripole","ch4 filtre cour et exercice","cour 3 .ch2 le regime  permanent","cour 1 electronique","cour3 quadripole","cours  electronique generale22052019","Electricite generale","Electronique _ fondements et applications","Electronique Générale_Meriche Faiza 2015","electronique","File0008","filtres","For the love of physics","inbound-369058821","lexique_mecanique_anglais_francais","réseaux linéaires","résumer diodech5","sol ch4 le filtre. passif","suite cour1 thevenin norton-1","theorie_filtre","Thèvenin"};
                uri = new String[]{"https://drive.google.com/open?id=1CXYFBT9G9mynIXppR4OH6cetTOGYuUIP","https://drive.google.com/open?id=1hrY897l2oQ7Ms2QiyBFZQjgBj7zAk-Eg","https://drive.google.com/open?id=1Aw0nhWN8knwfVLx36NkO7dXd9VT4J5bq","https://drive.google.com/open?id=1SYbYaX0Nw53SRj6esdABSoYrEuaqDChj","https://drive.google.com/open?id=114FnI5KSVYiiIef-YYFH6XyBw6C1tFzo","https://drive.google.com/open?id=1-u_Dol5vCK40XukSAdvlgR9Gd-wT7z7Z","https://drive.google.com/open?id=1AHANIM5Gbj7RORV7xZZr1pus6zCp3tyh","https://drive.google.com/open?id=1tTdOvOeRAAxFmJl_vF-HwIgi2bw8tJE8","https://drive.google.com/open?id=1Srzgc-3IDbFIcHCDX758kNNB233uIguM","https://drive.google.com/open?id=1lg-Ca2xKGWG4gerf1koN9gGcB_qAOmDS","https://drive.google.com/open?id=1OiM3JeGoZS5Jojm_Yk_xGs7TAHLoe64R","https://drive.google.com/open?id=10XEweTfqwkbvmszUWfx1xcHO3B5Y2R11","https://drive.google.com/open?id=18sMOdMlabaDrMUISvviL92IAJ5W7DMjq","https://drive.google.com/open?id=11qqCZ_Is4GecfK3yfr7CgigBJhQuy45R","https://drive.google.com/open?id=1P0Wm4csJWLFiNDuldWBSw4DOukbb5cfi","https://drive.google.com/open?id=1AMUzn1cyLURQEBpk5Iw8N6Y2J1gRueqI","https://drive.google.com/open?id=1hQHtbWrnUU7IPGIbuKFgWcrzFSeUKHLI","https://drive.google.com/open?id=1RnAMt7kqrFqkdPFkLL-Tfxfv3icU_RZD","https://drive.google.com/open?id=1laiy9cZaneqd8GDq-cKGE7EcenA94nne","https://drive.google.com/open?id=12uAimlpD7H_dDUyhkTIKyHEBHogrGhKm","https://drive.google.com/open?id=1bo8eGigR-deEn3rK-Hw4Q24fyDY2Bw22"};
                TDList = new String[]{"alger1TP1electronic newregime  continu","correction TD4 filtre apssif","diodes_et_filtres_correction","exercices avec sol quadripole TD3","exercices sur ch2 differents  exerices nombre complexe et regime permanent et techniques","exercices-corriges-sur-filtres-passifs-pdf1","TD5 diode & redressement2018","TP4-présentation","TP5 .diodedocx"};
                Turi = new String[]{"https://drive.google.com/open?id=1WFYU4Xz9gs6wDEmN5ud40e5gOHyIs8dw","https://drive.google.com/open?id=1M_HZ6S8g5qLksP2EGrIxJSK-d75uvox6","https://drive.google.com/open?id=1-ikqBpPoHtSBHHUdTZ5uGiG7ApYlzu78","https://drive.google.com/open?id=1iUQrpauTzm8kDN9yejD5ULkmTIQmMoMS","https://drive.google.com/open?id=1bjrBD8fux4lfb6v-h2QJAg0-7-arTIPk","https://drive.google.com/open?id=1vLrJAtH5pDN9wOvSImwqnVolkE-oD4o9","https://drive.google.com/open?id=10dykJllaow93wctvChm1IJI5nroX6sUx","https://drive.google.com/open?id=197lsuvqypcAAm-XKU5ohlG1HDNjqZXOn","https://drive.google.com/open?id=1oCiE9QoIGG-JUF40zg-x0qoBkGqe1yIB"};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 29://spectroscopie
                gridList = new String[]{"CORPS  NOIR","NATURE DE LA LUMIERE","Notes de cours Effet Compton","Spectroscopie","version","VITESSE DE LA LUMIERE"};
                uri = new String[]{"https://drive.google.com/open?id=1JtBUV-8Mwy7H3AKwxygee8azLSWOvVac","https://drive.google.com/open?id=1YqlGUWFW8hwtX_qLm6EyBzo0ABn1QuEp","https://drive.google.com/open?id=123AdwC59uQnKP5LFuWBd-G0P6fyiVKPc","https://drive.google.com/open?id=1VK5bMq1Qg9UKgIhfeDjsu851DDLyfr9q","https://drive.google.com/open?id=1T-llXOH4gFkvC1z9mvgs-8vOqdmkCYSi","https://drive.google.com/open?id=1WbRn5Ye2B7CJrkNkfFezSHJXBmjuaxRR"};
                TDList = new String[]{"TD spectro"};
                Turi = new String[]{"https://drive.google.com/open?id=1DEFor0C0PXQSUlYtZujeC72TYFWAmtMu"};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 31://MQ2
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 32://physique statistique
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 33://relativite
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 34://math
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 35://onde
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 36://numerique
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 37://particule
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 39://solide
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;

            case 40://nucleaire
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 41://chaleur
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 42://atomique
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 43://tp atomique
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 44://tp spectro
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 45://nouveau materiaux
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;
            case 46://ethique
                gridList = new String[]{};
                uri = new String[]{};
                TDList = new String[]{};
                Turi = new String[]{};
                ExamList = new String[]{};
                ExamUri = new String[]{};
                intents(gridList, uri, TDList, Turi, ExamList, ExamUri);
                break;

            case 48:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 49:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 50:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 52:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 53:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;

            case 54:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 55:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 56:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 57:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 58:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 60:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 61:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 62:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 63:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 64:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 65:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 66:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 67:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;

            case 68:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 70:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 71:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 72:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 73:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 74:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 75:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;
            case 76:
                Toast.makeText(this, "On train de Developpement", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public void intents(String[] myGridList, String[] myUri, String[] myTdList, String[] mytdUri, String[] myExamList, String[] myExamUri) {

        ArrayList<String> mUri = new ArrayList<>();
        mUri.addAll(Arrays.asList(myUri));
        ArrayList<String> mCours = new ArrayList<>();
        mCours.addAll(Arrays.asList(myGridList));
        ArrayList<String> mTdList = new ArrayList<>();
        mTdList.addAll(Arrays.asList(myTdList));
        ArrayList<String> mTdUri = new ArrayList<>();
        mTdUri.addAll(Arrays.asList(mytdUri));
        ArrayList<String> mExamList = new ArrayList<>();
        mExamList.addAll(Arrays.asList(myExamList));
        ArrayList<String> mExamUri = new ArrayList<>();
        mExamUri.addAll(Arrays.asList(myExamUri));
        PagerAdapter.setS(mCours, mUri, mTdList, mTdUri, mExamList, mExamUri);
        Intent intent = new Intent(this, Contenent.class);
        startActivity(intent);
    }

}
