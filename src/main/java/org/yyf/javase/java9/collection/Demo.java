package org.yyf.javase.java9.collection;

import org.junit.Test;
import org.yyf.javase.Color;
import org.yyf.javase.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by @author yyf on 2018/11/22.
 */
public class Demo {
  @Test
  public void test() {
//    List<Integer> list = List.of(3951490, 4145186, 4145190, 4145212, 4145214, 4145215, 4145217, 4145223, 4145229, 4145238, 4155168, 4155175, 4155188, 4155224, 4155235, 4155245, 4155250, 4155255, 4155265, 4155273, 4155292, 4155301, 4155308, 4155315, 4155329, 4155344, 4155352, 4160166, 4160171, 4160186, 4160219, 4160235, 4160280, 4162370, 5078613, 5816631, 5816889, 5836755, 5963635, 5996577, 6021177, 6074963, 6086303, 6086368, 6086801, 6087088, 6087702, 6087880, 6087884, 6088301, 6088909, 6088921, 6088949, 6089107, 6089122, 6089991, 6090141, 6090244, 6090273, 6090471, 6090548, 6090564, 6090721, 6090811, 6090824, 6090914, 6090917, 6090922, 6090923, 6091136, 6091181, 6093709, 6093820, 6095753, 6095776, 6095961, 6096051, 6096500, 6101631, 6102292, 6102973, 6103021, 6103481, 6104764, 6105112, 6105480, 6106219, 6106221, 6106527, 6107010, 6107026, 6107290, 6107361, 6107889, 6107994, 6108281, 6108494, 6108552, 6108555, 6108891, 6109088, 6109282, 6109760, 6109840, 6109980, 6110011, 6110144, 6110174, 6110284, 6110329, 6110459, 6110501, 6110516, 6111979, 6112069, 6112076, 6112437, 6112611, 6112957, 6112966, 6113098, 6113320, 6113394, 6113426, 6113678, 6113739, 6114358, 6114439, 6114615, 6114678, 6114711, 6118037, 6118141, 6119081, 6119234, 6119262, 6119277, 6119358, 6119359, 6119433, 6119552, 6119835, 6119911, 6121858, 6121940, 6122323, 6122602, 6122684, 6122692, 6122708, 6122845, 6122849, 6123130, 6123135, 6123354, 6123438, 6123475, 6123529, 6123578, 6123640, 6123664, 6123783, 6123791, 6123911, 6124847, 6124865, 6124882, 6124925, 6125097, 6125354, 6125370, 6125440, 6125552, 6125613, 6125650, 6125891, 6127079, 6127201, 6127724, 6127999, 6128150, 6131855, 6131926, 6132356, 6132448, 6132557, 6132634, 6133101, 6133915, 6134371, 6134754, 6134837, 6135033, 6135037, 6135042, 6135062, 6135096, 6135280, 6135861, 6136100, 6136129, 6136320, 6136593, 6136664, 6136675, 6136775, 6136808, 6137037, 6137723, 6137724, 6138302, 6138313, 6138320, 6139010, 6139114, 6139300, 6139380, 6139395, 6139908, 6140860, 6141037, 6141085, 6141299, 6145659, 6145759, 6145948, 6146003, 6147011, 6147015, 6147204, 6147289, 6147381, 6149866, 6149870, 6149871, 6149872, 6149879, 6150069, 6150072, 6150079, 6150094, 6150099, 6150101, 6150188, 6150199, 6150201, 6150202, 6150206, 6150207, 6150211, 6150221, 6150286, 6150737, 6150867, 6151060, 6151191, 6151300, 6151399, 6152195, 6152671, 6152768, 6152806, 6152880, 6153031, 6153053, 6153122, 6157226, 6158386, 6158623, 6158645, 6159019, 6159754, 6159761, 6159820, 6160264, 6160380, 6161232, 6161319, 6162481, 6162488, 6162490, 6162506, 6162511, 6162591, 6162729, 6163665, 6163822, 6163943, 6163969, 6163993, 6164027, 6164061, 6164196, 6164626, 6164811, 6164828, 6164924, 6164931, 6165099, 6165286, 6165428, 6165430, 6165442, 6165542, 6165616, 6165618, 6165624, 6166224, 6166407, 6166463, 6167174, 6167248, 6167409, 6167678, 6167766, 6167911, 6167933, 6167975, 6168035, 6168082, 6168089, 6168180, 6168569, 6169288, 6169301, 6169413, 6169583, 6169782, 6169982, 6170313, 6170445, 6171758, 6171769, 6171824, 6171879, 6171892, 6171986, 6172556, 6172570, 6172848, 6173248, 6173273, 6173338, 6173394, 6173463, 6173488, 6173881, 6173890, 6174017, 6174267, 6176422, 6176751, 6176819, 6176856, 6177012, 6177254, 6177569, 6177732, 6178164, 6178165, 6178168, 6178218, 6178227, 6178242, 6178268, 6178305, 6178344, 6178398, 6178660, 6178746, 6178941, 6179059, 6179308, 6179913, 6179920, 6181903, 6181934, 6182009, 6182108, 6182213, 6182234, 6182868, 6183051, 6183058, 6183059, 6183062, 6183162, 6183242, 6183246, 6183477, 6183505, 6183607, 6183682, 6183797, 6183897, 6184903, 6185000, 6186184, 6186381, 6189344, 6190526, 6191892, 6192546, 6192672, 6193265, 6194259, 6196917, 6198950, 6199998, 6200103, 6200106, 6200108, 6200457, 6201408, 6201422, 6201497, 6201508, 6201772, 6204282, 6204445, 6204712, 6205341, 6209300, 6210602, 6210944, 6211122, 6211322, 6211412, 6212430, 6212448, 6212909, 6212947, 6213088, 6213620, 6213630, 6213846, 6213917, 6213919, 6214212, 6214302, 6214306, 6214687, 6214692, 6215018, 6215173, 6215603, 6216536, 6216583, 6216845, 6216864, 6216888, 6217156, 6218053, 6218249, 6218367, 6218411, 6218469, 6218498, 6218560, 6218742, 6218805, 6221659, 6222402, 6222484, 6222514, 6222681, 6223075, 6223170, 6223567, 6223740, 6223763, 6223846, 6223938, 6224449, 6224616, 6224852, 6224980, 6225301, 6225549, 6225601, 6225618, 6225619, 6225620, 6225717, 6225795, 6225798, 6225805, 6225973, 6225975, 6226045, 6226048, 6226191, 6226201, 6226224, 6226360, 6226366, 6226369, 6226448, 6226451, 6226481, 6226486, 6226553, 6226607, 6226657, 6226748, 6227160, 6227324, 6227557, 6227627, 6227650, 6227679, 6227725, 6227828, 6227902, 6227941, 6227980, 6228280, 6230541, 6230598, 6230948, 6230967, 6231032, 6231773, 6231931, 6231981, 6232028, 6232545, 6232641, 6232989, 6232990, 6233087, 6233257, 6233270, 6233280, 6233363, 6233415, 6233554, 6233607, 6233617, 6233707, 6238721, 6238762, 6238830, 6238831, 6238988, 6239241, 6239363, 6239435, 6239787, 6239867, 6239931, 6239938, 6239957, 6240465, 6240668, 6240834, 6240848, 6240885, 6241368, 6241371, 6241603, 6241635, 6241668, 6241674, 6241776, 6241892, 6241999, 6242250, 6242291, 6242896, 6242931, 6243025, 6243030, 6243082, 6243237, 6243272, 6243354, 6243627, 6243725, 6243732, 6243782, 6243819, 6244121, 6244615, 6244703, 6244716, 6244721, 6244801, 6244809, 6244834, 6244942, 6244991, 6245022, 6245531, 6245587, 6245956, 6246103, 6246246, 6246303, 6246403, 6246605, 6246689, 6247115, 6247351, 6247354, 6247364, 6247699, 6247782, 6247825, 6248017, 6248126, 6248159, 6248163, 6248193, 6248203, 6248260, 6248304, 6248321, 6248418, 6248478, 6248598, 6248687, 6251069, 6251199, 6251225, 6251245, 6251259, 6251261, 6251392, 6251476, 6251582, 6251746, 6251749, 6251804, 6251826, 6252202, 6252216, 6252277, 6252817, 6252914, 6252953, 6252970, 6253037, 6253211, 6253401, 6253467, 6253490, 6253684, 6253746, 6253766, 6253962, 6254649, 6254815, 6255410, 6255422, 6255433, 6255672, 6255778, 6256305, 6256394, 6256726, 6256763, 6256907, 6257007, 6257066, 6257225, 6257226, 6257330, 6257435, 6257523, 6257636, 6257762, 6257842, 6257904, 6258087, 6259299, 6259300, 6262235, 6262668, 6263147, 6263163, 6263667, 6263668, 6263671, 6263741, 6263758, 6263759, 6263768, 6263770, 6263815, 6263830, 6263881, 6263885, 6263893, 6263907, 6263908, 6263948, 6263984, 6263993, 6264044, 6264168, 6264293, 6264602, 6264795, 6265036, 6265140, 6265213, 6265221, 6265272, 6265284, 6265357, 6265403, 6265428, 6265722, 6265778, 6267571, 6267757, 6267761, 6267763, 6267851, 6268012, 6268033, 6268183, 6269732, 6269734, 6269853, 6270144, 6270327, 6270474, 6270506, 6270895, 6271185, 6271677, 6271876, 6272110, 6272275, 6272350, 6272512, 6272571, 6272641, 6272722, 6272821, 6272891, 6272917, 6273004, 6273418, 6274739, 6274938, 6274948, 6275030, 6275295, 6275378, 6275640, 6275895, 6276190, 6276396, 6276449, 6276703, 6278145, 6278217, 6278338, 6279027, 6279203, 6281079, 6281439, 6281440, 6281679, 6281816, 6282487, 6283119, 6283439, 6283661, 6283751, 6283753, 6288444, 6288717, 6288803, 6289207, 6289243, 6289743, 6289832, 6290421, 6290582, 6291441, 6291683, 6292088, 6292146, 6292266, 6292280, 6292389, 6292946, 6293074, 6293151, 6296222, 6296420, 6296727, 6296754, 6297154, 6297286, 6297304, 6297308, 6297321, 6297750, 6297773, 6297957, 6298067, 6298071, 6298138, 6298261, 6298309, 6298321, 6298412, 6298476, 6298498, 6298590, 6298965, 6298986, 6299040, 6299202, 6299968, 6300167, 6300423, 6300428, 6300585, 6300738, 6300889, 6301003, 6301004, 6301156, 6301233, 6301274, 6301277, 6301283, 6301294, 6301311, 6301312, 6301447, 6301551, 6301695, 6301780, 6301942, 6301950, 6302221, 6302222, 6302308, 6302323, 6302396, 6302417, 6303244, 6303363, 6303468, 6303545, 6303777, 6304221, 6304386, 6304485, 6304636, 6304666, 6304736, 6304756, 6304778, 6304779, 6304913, 6305005, 6305088, 6305112, 6305143, 6305192, 6305234, 6305280, 6305808, 6305865, 6305907, 6306023, 6306105, 6306285, 6306520, 6306574, 6306928, 6306969, 6307319, 6307487, 6307740, 6307975, 6308207, 6308430, 6309351, 6309444, 6309477, 6309618, 6309889, 6309902, 6310282, 6310416, 6310419, 6310562, 6310566, 6310715, 6310799, 6310889, 6310980, 6310986, 6310989, 6311027, 6311085, 6311227, 6311248, 6311286, 6311327, 6311341, 6311536, 6311628, 6311905, 6311911, 6311912, 6312015, 6312303, 6312434, 6312784, 6313213, 6313330, 6313457, 6313479, 6313520, 6313666, 6313687, 6313819, 6313836, 6313889, 6313968, 6314285, 6314353, 6314559, 6314643, 6314738, 6314809, 6314819, 6314831, 6314931, 6315020, 6315202, 6315863, 6316074, 6316238, 6316399, 6316464, 6316500, 6316610, 6316647, 6316655, 6316949, 6316952, 6316958, 6317138, 6317144, 6317244, 6317385, 6317387, 6317622, 6317624, 6317636, 6317694, 6317778, 6317890, 6317904, 6318102, 6318171, 6318219, 6318222, 6318225, 6318347, 6318396, 6318508, 6318513, 6318718, 6318872, 6318886, 6319025, 6319052, 6319072, 6319077, 6319138, 6319267, 6319328, 6319365, 6319366, 6319456, 6319468, 6319469, 6319480, 6319498, 6319499, 6319599, 6319601, 6319702, 6319896, 6320004, 6320068, 6320164, 6320214, 6321455, 6321629, 6321668, 6321707, 6321845, 6321921, 6321942, 6321944, 6322032, 6322059, 6322061, 6322065, 6322070, 6322072, 6322073, 6322074, 6322388, 6322565, 6322659, 6322763, 6322951, 6323017, 6323061, 6323143, 6323145, 6323284, 6323319, 6323553, 6323751, 6323895, 6323900, 6324017, 6324642, 6324674, 6324710, 6324787, 6324878, 6324909, 6324968, 6325006, 6325071, 6325075, 6325174, 6325261, 6325291, 6325480, 6325604, 6325663, 6325681, 6325684, 6325868, 6326409, 6326455, 6326567, 6326637, 6327773, 6327953, 6327959, 6328141, 6328281, 6328283, 6328381, 6328774, 6328787, 6329195, 6329256, 6329278, 6329377, 6330496, 6330564, 6330682, 6330770, 6330873, 6330920, 6330989, 6331017, 6331093, 6331167, 6331285, 6331286, 6331411, 6331425, 6331509, 6331547, 6331620, 6331861, 6332079, 6332345, 6332352, 6332446, 6332493, 6333675, 6333769, 6334016, 6334037, 6334079, 6334132, 6334183, 6334228, 6334302, 6334501, 6334544, 6334550, 6334785, 6335008, 6335218, 6335369, 6335377, 6335514, 6335516, 6335539, 6335631, 6335748, 6335910, 6336342, 6336364, 6336423, 6336459, 6336519, 6336670, 6336851, 6336915, 6336929, 6337004, 6337020, 6337046, 6337955, 6338502, 6338565, 6338666, 6339005, 6339171, 6339775, 6340501, 6340871, 6341107, 6341116, 6341926, 6342030, 6342032, 6342048, 6342381, 6342492, 6342517, 6344019, 6344230, 6345053, 6345138, 6345698, 6345836, 6346098, 6346219, 6346506, 6346827, 6347093, 6347525, 6347580, 6347609, 6347816, 6348321, 6349916, 6350202, 6350460, 6350579, 6350636, 6351296, 6351683, 6351786, 6351998, 6352061, 6352160, 6352294, 6352344, 6352368, 6352571, 6352575, 6352645, 6352798, 6353078, 6353188, 6353233, 6353310, 6353595, 6353597, 6353680, 6353883, 6354968, 6355072, 6355420, 6355464, 6355467, 6355595, 6355599, 6355644, 6355746, 6355923, 6356319, 6356386, 6356822, 6356824, 6356956, 6356997, 6357107, 6357110, 6357164, 6357173, 6357201, 6357214, 6357285, 6357386, 6357410, 6357465, 6357887, 6357899, 6358101, 6358128, 6358294, 6358329, 6358482, 6358483, 6358484, 6358485, 6358486, 6358487, 6358488, 6358489, 6358490, 6358498, 6358499, 6358500, 6358501, 6358502, 6358503, 6358504, 6358505, 6358506, 6358507, 6358508, 6358509, 6358510, 6358511, 6358512, 6358513, 6358514, 6358515, 6358516, 6358517, 6358518, 6358892, 6359003, 6360079, 6360170, 6360726, 6361080, 6361173, 6361524, 6361701, 6361932, 6361936, 6362112, 6363107, 6363193, 6363485, 6364556, 6364814, 6364989, 6364994, 6365132, 6365377, 6365825, 6365846, 6365978, 6366181, 6366298, 6366604, 6366651, 6366669, 6367004, 6367187, 6367944, 6368135, 6368276, 6368367, 6368525, 6368933, 6369458, 6369513, 6369567, 6369622, 6369647, 6369906, 6370227, 6370345, 6370346, 6370401, 6370497, 6370548, 6370747, 6372448, 6372541, 6372626, 6372741, 6372898, 6373099, 6373111, 6373424, 6373477, 6373542, 6374636, 6374728, 6374793, 6376677, 6377373, 6377380, 6377883, 6377916, 6379266, 6379311, 6379345, 6379779, 6380050, 6381439, 6381528, 6381546, 6381780, 6381781, 6381782, 6381783, 6381784, 6381785, 6381786, 6381787, 6381788, 6381789, 6381790, 6381791, 6381792, 6381793, 6381794, 6381795, 6381796, 6381797, 6381798, 6381799, 6381800, 6381801, 6381802, 6381803, 6381804, 6381805, 6381806, 6381807, 6381808, 6381809, 6382017, 6382061, 6383294, 6383480, 6384366, 6384486, 6384554, 6384815, 6384827, 6385847, 6386257, 6386372, 6386557, 6386880, 6387043, 6387057, 6387095, 6387125, 6387156, 6387374, 6387638, 6387644, 6388608, 6388888, 6389258, 6390210, 6390216, 6390219, 6390324, 6390342, 6390399, 6390407, 6390602, 6390793, 6392744, 6392773, 6393071, 6393330, 6393331, 6393398, 6393436, 6393627, 6393631, 6393714, 6393720, 6393727, 6393769, 6393846, 6393922, 6394301, 6394436, 6394544, 6394552, 6394923, 6394945, 6394964, 6395324, 6395399, 6395498, 6395515, 6395619, 6395783, 6395978, 6396336, 6396490, 6396530, 6396688, 6396882, 6398320, 6398463, 6398468, 6398538, 6398771, 6398917, 6398980, 6399708, 6399930, 6400146, 6400221, 6400692, 6400733, 6400780, 6400848, 6400859, 6400865, 6401117, 6401165, 6401392, 6401481, 6401524, 6401621, 6401769, 6401786, 6401808, 6401858, 6402519, 6402523, 6402726, 6402927, 6404930, 6405008, 6405287, 6405690, 6405736, 6405749, 6405853, 6406080, 6406109, 6406136, 6406480, 6406481, 6406482, 6406483, 6406484, 6406485, 6406486, 6406487, 6406488, 6406489, 6406490, 6406491, 6406492, 6406493, 6406494, 6406495, 6406496, 6406497, 6406498, 6406499, 6406500, 6406501, 6406502, 6406503, 6406504, 6406505, 6406506, 6406507, 6406508, 6406509, 6406510, 6406511, 6406512, 6406513, 6406514, 6406515, 6406516, 6406517, 6406518, 6406519, 6406520, 6406521, 6406522, 6406523, 6406524, 6406702, 6406746, 6407147, 6407165, 6407337, 6407400, 6407541, 6407712, 6408034, 6408105, 6408589, 6409143, 6409186, 6413166, 6413335, 6413629, 6413633, 6413677, 6413691, 6413767, 6414428, 6414486, 6414495, 6414531, 6414582, 6415153, 6415196, 6415207, 6415520, 6415597, 6415634, 6416084, 6416133, 6416428, 6416430, 6416531, 6416638, 6417227, 6417373, 6417436, 6417700, 6419179, 6419351, 6419808, 6420391, 6420516, 6420554, 6421187, 6421504, 6421790, 6421942, 6423114, 6423262, 6423498, 6423577, 6424098, 6425745, 6425833, 6426228, 6426257, 6426415, 6426490, 6426491, 6426722, 6427305, 6427363, 6427439, 6427445, 6427518, 6427525, 6427529, 6427700, 6428486, 6428686, 6430065, 6430160, 6430161, 6430373, 6430546, 6430550, 6430679, 6431513, 6431890, 6431999, 6432005, 6432533, 6432534, 6432633, 6432727, 6432976, 6433029, 6433030, 6433504, 6433541, 6433798, 6433803, 6433804, 6433903, 6433904, 6436181, 6438910, 6438935, 6440245, 6440454, 6440455, 6440645, 6440762, 6440763, 6441954, 6443082, 6443184, 6443656, 6443800, 6447255, 6447643, 6447729, 6447731, 6447985, 6451403, 6451452, 6453663, 6454016, 6454290, 6454703, 6456109, 6456188, 6456226, 6456293, 6456811, 6456821, 6457509, 6457605, 6457701, 6457967, 6457990, 6458011, 6458324, 6458538, 6458652, 6458797, 6460232, 6460276, 6460444, 6460592, 6460643, 6460662, 6460681, 6460795, 6460867, 6460898, 6461053, 6461330, 6461332, 6461333, 6461335, 6461336, 6461337, 6461338, 6461339, 6461340, 6461341, 6461342, 6461343, 6461344, 6461597, 6461722, 6461784, 6462028, 6462741, 6462868, 6462961, 6463043, 6463073, 6463074, 6463217, 6463322, 6463361, 6463583, 6463690, 6463783, 6463867, 6464504, 6464584, 6464925, 6466169, 6469985);

//    int size = list.size();
//    System.out.println(size);
  }

  @Test
  public void t() {
    ArrayList<Object> list = new ArrayList<>();
    Object o = list.get(0);
    System.out.println(o);
  }

  @Test
  public void name(final List<? extends Student> list) {
//    List<? extends Student> list = new ArrayList<>();
    for (Student student : list) {
      String name = student.getName();
    }

  }
}
