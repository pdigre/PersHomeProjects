package no.pdigre.chess.polyglot;

import no.pdigre.chess.base.Bitmap;
import no.pdigre.chess.base.IConst;
import no.pdigre.chess.fen.IPosition;

/**
 * Use Polyglot Zobrist hashkey format as in 
 * http://hardy.uhasselt.be/Toga/book_format.html
 * 
 * @author Per Digre
 *
 */
public class ZobristKey {

	public static final long exclusionKey = 0x5472a27925a2a2f5L;
	
	public static final long pawn[][] = {{0x79ad695501e7d1e8L, 0x8249a47aee0e41f7L, 0x637a7780decfc0d9L, 0x19fc8a768cf4b6d4L, 0x7bcbc38da25a7f3cL, 0x5093417aa8a7ed5eL, 0x7fb9f855a997142L, 0x5355f900c2a82dc7L, 0xe99d662af4243939L, 0xa49cd132bfbf7cc4L, 0xce26c0b95c980d9L, 0xbb6e2924f03912eaL, 0x24c3c94df9c8d3f6L, 0xdabf2ac8201752fcL, 0xf145b6beccdea195L, 0x14acbaf4777d5776L, 0xf9b89d3e99a075c2L, 0x70ac4cd9f04f21f5L, 0x9a85ac909a24eaa1L, 0xee954d3c7b411f47L, 0x72b12c32127fed2bL, 0x54b3f4fa5f40d873L, 0x8535f040b9744ff1L, 0x27e6ad7891165c3fL, 0x8de8dca9f03cc54eL, 0xff07f64ef8ed14d0L, 0x92237ac237f3859L, 0x87bf02c6b49e2ae9L, 0x1920c04d47267bbdL, 0xae4a9346cc3f7cf2L, 0xa366e5b8c54f48b8L, 0x87b3e2b2b5c907b1L, 0x6304d09a0b3738c4L, 0x4f80f7a035dafb04L, 0x9a74acb964e78cb3L, 0x1e1032911fa78984L, 0x5bfea5b4712768e9L, 0x390e5fb44d01144bL, 0xb3f22c3d0b0b38edL, 0x9c1633264db49c89L, 0x7b32f7d1e03680ecL, 0xef927dbcf00c20f2L, 0xdfd395339cdbf4a7L, 0x6503080440750644L, 0x1881afc9a3a701d6L, 0x506aacf489889342L, 0x5b9b63eb9ceff80cL, 0x2171e64683023a08L, 0xede6c87f8477609dL, 0x3c79a0ff5580ef7fL, 0xf538639ce705b824L, 0xcf464cec899a2f8aL, 0x4a750a09ce9573f7L, 0xb5889c6e15630a75L, 0x5a7e8a57db91b77L, 0xb9fd7620e7316243L, 0x73a1921916591cbdL, 0x70eb093b15b290ccL, 0x920e449535dd359eL, 0x43fcae60cc0eba0L, 0xa246637cff328532L, 0x97d7374c60087b73L, 0x86536b8cf3428a8cL, 0x799e81f05bc93f31L},{0xe83a908ff2fb60caL, 0xfbbad1f61042279L, 0x3290ac3a203001bfL, 0x75834465489c0c89L, 0x9c15f73e62a76ae2L, 0x44db015024623547L, 0x2af7398005aaa5c7L, 0x9d39247e33776d41L, 0x239f8b2d7ff719ccL, 0x5db4832046f3d9e5L, 0x11355146fd56395L, 0x40bdf15d4a672e32L, 0xd021ff5cd13a2ed5L, 0x9605d5f0e25ec3b0L, 0x1a083822ceafe02dL, 0xd7e765d58755c10L, 0x4bb38de5e7219443L, 0x331478f3af51bbe6L, 0xf3218f1c9510786cL, 0x82c7709e781eb7ccL, 0x7d11cdb1c3b7adf0L, 0x7449bbff801fed0bL, 0x679f848f6e8fc971L, 0x5d1a1ae85b49aa1L, 0x24aa6c514da27500L, 0xc9452ca81a09d85dL, 0x7b0500ac42047ac4L, 0xb4ab30f062b19abfL, 0x19f3c751d3e92ae1L, 0x87d2074b81d79217L, 0x8dbd98a352afd40bL, 0xaa649c6ebcfd50fcL, 0x735e2b97a4c45a23L, 0x3575668334a1dd3bL, 0x9d1bc9a3dd90a94L, 0x637b2b34ff93c040L, 0x3488b95b0f1850fL, 0xa71b9b83461cbd93L, 0x14a68fd73c910841L, 0x4c9f34427501b447L, 0xfcf7fe8a3430b241L, 0x5c82c505db9ab0faL, 0x51ebdc4ab9ba3035L, 0x9f74d14f7454a824L, 0xbf983fe0fe5d8244L, 0xd310a7c2ce9b6555L, 0x1fcbacd259bf02e7L, 0x18727070f1bd400bL, 0x96d693460cc37e5dL, 0x4de0b0f40f32a7b8L, 0x6568fca92c76a243L, 0x11d505d4c351bd7fL, 0x7ef48f2b83024e20L, 0xb9bc6c87167c33e7L, 0x8c74c368081b3075L, 0x3253a729b9ba3ddeL, 0xec16ca8aea98ad76L, 0x63dc359d8d231b78L, 0x93c5b5f47356388bL, 0x39f890f579f92f88L, 0x5f0f4a5898171bb6L, 0x42880b0236e4d951L, 0x6d2bdcdae2919661L, 0x42e240cb63689f2fL}};
	public static final long rook[][] = {{0xd18d8549d140caeaL, 0x1cfc8bed0d681639L, 0xca1e3785a9e724e5L, 0xb67c1fa481680af8L, 0xdfea21ea9e7557e3L, 0xd6b6d0ecc617c699L, 0xfa7e393983325753L, 0xa09e8c8c35ab96deL, 0x7983eed3740847d5L, 0x298af231c85bafabL, 0x2680b122baa28d97L, 0x734de8181f6ec39aL, 0x53898e4c3910da55L, 0x1761f93a44d5aefeL, 0xe4dbf0634473f5d2L, 0x4ed0fe7e9dc91335L, 0x261e4e4c0a333a9dL, 0x219b97e26ffc81bdL, 0x66b4835d9eafea22L, 0x4cc317fb9cddd023L, 0x50b704cab602c329L, 0xedb454e7badc0805L, 0x9e17e49642a3e4c1L, 0x66c1a2a1a60cd889L, 0x36f60e2ba4fa6800L, 0x38b6525c21a42b0eL, 0xf4f5d05c10cab243L, 0xcf3f4688801eb9aaL, 0x1ddc0325259b27deL, 0xb9571fa04dc089c8L, 0xd7504dfa8816edbbL, 0x1fe2cca76517db90L, 0xe699ed85b0dfb40dL, 0xd4347f66ec8941c3L, 0xf4d14597e660f855L, 0x8b889d624d44885dL, 0x258e5a80c7204c4bL, 0xaf0c317d32adaa8aL, 0x9c4cd6257c5a3603L, 0xeb3593803173e0ceL, 0xb090a7560a968e3L, 0x2cf9c8ca052f6e9fL, 0x116d0016cb948f09L, 0xa59e0bd101731a28L, 0x63767572ae3d6174L, 0xab4f6451cc1d45ecL, 0xc2a1e7b5b459aeb5L, 0x2472f6207c2d0484L, 0x804456af10f5fb53L, 0xd74bbe77e6116ac7L, 0x7c0828dd624ec390L, 0x14a195640116f336L, 0x2eab8ca63ce802d7L, 0xc6e57a78fbd986e0L, 0x58efc10b06a2068dL, 0xabeeddb2dde06ff1L, 0x12a8f216af9418c2L, 0xd4490ad526f14431L, 0xb49c3b3995091a36L, 0x5b45e522e4b1b4efL, 0xa1e9300cd8520548L, 0x49787fef17af9924L, 0x3219a39ee587a30L, 0xebe9ea2adf4321c7L},{0x10dcd78e3851a492L, 0xb438c2b67f98e5e9L, 0x43954b3252dc25e5L, 0xab9090168dd05f34L, 0xce68341f79893389L, 0x36833336d068f707L, 0xdcdd7d20903d0c25L, 0xda3a361b1c5157b1L, 0xaf08da9177dda93dL, 0xac12fb171817eee7L, 0x1fff7ac80904bf45L, 0xa9119b60369ffebdL, 0xbfced1b0048eac50L, 0xb67b7896167b4c84L, 0x9b3cdb65f82ca382L, 0xdbc27ab5447822bfL, 0x6dd856d94d259236L, 0x67378d8eccef96cbL, 0x9fc477de4ed681daL, 0xf3b8b6675a6507ffL, 0xc3a9dc228caac9e9L, 0xc37b45b3f8d6f2baL, 0xb559eb1d04e5e932L, 0x1b0cab936e65c744L, 0x7440fb816508c4feL, 0x9d266d6a1cc0542cL, 0x4dda48153c94938aL, 0x74c04bf1790c0efeL, 0xe1925c71285279f5L, 0x8a8e849eb32781a5L, 0x73973751f12dd5eL, 0xa319ce15b0b4db31L, 0x94ebc8abcfb56daeL, 0xd7a023a73260b45cL, 0x72c8834a5957b511L, 0x8f8419a348f296bfL, 0x1e152328f3318deaL, 0x4838d65f6ef6748fL, 0xd6bf7baee43cac40L, 0x13328503df48229fL, 0xdd69a0d8ab3b546dL, 0x65ca5b96b7552210L, 0x2fd7e4b9e72cd38cL, 0x51d2b1ab2ddfb636L, 0x9d1d84fcce371425L, 0xa44cfe79ae538bbeL, 0xde68a2355b93cae6L, 0x9fc10d0f989993e0L, 0x3a938fee32d29981L, 0x2c5e9deb57ef4743L, 0x1e99b96e70a9be8bL, 0x764dbeae7fa4f3a6L, 0xaac40a2703d9bea0L, 0x1a8c1e992b941148L, 0x73aa8a564fb7ac9eL, 0x604d51b25fbf70e2L, 0x8fe88b57305e2ab6L, 0x89039d79d6fc5c5cL, 0x9bfb227ebdf4c5ceL, 0x7f7cc39420a3a545L, 0x3f6c6af859d80055L, 0xc8763c5b08d1908cL, 0x469356c504ec9f9dL, 0x26e6db8ffdf5adfeL}};
	public static final long knight[][] = {{0x3bba57b68871b59dL, 0xdf1d9f9d784ba010L, 0x94061b871e04df75L, 0x9315e5eb3a129aceL, 0x8bd35cc38336615L, 0xfe9a44e9362f05faL, 0x78e37644e7cad29eL, 0xc547f57e42a7444eL, 0x4f2a5cb07f6a35b3L, 0xa2f61bb6e437fdb5L, 0xa74049dac312ac71L, 0x336f52f8ff4728e7L, 0xd95be88cd210ffa7L, 0xd7f4f2448c0ceb81L, 0xf7a255d83bc373f8L, 0xd2b7adeeded1f73fL, 0x4c0563b89f495ac3L, 0x18fcf680573fa594L, 0xfcaf55c1bf8a4424L, 0x39b0bf7dde437ba2L, 0xf3a678cad9a2e38cL, 0x7ba2484c8a0fd54eL, 0x16b9f7e06c453a21L, 0x87d380bda5bf7859L, 0x35cab62109dd038aL, 0x32095b6d4ab5f9b1L, 0x3810e399b6f65ba2L, 0x9d1d60e5076f5b6fL, 0x7a1ee967d27579e2L, 0x68ca39053261169fL, 0x8cffa9412eb642c1L, 0x40e087931a00930dL, 0x9d1dfa2efc557f73L, 0x52ab92beb9613989L, 0x528f7c8602c5807bL, 0xd941aca44b20a45bL, 0x4361c0ca3f692f12L, 0x513e5e634c70e331L, 0x77a225a07cc2c6bdL, 0xa90b24499fcfafb1L, 0x284c847b9d887aaeL, 0x56fd23c8f9715a4cL, 0xcd9a497658a5698L, 0x5a110c6058b920a0L, 0x4208fe9e8f7f2d6L, 0x7a249a57ec0c9ba2L, 0x1d1260a51107fe97L, 0x722ff175f572c348L, 0x5e11e86d5873d484L, 0xed9b915c66ed37eL, 0xb0183db56ffc6a79L, 0x506e6744cd974924L, 0x881b82a13b51b9e2L, 0x9a9632e65904ad3cL, 0x742e1e651c60ba83L, 0x4feabfbbdb619cbL, 0x48cbff086ddf285aL, 0x99e7afeabe000731L, 0x93c42566aef98ffbL, 0xa865a54edcc0f019L, 0xd151d86adb73615L, 0xdab9fe6525d89021L, 0x1b85d488d0f20cc5L, 0xf678647e3519ac6eL},{0xdd2c5bc84bc8d8fcL, 0xae623fd67468aa70L, 0xff6712ffcfd75ea1L, 0x930f80f4e8eb7462L, 0x45f20042f24f1768L, 0xbb215798d45df7afL, 0xefac4b70633b8f81L, 0x56436c9fe1a1aa8dL, 0xaa969b5c691ccb7aL, 0x43539603d6c55602L, 0x1bede3a3aef53302L, 0xdec468145b7605f6L, 0x808bd68e6ac10365L, 0xc91800e98fb99929L, 0x22fe545401165f1cL, 0x7eed120d54cf2dd9L, 0x28aed140be0bb7ddL, 0x10cff333e0ed804aL, 0x91b859e59ecb6350L, 0xb415938d7da94e3cL, 0x21f08570f420e565L, 0xded2d633cad004f6L, 0x65942c7b3c7e11aeL, 0xa87832d392efee56L, 0xaef3af4a563dfe43L, 0x480412bab7f5be2aL, 0xaf2042f5cc5c2858L, 0xef2f054308f6a2bcL, 0x9bc5a38ef729abd4L, 0x2d255069f0b7dab3L, 0x5648f680f11a2741L, 0xc5cc1d89724fa456L, 0x4dc4de189b671a1cL, 0x66f70b33fe09017L, 0x9da4243de836994fL, 0xbce5d2248682c115L, 0x11379625747d5af3L, 0xf4f076e65f2ce6f0L, 0x52593803dff1e840L, 0x19afe59ae451497fL, 0xf793c46702e086a0L, 0x763c4a1371b368fdL, 0x2df16f761598aa4fL, 0x21a007933a522a20L, 0xb3819a42abe61c87L, 0xb46ee9c5e64a6e7cL, 0xc07a3f80c31fb4b4L, 0x51039ab7712457c3L, 0x9ae182c8bc9474e8L, 0xb05ca3f564268d99L, 0xcfc447f1e53c8e1bL, 0x4850e73e03eb6064L, 0x2c604a7a177326b3L, 0xbf692b38d079f23L, 0xde336a2a4bc1c44bL, 0xd7288e012aeb8d31L, 0x6703df9d2924e97eL, 0x8ec97d2917456ed0L, 0x9c684cb6c4d24417L, 0xfc6a82d64b8655fbL, 0xf9b5b7c4acc67c96L, 0x69b97db1a4c03dfeL, 0xe755178d58fc4e76L, 0xa4fc4bd4fc5558caL}};
	public static final long bishop[][] = {{0x2fe4b17170e59750L, 0xe8d9ecbe2cf3d73fL, 0xb57d2e985e1419c7L, 0x572b974f03ce0bbL, 0xa8d7e4dab780a08dL, 0x4715ed43e8a45c0aL, 0xc330de426430f69dL, 0x23b70edb1955c4bfL, 0x49353fea39ba63b1L, 0xf85b2b4fbcde44b7L, 0xbe7444e39328a0acL, 0x3e2b8bcbf016d66dL, 0x964e915cd5e2b207L, 0x1725cabfcb045b00L, 0x7fbf21ec8a1f45ecL, 0x11317ba87905e790L, 0xe94c39a54a98307fL, 0xaa70b5b4f89695a2L, 0x3bdbb92c43b17f26L, 0xcccb7005c6b9c28dL, 0x18a6a990c8b35ebdL, 0xfc7c95d827357afaL, 0x1fca8a92fd719f85L, 0x1dd01aafcd53486aL, 0xdbc0d2b6ab90a559L, 0x94628d38d0c20584L, 0x64972d68dee33360L, 0xb9c11d5b1e43a07eL, 0x2de0966daf2f8b1cL, 0x2e18bc1ad9704a68L, 0xd4dba84729af48adL, 0xb7a0b174cff6f36eL, 0xcffe1939438e9b24L, 0x79999cdff70902cbL, 0x8547eddfb81ccb94L, 0x7b77497b32503b12L, 0x97fcaacbf030bc24L, 0x6ced1983376fa72bL, 0x7e75d99d94a70f4dL, 0xd2733c4335c6a72fL, 0x9ff38fed72e9052fL, 0x9f65789a6509a440L, 0x981dcd296a8736dL, 0x5873888850659ae7L, 0xc678b6d860284a1cL, 0x63e22c147b9c3403L, 0x92fae24291f2b3f1L, 0x829626e3892d95d7L, 0x7a76956c3eafb413L, 0x7f5126dbba5e0ca7L, 0x12153635b2c0cf57L, 0x7b3f0195fc6f290fL, 0x5544f7d774b14aefL, 0x56c074a581ea17feL, 0xe7f28ecd2d49eecdL, 0xe479ee5b9930578cL, 0x7f9d1a2e1ebe1327L, 0x5d0a12f27ad310d1L, 0x3bc36e078f7515d7L, 0x4da8979a0041e8a9L, 0x950113646d1d6e03L, 0x7b4a38e32537df62L, 0x8a1b083821f40cb4L, 0x3d5774a11d31ab39L},{0x501f65edb3034d07L, 0x907f30421d78c5deL, 0x1a804aadb9cfa741L, 0xce2a38c344a6eedL, 0xd363eff5f0977996L, 0x2cd16e2abd791e33L, 0x58627e1a149bba21L, 0x7f9b6af1ebf78bafL, 0x364f6ffa464ee52eL, 0x6c3b8e3e336139d3L, 0xf943aee7febf21b8L, 0x88e049589c432e0L, 0xd49503536abca345L, 0x3a6c27934e31188aL, 0x957baf61700cff4eL, 0x37624ae5a48fa6e9L, 0xb344c470397bba52L, 0xbac7a9a18531294bL, 0xecb53939887e8175L, 0x565601c0364e3228L, 0xef1955914b609f93L, 0x16f50edf91e513afL, 0x56963b0dca418fc0L, 0xd60f6dcedc314222L, 0x99170a5dc3115544L, 0x59b97885e2f2ea28L, 0xbc4097b116c524d2L, 0x7a13f18bbedc4ff5L, 0x71582401c38434dL, 0xb422061193d6f6a7L, 0xb4b81b3fa97511e2L, 0x65d34954daf3cebdL, 0xc7d9f16864a76e94L, 0x7bd94e1d8e17debcL, 0xd873db391292ed4fL, 0x30f5611484119414L, 0x565c31f7de89ea27L, 0xd0e4366228b03343L, 0x325928ee6e6f8794L, 0x6f423357e7c6a9f9L, 0x35dd37d5871448afL, 0xb03031a8b4516e84L, 0xb3f256d8aca0b0b9L, 0xfd22063edc29fcaL, 0xd9a11fbb3d9808e4L, 0x3a9bf55ba91f81caL, 0xc8c93882f9475f5fL, 0x947ae053ee56e63cL, 0xbbe83f4ecc2bdecbL, 0xcd454f8f19c5126aL, 0xc62c58f97dd949bfL, 0x693501d628297551L, 0xb9ab4ce57f2d34f3L, 0x9255abb50d532280L, 0xebfafa33d7254b59L, 0xe9f6082b05542e4eL, 0x98954d51fff6580L, 0x8107fccf064fcf56L, 0x852f54934da55cc9L, 0x9c7e552bc76492fL, 0xe9f6760e32cd8021L, 0xa3bc941d0a5061cbL, 0xba89142e007503b8L, 0xdc842b7e2819e230L}};
	public static final long queen[][] = {{0x720bf5f26f4d2eaaL, 0x1c2559e30f0946beL, 0xe328e230e3e2b3fbL, 0x87e79e5a57d1d13L, 0x8dd9bdfd96b9f63L, 0x64d0e29eea8838b3L, 0xddf957bc36d8b9caL, 0x6ffe73e81b637fb3L, 0x93b633abfa3469f8L, 0xe846963877671a17L, 0x59ac2c7873f910a3L, 0x660d3257380841eeL, 0xd813f2fab7f5c5caL, 0x4112cf68649a260eL, 0x443f64ec5a371195L, 0xb0774d261cc609dbL, 0xb5635c95ff7296e2L, 0xed2df21216235097L, 0x4a29c6465a314cd1L, 0xd83cc2687a19255fL, 0x506c11b9d90e8b1dL, 0x57277707199b8175L, 0xcaf21ecd4377b28cL, 0xc0c0f5a60ef4cdcfL, 0x7c45d833aff07862L, 0xa5b1cfdba0ab4067L, 0x6ad047c430a12104L, 0x6c47bec883a7de39L, 0x944f6de09134dfb6L, 0x9aeba33ac6ecc6b0L, 0x52e762596bf68235L, 0x22af003ab672e811L, 0x50065e535a213cf6L, 0xde0c89a556b9ae70L, 0xd1e0ccd25bb9c169L, 0x6b17b224bad6bf27L, 0x6b02e63195ad0cf8L, 0x455a4b4cfe30e3f5L, 0x9338e69c052b8e7bL, 0x5092ef950a16da0bL, 0x67fef95d92607890L, 0x31865ced6120f37dL, 0x3a6853c7e70757a7L, 0x32ab0edb696703d3L, 0xee97f453f06791edL, 0x6dc93d9526a50e68L, 0x78edefd694af1eedL, 0x9c1169fa2777b874L, 0x6bfa9aae5ec05779L, 0x371f77e76bb8417eL, 0x3550c2321fd6109cL, 0xfb4a3d794a9a80d2L, 0xf43c732873f24c13L, 0xaa9119ff184cccf4L, 0xb69e38a8965c6b65L, 0x1f2b1d1f15f6dc9cL, 0xb5b4071dbfc73a66L, 0x8f9887e6078735a1L, 0x8de8a1c7797da9bL, 0xfcb6be43a9f2fe9bL, 0x49a7f41061a9e60L, 0x9f91508bffcfc14aL, 0xe3273522064480caL, 0xcd04f3ff001a4778L},{0x1bda0492e7e4586eL, 0xd23c8e176d113600L, 0x252f59cf0d9f04bbL, 0xb3598080ce64a656L, 0x993e1de72d36d310L, 0xa2853b80f17f58eeL, 0x1877b51e57a764d5L, 0x1f837cc7350524L, 0x241260ed4ad1e87dL, 0x64c8e531bff53b55L, 0xca672b91e9e4fa16L, 0x3871700761b3f743L, 0xf95cffa23af5f6f4L, 0x8d14dedb30be846eL, 0x3b097adaf088f94eL, 0x21e0bd5026c619bfL, 0xb8d91274b9e9d4fbL, 0x1db956e450275779L, 0x4fc8e9560f91b123L, 0x63573ff03e224774L, 0x647dfedcd894a29L, 0x7884d9bc6cb569d8L, 0x7fba195410e5ca30L, 0x106c09b972d2e822L, 0x98f076a4f7a2322eL, 0x70cb6af7c2d5bcf0L, 0xb64be8d8b25396c1L, 0xa9aa4d20db084e9bL, 0x2e6d02c36017f67fL, 0xefed53d75fd64e6bL, 0xd9f1f30ccd97fb09L, 0xa2ebee47e2fbfce1L, 0xfc87614baf287e07L, 0x240ab57a8b888b20L, 0xbf8d5108e27e0d48L, 0x61bdd1307c66e300L, 0xb925a6cd0421aff3L, 0x3e003e616a6591e9L, 0x94c3251f06f90cf3L, 0xbf84470805e69b5fL, 0x758f450c88572e0bL, 0x1b6baca2ae4e125bL, 0x61cf4f94c97df93dL, 0x2738259634305c14L, 0xd39bb9c3a48db6cfL, 0x8215e577001332c8L, 0xa1082c0466df6c0aL, 0xef02cdd06ffdb432L, 0x7976033a39f7d952L, 0x106f72fe81e2c590L, 0x8c90fd9b083f4558L, 0xfd080d236da814baL, 0x7b64978555326f9fL, 0x60e8ed72c0dff5d1L, 0xb063e962e045f54dL, 0x959f587d507a8359L, 0x1a4e4822eb4d7a59L, 0x5d94337fbfaf7f5bL, 0xd30c088ba61ea5efL, 0x9d765e419fb69f6dL, 0x9e21f4f903b33fd9L, 0xb4d8f77bc3e56167L, 0x733ea705fae4fa77L, 0xa4ec0132764ca04bL}};
	public static final long king[][] = {{0x2102ae466ebb1148L, 0xe87fbb46217a360eL, 0x310cb380db6f7503L, 0xb5fdfc5d3132c498L, 0xdaf8e9829fe96b5fL, 0xcac09afbddd2cdb4L, 0xb862225b055b6960L, 0x55b6344cf97aafaeL, 0x46e3ecaaf453ce9L, 0x962aceefa82e1c84L, 0xf5b4b0b0d2deeeb4L, 0x1af3dbe25d8f45daL, 0xf9f4892ed96bd438L, 0xc4c118bfe78feaaeL, 0x7a69afdcc42261aL, 0xf8549e1a3aa5e00dL, 0x486289ddcc3d6780L, 0x222bbfae61725606L, 0x2bc60a63a6f3b3f2L, 0x177e00f9fc32f791L, 0x522e23f3925e319eL, 0x9c2ed44081ce5fbdL, 0x964781ce734b3c84L, 0xf05d129681949a4cL, 0xd586bd01c5c217f6L, 0x233003b5a6cfe6adL, 0x24c0e332b70019b0L, 0x9da058c67844f20cL, 0xe4d9429322cd065aL, 0x1fab64ea29a2ddf7L, 0x8af38731c02ba980L, 0x7dc7785b8efdfc80L, 0x93cbe0b699c2585dL, 0x1d95b0a5fcf90bc6L, 0x17efee45b0dee640L, 0x9e4c1269baa4bf37L, 0xd79476a84ee20d06L, 0xa56a5f0bfe39272L, 0x7eba726d8c94094bL, 0x5e5637885f29bc2bL, 0xc61bb3a141e50e8cL, 0x2785338347f2ba08L, 0x7ca9723fbb2e8988L, 0xce2f8642ca0712dcL, 0x59300222b4561e00L, 0xc2b5a03f71471a6fL, 0xd5f9e858292504d5L, 0x65fa4f227a2b6d79L, 0x71f1ce2490d20b07L, 0xe6c42178c4bbb92eL, 0xa9c32d5eae45305L, 0xc335248857fa9e7L, 0x142de49fff7a7c3dL, 0x64a53dc924fe7ac9L, 0x9f6a419d382595f4L, 0x150f361dab9dec26L, 0xd20d8c88c8ffe65fL, 0x917f1dd5f8886c61L, 0x56986e2ef3ed091bL, 0x5fa7867caf35e149L, 0x81a1549fd6573da5L, 0x96fbf83a12884624L, 0xe728e8c83c334074L, 0xf1bcc3d275afe51aL},{0xd6b04d3b7651dd7eL, 0xe34a1d250e7a8d6bL, 0x53c065c6c8e63528L, 0x1bdea12e35f6a8c9L, 0x21874b8b4d2dbc4fL, 0x3a88a0fbbcb05c63L, 0x43ed7f5a0fae657dL, 0x230e343dfba08d33L, 0xd4c718bc4ae8ae5fL, 0x9eedeca8e272b933L, 0x10e8b35af3eeab37L, 0xe09b88e1914f7afL, 0x3fa9ddfb67e2f199L, 0xb10bb459132d0a26L, 0x2c046f22062dc67dL, 0x5e90277e7cb39e2dL, 0xb49b52e587a1ee60L, 0xac042e70f8b383f2L, 0x89c350c893ae7dc1L, 0xb592bf39b0364963L, 0x190e714fada5156eL, 0xec8177f83f900978L, 0x91b534f885818a06L, 0x81536d601170fc20L, 0x57e3306d881edb4fL, 0xa804d18b7097475L, 0xe74733427b72f0c1L, 0x24b33c9d7ed25117L, 0xe805a1e290cf2456L, 0x3b544ebe544c19f9L, 0x3e666e6f69ae2c15L, 0xfb152fe3ff26da89L, 0x1a4ff12616eefc89L, 0x990a98fd5071d263L, 0x84547ddc3e203c94L, 0x7a3aec79624c7daL, 0x8a328a1cedfe552cL, 0xd1e649de1e7f268bL, 0x2d8d5432157064c8L, 0x4ae7d6a36eb5dbcbL, 0x4659d2b743848a2cL, 0x19ebb029435dcb0fL, 0x4e9d2827355fc492L, 0xccec0a73b49c9921L, 0x46c9feb55d120902L, 0x8d2636b81555a786L, 0x30c05b1ba332f41cL, 0xf6f7fd1431714200L, 0xabbdcdd7ed5c0860L, 0x9853eab63b5e0b35L, 0x352787baa0d7c22fL, 0xc7f6aa2de59aea61L, 0x3727073c2e134b1L, 0x5a0f544dd2b1fb18L, 0x74f85198b05a2e7dL, 0x963ef2c96b33be31L, 0xff577222c14f0a3aL, 0x4e4b705b92903ba4L, 0x730499af921549ffL, 0x13ae978d09fe5557L, 0xd9e92aa246bf719eL, 0x7a4c10ec2158c4a6L, 0x49cad48cebf4a71eL, 0xcf05daf5ac8d77b0L}};
	public static final long whiteKingSideCastling = 0x31d71dce64b2c310L;
	public static final long whiteQueenSideCastling = 0xf165b587df898190L;
	public static final long blackKingSideCastling = 0xa57e6339dd2cf3a0L;
	public static final long blackQueenSideCastling = 0x1ef6e6dbb1961ec9L;
	public static final long passantFile[] = {0x70cc73d90bc26e24L, 0xe21a6b35df0c3ad7L, 0x3a93d8b2806962L, 0x1c99ded33cb890a1L, 0xcf3145de0add4289L, 0xd0e4427a5514fb72L, 0x77c621cc9fb3a483L, 0x67a34dac4356550bL, };
	public static final long whiteMove = 0xf8d626aaaf278509L;
	
	public static long[] random64 = new long[]{
	    0x9D39247E33776D41L,0x2AF7398005AAA5C7L,0x44DB015024623547L,0x9C15F73E62A76AE2L,
	    0x75834465489C0C89L,0x3290AC3A203001BFL,0x0FBBAD1F61042279L,0xE83A908FF2FB60CAL,
	    0x0D7E765D58755C10L,0x1A083822CEAFE02DL,0x9605D5F0E25EC3B0L,0xD021FF5CD13A2ED5L,
	    0x40BDF15D4A672E32L,0x011355146FD56395L,0x5DB4832046F3D9E5L,0x239F8B2D7FF719CCL,
	    0x05D1A1AE85B49AA1L,0x679F848F6E8FC971L,0x7449BBFF801FED0BL,0x7D11CDB1C3B7ADF0L,
	    0x82C7709E781EB7CCL,0xF3218F1C9510786CL,0x331478F3AF51BBE6L,0x4BB38DE5E7219443L,
	    0xAA649C6EBCFD50FCL,0x8DBD98A352AFD40BL,0x87D2074B81D79217L,0x19F3C751D3E92AE1L,
	    0xB4AB30F062B19ABFL,0x7B0500AC42047AC4L,0xC9452CA81A09D85DL,0x24AA6C514DA27500L,
	    0x4C9F34427501B447L,0x14A68FD73C910841L,0xA71B9B83461CBD93L,0x03488B95B0F1850FL,
	    0x637B2B34FF93C040L,0x09D1BC9A3DD90A94L,0x3575668334A1DD3BL,0x735E2B97A4C45A23L,
	    0x18727070F1BD400BL,0x1FCBACD259BF02E7L,0xD310A7C2CE9B6555L,0xBF983FE0FE5D8244L,
	    0x9F74D14F7454A824L,0x51EBDC4AB9BA3035L,0x5C82C505DB9AB0FAL,0xFCF7FE8A3430B241L,
	    0x3253A729B9BA3DDEL,0x8C74C368081B3075L,0xB9BC6C87167C33E7L,0x7EF48F2B83024E20L,
	    0x11D505D4C351BD7FL,0x6568FCA92C76A243L,0x4DE0B0F40F32A7B8L,0x96D693460CC37E5DL,
	    0x42E240CB63689F2FL,0x6D2BDCDAE2919661L,0x42880B0236E4D951L,0x5F0F4A5898171BB6L,
	    0x39F890F579F92F88L,0x93C5B5F47356388BL,0x63DC359D8D231B78L,0xEC16CA8AEA98AD76L,
	    0x5355F900C2A82DC7L,0x07FB9F855A997142L,0x5093417AA8A7ED5EL,0x7BCBC38DA25A7F3CL,
	    0x19FC8A768CF4B6D4L,0x637A7780DECFC0D9L,0x8249A47AEE0E41F7L,0x79AD695501E7D1E8L,
	    0x14ACBAF4777D5776L,0xF145B6BECCDEA195L,0xDABF2AC8201752FCL,0x24C3C94DF9C8D3F6L,
	    0xBB6E2924F03912EAL,0x0CE26C0B95C980D9L,0xA49CD132BFBF7CC4L,0xE99D662AF4243939L,
	    0x27E6AD7891165C3FL,0x8535F040B9744FF1L,0x54B3F4FA5F40D873L,0x72B12C32127FED2BL,
	    0xEE954D3C7B411F47L,0x9A85AC909A24EAA1L,0x70AC4CD9F04F21F5L,0xF9B89D3E99A075C2L,
	    0x87B3E2B2B5C907B1L,0xA366E5B8C54F48B8L,0xAE4A9346CC3F7CF2L,0x1920C04D47267BBDL,
	    0x87BF02C6B49E2AE9L,0x092237AC237F3859L,0xFF07F64EF8ED14D0L,0x8DE8DCA9F03CC54EL,
	    0x9C1633264DB49C89L,0xB3F22C3D0B0B38EDL,0x390E5FB44D01144BL,0x5BFEA5B4712768E9L,
	    0x1E1032911FA78984L,0x9A74ACB964E78CB3L,0x4F80F7A035DAFB04L,0x6304D09A0B3738C4L,
	    0x2171E64683023A08L,0x5B9B63EB9CEFF80CL,0x506AACF489889342L,0x1881AFC9A3A701D6L,
	    0x6503080440750644L,0xDFD395339CDBF4A7L,0xEF927DBCF00C20F2L,0x7B32F7D1E03680ECL,
	    0xB9FD7620E7316243L,0x05A7E8A57DB91B77L,0xB5889C6E15630A75L,0x4A750A09CE9573F7L,
	    0xCF464CEC899A2F8AL,0xF538639CE705B824L,0x3C79A0FF5580EF7FL,0xEDE6C87F8477609DL,
	    0x799E81F05BC93F31L,0x86536B8CF3428A8CL,0x97D7374C60087B73L,0xA246637CFF328532L,
	    0x043FCAE60CC0EBA0L,0x920E449535DD359EL,0x70EB093B15B290CCL,0x73A1921916591CBDL,
	    0x56436C9FE1A1AA8DL,0xEFAC4B70633B8F81L,0xBB215798D45DF7AFL,0x45F20042F24F1768L,
	    0x930F80F4E8EB7462L,0xFF6712FFCFD75EA1L,0xAE623FD67468AA70L,0xDD2C5BC84BC8D8FCL,
	    0x7EED120D54CF2DD9L,0x22FE545401165F1CL,0xC91800E98FB99929L,0x808BD68E6AC10365L,
	    0xDEC468145B7605F6L,0x1BEDE3A3AEF53302L,0x43539603D6C55602L,0xAA969B5C691CCB7AL,
	    0xA87832D392EFEE56L,0x65942C7B3C7E11AEL,0xDED2D633CAD004F6L,0x21F08570F420E565L,
	    0xB415938D7DA94E3CL,0x91B859E59ECB6350L,0x10CFF333E0ED804AL,0x28AED140BE0BB7DDL,
	    0xC5CC1D89724FA456L,0x5648F680F11A2741L,0x2D255069F0B7DAB3L,0x9BC5A38EF729ABD4L,
	    0xEF2F054308F6A2BCL,0xAF2042F5CC5C2858L,0x480412BAB7F5BE2AL,0xAEF3AF4A563DFE43L,
	    0x19AFE59AE451497FL,0x52593803DFF1E840L,0xF4F076E65F2CE6F0L,0x11379625747D5AF3L,
	    0xBCE5D2248682C115L,0x9DA4243DE836994FL,0x066F70B33FE09017L,0x4DC4DE189B671A1CL,
	    0x51039AB7712457C3L,0xC07A3F80C31FB4B4L,0xB46EE9C5E64A6E7CL,0xB3819A42ABE61C87L,
	    0x21A007933A522A20L,0x2DF16F761598AA4FL,0x763C4A1371B368FDL,0xF793C46702E086A0L,
	    0xD7288E012AEB8D31L,0xDE336A2A4BC1C44BL,0x0BF692B38D079F23L,0x2C604A7A177326B3L,
	    0x4850E73E03EB6064L,0xCFC447F1E53C8E1BL,0xB05CA3F564268D99L,0x9AE182C8BC9474E8L,
	    0xA4FC4BD4FC5558CAL,0xE755178D58FC4E76L,0x69B97DB1A4C03DFEL,0xF9B5B7C4ACC67C96L,
	    0xFC6A82D64B8655FBL,0x9C684CB6C4D24417L,0x8EC97D2917456ED0L,0x6703DF9D2924E97EL,
	    0xC547F57E42A7444EL,0x78E37644E7CAD29EL,0xFE9A44E9362F05FAL,0x08BD35CC38336615L,
	    0x9315E5EB3A129ACEL,0x94061B871E04DF75L,0xDF1D9F9D784BA010L,0x3BBA57B68871B59DL,
	    0xD2B7ADEEDED1F73FL,0xF7A255D83BC373F8L,0xD7F4F2448C0CEB81L,0xD95BE88CD210FFA7L,
	    0x336F52F8FF4728E7L,0xA74049DAC312AC71L,0xA2F61BB6E437FDB5L,0x4F2A5CB07F6A35B3L,
	    0x87D380BDA5BF7859L,0x16B9F7E06C453A21L,0x7BA2484C8A0FD54EL,0xF3A678CAD9A2E38CL,
	    0x39B0BF7DDE437BA2L,0xFCAF55C1BF8A4424L,0x18FCF680573FA594L,0x4C0563B89F495AC3L,
	    0x40E087931A00930DL,0x8CFFA9412EB642C1L,0x68CA39053261169FL,0x7A1EE967D27579E2L,
	    0x9D1D60E5076F5B6FL,0x3810E399B6F65BA2L,0x32095B6D4AB5F9B1L,0x35CAB62109DD038AL,
	    0xA90B24499FCFAFB1L,0x77A225A07CC2C6BDL,0x513E5E634C70E331L,0x4361C0CA3F692F12L,
	    0xD941ACA44B20A45BL,0x528F7C8602C5807BL,0x52AB92BEB9613989L,0x9D1DFA2EFC557F73L,
	    0x722FF175F572C348L,0x1D1260A51107FE97L,0x7A249A57EC0C9BA2L,0x04208FE9E8F7F2D6L,
	    0x5A110C6058B920A0L,0x0CD9A497658A5698L,0x56FD23C8F9715A4CL,0x284C847B9D887AAEL,
	    0x04FEABFBBDB619CBL,0x742E1E651C60BA83L,0x9A9632E65904AD3CL,0x881B82A13B51B9E2L,
	    0x506E6744CD974924L,0xB0183DB56FFC6A79L,0x0ED9B915C66ED37EL,0x5E11E86D5873D484L,
	    0xF678647E3519AC6EL,0x1B85D488D0F20CC5L,0xDAB9FE6525D89021L,0x0D151D86ADB73615L,
	    0xA865A54EDCC0F019L,0x93C42566AEF98FFBL,0x99E7AFEABE000731L,0x48CBFF086DDF285AL,
	    0x7F9B6AF1EBF78BAFL,0x58627E1A149BBA21L,0x2CD16E2ABD791E33L,0xD363EFF5F0977996L,
	    0x0CE2A38C344A6EEDL,0x1A804AADB9CFA741L,0x907F30421D78C5DEL,0x501F65EDB3034D07L,
	    0x37624AE5A48FA6E9L,0x957BAF61700CFF4EL,0x3A6C27934E31188AL,0xD49503536ABCA345L,
	    0x088E049589C432E0L,0xF943AEE7FEBF21B8L,0x6C3B8E3E336139D3L,0x364F6FFA464EE52EL,
	    0xD60F6DCEDC314222L,0x56963B0DCA418FC0L,0x16F50EDF91E513AFL,0xEF1955914B609F93L,
	    0x565601C0364E3228L,0xECB53939887E8175L,0xBAC7A9A18531294BL,0xB344C470397BBA52L,
	    0x65D34954DAF3CEBDL,0xB4B81B3FA97511E2L,0xB422061193D6F6A7L,0x071582401C38434DL,
	    0x7A13F18BBEDC4FF5L,0xBC4097B116C524D2L,0x59B97885E2F2EA28L,0x99170A5DC3115544L,
	    0x6F423357E7C6A9F9L,0x325928EE6E6F8794L,0xD0E4366228B03343L,0x565C31F7DE89EA27L,
	    0x30F5611484119414L,0xD873DB391292ED4FL,0x7BD94E1D8E17DEBCL,0xC7D9F16864A76E94L,
	    0x947AE053EE56E63CL,0xC8C93882F9475F5FL,0x3A9BF55BA91F81CAL,0xD9A11FBB3D9808E4L,
	    0x0FD22063EDC29FCAL,0xB3F256D8ACA0B0B9L,0xB03031A8B4516E84L,0x35DD37D5871448AFL,
	    0xE9F6082B05542E4EL,0xEBFAFA33D7254B59L,0x9255ABB50D532280L,0xB9AB4CE57F2D34F3L,
	    0x693501D628297551L,0xC62C58F97DD949BFL,0xCD454F8F19C5126AL,0xBBE83F4ECC2BDECBL,
	    0xDC842B7E2819E230L,0xBA89142E007503B8L,0xA3BC941D0A5061CBL,0xE9F6760E32CD8021L,
	    0x09C7E552BC76492FL,0x852F54934DA55CC9L,0x8107FCCF064FCF56L,0x098954D51FFF6580L,
	    0x23B70EDB1955C4BFL,0xC330DE426430F69DL,0x4715ED43E8A45C0AL,0xA8D7E4DAB780A08DL,
	    0x0572B974F03CE0BBL,0xB57D2E985E1419C7L,0xE8D9ECBE2CF3D73FL,0x2FE4B17170E59750L,
	    0x11317BA87905E790L,0x7FBF21EC8A1F45ECL,0x1725CABFCB045B00L,0x964E915CD5E2B207L,
	    0x3E2B8BCBF016D66DL,0xBE7444E39328A0ACL,0xF85B2B4FBCDE44B7L,0x49353FEA39BA63B1L,
	    0x1DD01AAFCD53486AL,0x1FCA8A92FD719F85L,0xFC7C95D827357AFAL,0x18A6A990C8B35EBDL,
	    0xCCCB7005C6B9C28DL,0x3BDBB92C43B17F26L,0xAA70B5B4F89695A2L,0xE94C39A54A98307FL,
	    0xB7A0B174CFF6F36EL,0xD4DBA84729AF48ADL,0x2E18BC1AD9704A68L,0x2DE0966DAF2F8B1CL,
	    0xB9C11D5B1E43A07EL,0x64972D68DEE33360L,0x94628D38D0C20584L,0xDBC0D2B6AB90A559L,
	    0xD2733C4335C6A72FL,0x7E75D99D94A70F4DL,0x6CED1983376FA72BL,0x97FCAACBF030BC24L,
	    0x7B77497B32503B12L,0x8547EDDFB81CCB94L,0x79999CDFF70902CBL,0xCFFE1939438E9B24L,
	    0x829626E3892D95D7L,0x92FAE24291F2B3F1L,0x63E22C147B9C3403L,0xC678B6D860284A1CL,
	    0x5873888850659AE7L,0x0981DCD296A8736DL,0x9F65789A6509A440L,0x9FF38FED72E9052FL,
	    0xE479EE5B9930578CL,0xE7F28ECD2D49EECDL,0x56C074A581EA17FEL,0x5544F7D774B14AEFL,
	    0x7B3F0195FC6F290FL,0x12153635B2C0CF57L,0x7F5126DBBA5E0CA7L,0x7A76956C3EAFB413L,
	    0x3D5774A11D31AB39L,0x8A1B083821F40CB4L,0x7B4A38E32537DF62L,0x950113646D1D6E03L,
	    0x4DA8979A0041E8A9L,0x3BC36E078F7515D7L,0x5D0A12F27AD310D1L,0x7F9D1A2E1EBE1327L,
	    0xDA3A361B1C5157B1L,0xDCDD7D20903D0C25L,0x36833336D068F707L,0xCE68341F79893389L,
	    0xAB9090168DD05F34L,0x43954B3252DC25E5L,0xB438C2B67F98E5E9L,0x10DCD78E3851A492L,
	    0xDBC27AB5447822BFL,0x9B3CDB65F82CA382L,0xB67B7896167B4C84L,0xBFCED1B0048EAC50L,
	    0xA9119B60369FFEBDL,0x1FFF7AC80904BF45L,0xAC12FB171817EEE7L,0xAF08DA9177DDA93DL,
	    0x1B0CAB936E65C744L,0xB559EB1D04E5E932L,0xC37B45B3F8D6F2BAL,0xC3A9DC228CAAC9E9L,
	    0xF3B8B6675A6507FFL,0x9FC477DE4ED681DAL,0x67378D8ECCEF96CBL,0x6DD856D94D259236L,
	    0xA319CE15B0B4DB31L,0x073973751F12DD5EL,0x8A8E849EB32781A5L,0xE1925C71285279F5L,
	    0x74C04BF1790C0EFEL,0x4DDA48153C94938AL,0x9D266D6A1CC0542CL,0x7440FB816508C4FEL,
	    0x13328503DF48229FL,0xD6BF7BAEE43CAC40L,0x4838D65F6EF6748FL,0x1E152328F3318DEAL,
	    0x8F8419A348F296BFL,0x72C8834A5957B511L,0xD7A023A73260B45CL,0x94EBC8ABCFB56DAEL,
	    0x9FC10D0F989993E0L,0xDE68A2355B93CAE6L,0xA44CFE79AE538BBEL,0x9D1D84FCCE371425L,
	    0x51D2B1AB2DDFB636L,0x2FD7E4B9E72CD38CL,0x65CA5B96B7552210L,0xDD69A0D8AB3B546DL,
	    0x604D51B25FBF70E2L,0x73AA8A564FB7AC9EL,0x1A8C1E992B941148L,0xAAC40A2703D9BEA0L,
	    0x764DBEAE7FA4F3A6L,0x1E99B96E70A9BE8BL,0x2C5E9DEB57EF4743L,0x3A938FEE32D29981L,
	    0x26E6DB8FFDF5ADFEL,0x469356C504EC9F9DL,0xC8763C5B08D1908CL,0x3F6C6AF859D80055L,
	    0x7F7CC39420A3A545L,0x9BFB227EBDF4C5CEL,0x89039D79D6FC5C5CL,0x8FE88B57305E2AB6L,
	    0xA09E8C8C35AB96DEL,0xFA7E393983325753L,0xD6B6D0ECC617C699L,0xDFEA21EA9E7557E3L,
	    0xB67C1FA481680AF8L,0xCA1E3785A9E724E5L,0x1CFC8BED0D681639L,0xD18D8549D140CAEAL,
	    0x4ED0FE7E9DC91335L,0xE4DBF0634473F5D2L,0x1761F93A44D5AEFEL,0x53898E4C3910DA55L,
	    0x734DE8181F6EC39AL,0x2680B122BAA28D97L,0x298AF231C85BAFABL,0x7983EED3740847D5L,
	    0x66C1A2A1A60CD889L,0x9E17E49642A3E4C1L,0xEDB454E7BADC0805L,0x50B704CAB602C329L,
	    0x4CC317FB9CDDD023L,0x66B4835D9EAFEA22L,0x219B97E26FFC81BDL,0x261E4E4C0A333A9DL,
	    0x1FE2CCA76517DB90L,0xD7504DFA8816EDBBL,0xB9571FA04DC089C8L,0x1DDC0325259B27DEL,
	    0xCF3F4688801EB9AAL,0xF4F5D05C10CAB243L,0x38B6525C21A42B0EL,0x36F60E2BA4FA6800L,
	    0xEB3593803173E0CEL,0x9C4CD6257C5A3603L,0xAF0C317D32ADAA8AL,0x258E5A80C7204C4BL,
	    0x8B889D624D44885DL,0xF4D14597E660F855L,0xD4347F66EC8941C3L,0xE699ED85B0DFB40DL,
	    0x2472F6207C2D0484L,0xC2A1E7B5B459AEB5L,0xAB4F6451CC1D45ECL,0x63767572AE3D6174L,
	    0xA59E0BD101731A28L,0x116D0016CB948F09L,0x2CF9C8CA052F6E9FL,0x0B090A7560A968E3L,
	    0xABEEDDB2DDE06FF1L,0x58EFC10B06A2068DL,0xC6E57A78FBD986E0L,0x2EAB8CA63CE802D7L,
	    0x14A195640116F336L,0x7C0828DD624EC390L,0xD74BBE77E6116AC7L,0x804456AF10F5FB53L,
	    0xEBE9EA2ADF4321C7L,0x03219A39EE587A30L,0x49787FEF17AF9924L,0xA1E9300CD8520548L,
	    0x5B45E522E4B1B4EFL,0xB49C3B3995091A36L,0xD4490AD526F14431L,0x12A8F216AF9418C2L,
	    0x001F837CC7350524L,0x1877B51E57A764D5L,0xA2853B80F17F58EEL,0x993E1DE72D36D310L,
	    0xB3598080CE64A656L,0x252F59CF0D9F04BBL,0xD23C8E176D113600L,0x1BDA0492E7E4586EL,
	    0x21E0BD5026C619BFL,0x3B097ADAF088F94EL,0x8D14DEDB30BE846EL,0xF95CFFA23AF5F6F4L,
	    0x3871700761B3F743L,0xCA672B91E9E4FA16L,0x64C8E531BFF53B55L,0x241260ED4AD1E87DL,
	    0x106C09B972D2E822L,0x7FBA195410E5CA30L,0x7884D9BC6CB569D8L,0x0647DFEDCD894A29L,
	    0x63573FF03E224774L,0x4FC8E9560F91B123L,0x1DB956E450275779L,0xB8D91274B9E9D4FBL,
	    0xA2EBEE47E2FBFCE1L,0xD9F1F30CCD97FB09L,0xEFED53D75FD64E6BL,0x2E6D02C36017F67FL,
	    0xA9AA4D20DB084E9BL,0xB64BE8D8B25396C1L,0x70CB6AF7C2D5BCF0L,0x98F076A4F7A2322EL,
	    0xBF84470805E69B5FL,0x94C3251F06F90CF3L,0x3E003E616A6591E9L,0xB925A6CD0421AFF3L,
	    0x61BDD1307C66E300L,0xBF8D5108E27E0D48L,0x240AB57A8B888B20L,0xFC87614BAF287E07L,
	    0xEF02CDD06FFDB432L,0xA1082C0466DF6C0AL,0x8215E577001332C8L,0xD39BB9C3A48DB6CFL,
	    0x2738259634305C14L,0x61CF4F94C97DF93DL,0x1B6BACA2AE4E125BL,0x758F450C88572E0BL,
	    0x959F587D507A8359L,0xB063E962E045F54DL,0x60E8ED72C0DFF5D1L,0x7B64978555326F9FL,
	    0xFD080D236DA814BAL,0x8C90FD9B083F4558L,0x106F72FE81E2C590L,0x7976033A39F7D952L,
	    0xA4EC0132764CA04BL,0x733EA705FAE4FA77L,0xB4D8F77BC3E56167L,0x9E21F4F903B33FD9L,
	    0x9D765E419FB69F6DL,0xD30C088BA61EA5EFL,0x5D94337FBFAF7F5BL,0x1A4E4822EB4D7A59L,
	    0x6FFE73E81B637FB3L,0xDDF957BC36D8B9CAL,0x64D0E29EEA8838B3L,0x08DD9BDFD96B9F63L,
	    0x087E79E5A57D1D13L,0xE328E230E3E2B3FBL,0x1C2559E30F0946BEL,0x720BF5F26F4D2EAAL,
	    0xB0774D261CC609DBL,0x443F64EC5A371195L,0x4112CF68649A260EL,0xD813F2FAB7F5C5CAL,
	    0x660D3257380841EEL,0x59AC2C7873F910A3L,0xE846963877671A17L,0x93B633ABFA3469F8L,
	    0xC0C0F5A60EF4CDCFL,0xCAF21ECD4377B28CL,0x57277707199B8175L,0x506C11B9D90E8B1DL,
	    0xD83CC2687A19255FL,0x4A29C6465A314CD1L,0xED2DF21216235097L,0xB5635C95FF7296E2L,
	    0x22AF003AB672E811L,0x52E762596BF68235L,0x9AEBA33AC6ECC6B0L,0x944F6DE09134DFB6L,
	    0x6C47BEC883A7DE39L,0x6AD047C430A12104L,0xA5B1CFDBA0AB4067L,0x7C45D833AFF07862L,
	    0x5092EF950A16DA0BL,0x9338E69C052B8E7BL,0x455A4B4CFE30E3F5L,0x6B02E63195AD0CF8L,
	    0x6B17B224BAD6BF27L,0xD1E0CCD25BB9C169L,0xDE0C89A556B9AE70L,0x50065E535A213CF6L,
	    0x9C1169FA2777B874L,0x78EDEFD694AF1EEDL,0x6DC93D9526A50E68L,0xEE97F453F06791EDL,
	    0x32AB0EDB696703D3L,0x3A6853C7E70757A7L,0x31865CED6120F37DL,0x67FEF95D92607890L,
	    0x1F2B1D1F15F6DC9CL,0xB69E38A8965C6B65L,0xAA9119FF184CCCF4L,0xF43C732873F24C13L,
	    0xFB4A3D794A9A80D2L,0x3550C2321FD6109CL,0x371F77E76BB8417EL,0x6BFA9AAE5EC05779L,
	    0xCD04F3FF001A4778L,0xE3273522064480CAL,0x9F91508BFFCFC14AL,0x049A7F41061A9E60L,
	    0xFCB6BE43A9F2FE9BL,0x08DE8A1C7797DA9BL,0x8F9887E6078735A1L,0xB5B4071DBFC73A66L,
	    0x230E343DFBA08D33L,0x43ED7F5A0FAE657DL,0x3A88A0FBBCB05C63L,0x21874B8B4D2DBC4FL,
	    0x1BDEA12E35F6A8C9L,0x53C065C6C8E63528L,0xE34A1D250E7A8D6BL,0xD6B04D3B7651DD7EL,
	    0x5E90277E7CB39E2DL,0x2C046F22062DC67DL,0xB10BB459132D0A26L,0x3FA9DDFB67E2F199L,
	    0x0E09B88E1914F7AFL,0x10E8B35AF3EEAB37L,0x9EEDECA8E272B933L,0xD4C718BC4AE8AE5FL,
	    0x81536D601170FC20L,0x91B534F885818A06L,0xEC8177F83F900978L,0x190E714FADA5156EL,
	    0xB592BF39B0364963L,0x89C350C893AE7DC1L,0xAC042E70F8B383F2L,0xB49B52E587A1EE60L,
	    0xFB152FE3FF26DA89L,0x3E666E6F69AE2C15L,0x3B544EBE544C19F9L,0xE805A1E290CF2456L,
	    0x24B33C9D7ED25117L,0xE74733427B72F0C1L,0x0A804D18B7097475L,0x57E3306D881EDB4FL,
	    0x4AE7D6A36EB5DBCBL,0x2D8D5432157064C8L,0xD1E649DE1E7F268BL,0x8A328A1CEDFE552CL,
	    0x07A3AEC79624C7DAL,0x84547DDC3E203C94L,0x990A98FD5071D263L,0x1A4FF12616EEFC89L,
	    0xF6F7FD1431714200L,0x30C05B1BA332F41CL,0x8D2636B81555A786L,0x46C9FEB55D120902L,
	    0xCCEC0A73B49C9921L,0x4E9D2827355FC492L,0x19EBB029435DCB0FL,0x4659D2B743848A2CL,
	    0x963EF2C96B33BE31L,0x74F85198B05A2E7DL,0x5A0F544DD2B1FB18L,0x03727073C2E134B1L,
	    0xC7F6AA2DE59AEA61L,0x352787BAA0D7C22FL,0x9853EAB63B5E0B35L,0xABBDCDD7ED5C0860L,
	    0xCF05DAF5AC8D77B0L,0x49CAD48CEBF4A71EL,0x7A4C10EC2158C4A6L,0xD9E92AA246BF719EL,
	    0x13AE978D09FE5557L,0x730499AF921549FFL,0x4E4B705B92903BA4L,0xFF577222C14F0A3AL,
	    0x55B6344CF97AAFAEL,0xB862225B055B6960L,0xCAC09AFBDDD2CDB4L,0xDAF8E9829FE96B5FL,
	    0xB5FDFC5D3132C498L,0x310CB380DB6F7503L,0xE87FBB46217A360EL,0x2102AE466EBB1148L,
	    0xF8549E1A3AA5E00DL,0x07A69AFDCC42261AL,0xC4C118BFE78FEAAEL,0xF9F4892ED96BD438L,
	    0x1AF3DBE25D8F45DAL,0xF5B4B0B0D2DEEEB4L,0x962ACEEFA82E1C84L,0x046E3ECAAF453CE9L,
	    0xF05D129681949A4CL,0x964781CE734B3C84L,0x9C2ED44081CE5FBDL,0x522E23F3925E319EL,
	    0x177E00F9FC32F791L,0x2BC60A63A6F3B3F2L,0x222BBFAE61725606L,0x486289DDCC3D6780L,
	    0x7DC7785B8EFDFC80L,0x8AF38731C02BA980L,0x1FAB64EA29A2DDF7L,0xE4D9429322CD065AL,
	    0x9DA058C67844F20CL,0x24C0E332B70019B0L,0x233003B5A6CFE6ADL,0xD586BD01C5C217F6L,
	    0x5E5637885F29BC2BL,0x7EBA726D8C94094BL,0x0A56A5F0BFE39272L,0xD79476A84EE20D06L,
	    0x9E4C1269BAA4BF37L,0x17EFEE45B0DEE640L,0x1D95B0A5FCF90BC6L,0x93CBE0B699C2585DL,
	    0x65FA4F227A2B6D79L,0xD5F9E858292504D5L,0xC2B5A03F71471A6FL,0x59300222B4561E00L,
	    0xCE2F8642CA0712DCL,0x7CA9723FBB2E8988L,0x2785338347F2BA08L,0xC61BB3A141E50E8CL,
	    0x150F361DAB9DEC26L,0x9F6A419D382595F4L,0x64A53DC924FE7AC9L,0x142DE49FFF7A7C3DL,
	    0x0C335248857FA9E7L,0x0A9C32D5EAE45305L,0xE6C42178C4BBB92EL,0x71F1CE2490D20B07L,
	    0xF1BCC3D275AFE51AL,0xE728E8C83C334074L,0x96FBF83A12884624L,0x81A1549FD6573DA5L,
	    0x5FA7867CAF35E149L,0x56986E2EF3ED091BL,0x917F1DD5F8886C61L,0xD20D8C88C8FFE65FL,
	    0x31D71DCE64B2C310L,0xF165B587DF898190L,0xA57E6339DD2CF3A0L,0x1EF6E6DBB1961EC9L,
	    0x70CC73D90BC26E24L,0xE21A6B35DF0C3AD7L,0x003A93D8B2806962L,0x1C99DED33CB890A1L,
	    0xCF3145DE0ADD4289L,0xD0E4427A5514FB72L,0x77C621CC9FB3A483L,0x67A34DAC4356550BL,
	    0xF8D626AAAF278509L};
    /**
     * 
     */
    public static long getKeyPieceIndex(int index, char pieceChar) {
        switch (pieceChar) {
        case 'P' : return pawn[0][index];
        case 'p' : return pawn[1][index];
        case 'R' : return rook[0][index];
        case 'r' : return rook[1][index];
        case 'N' : return knight[0][index];
        case 'n' : return knight[1][index];
        case 'B' : return bishop[0][index];
        case 'b' : return bishop[1][index];
        case 'Q' : return queen[0][index];
        case 'q' : return queen[1][index];
        case 'K' : return king[0][index];
        case 'k' : return king[1][index];
        }
        return 0;
    }
    
    /**
     * 
     */
    public static long getKeyPieceIndex(int index, int piece) {
        switch (piece) {
        case  IConst.PAWN: return pawn[0][index];
        case IConst.BLACK_PAWN : return pawn[1][index];
        case IConst.ROOK : return rook[0][index];
        case IConst.BLACK_ROOK : return rook[1][index];
        case IConst.KNIGHT : return knight[0][index];
        case IConst.BLACK_KNIGHT : return knight[1][index];
        case IConst.BISHOP : return bishop[0][index];
        case IConst.BLACK_BISHOP : return bishop[1][index];
        case IConst.QUEEN : return queen[0][index];
        case IConst.BLACK_QUEEN : return queen[1][index];
        case IConst.KING : return king[0][index];
        case IConst.BLACK_KING : return king[1][index];
        }
        return 0;
    }
    
//	public static long[] getKey(Board board) {
//		long key[] = {0,0};
//
//		long square = BitboardUtils.H1;
//		byte index = 0;
//		int color = 0;
//		while (square != 0) {
//			color = (square & board.whites) != 0 ? 0 : 1;
//			key[color] ^= getKeyPieceIndex(index, board.getPieceAt(square));
//			square <<= 1;
//			index++;
//		}
//
//		if (board.getWhiteKingsideCastling()) key[0] ^= whiteKingSideCastling;
//		if (board.getWhiteQueensideCastling()) key[0] ^= whiteQueenSideCastling;
//		if (board.getBlackKingsideCastling()) key[1] ^= blackKingSideCastling;
//		if (board.getBlackQueensideCastling()) key[1] ^= blackQueenSideCastling;
//		// passant flags only when pawn can capture
//		long passant = board.getPassantSquare();
//		if ((passant !=0) &&
//			(((!board.getTurn() && (((passant<<9) | (passant<<7)) & board.blacks & board.pawns) != 0)) ||
//			((board.getTurn() && (((passant>>>9) | (passant>>>7)) & board.whites & board.pawns) != 0)))) {
//			color = board.getTurn() ? 0 : 1; // TODO test
//			key[1-color] ^= passantFile[BitboardUtils.getFile(passant)];
//		}
//		if (board.getTurn()) key[0] ^= whiteMove;
//		return key;
//	}

    public static long[] getKey2(IPosition pos) {
        long key[] = {0,0};
        int[] board = pos.getBoard();
        int bitmap = pos.getInherit();
        int color = 0;
        for (int y = 56; y >=0; y-=8) {
            for (int i = 0; i < 8; i++) {
                int index = y+i;
                int piece=board[index];
                color = piece >>3;
                key[color] ^= getKeyPieceIndex(index, piece);
            }
        }
        
        
        if ((bitmap&IConst.NOCASTLE_WHITEKING)==0) key[0] ^= whiteKingSideCastling;
        if ((bitmap&IConst.NOCASTLE_WHITEQUEEN)==0) key[0] ^= whiteQueenSideCastling;
        if ((bitmap&IConst.NOCASTLE_BLACKKING)==0) key[1] ^= blackKingSideCastling;
        if ((bitmap&IConst.NOCASTLE_BLACKQUEEN)==0) key[1] ^= blackQueenSideCastling;
        // passant flags only when pawn can capture
//      long passant = board.getPassantSquare();
//      if ((passant !=0) &&
//          (((!board.getTurn() && (((passant<<9) | (passant<<7)) & board.blacks & board.pawns) != 0)) ||
//          ((board.getTurn() && (((passant>>>9) | (passant>>>7)) & board.whites & board.pawns) != 0)))) {
//          color = board.getTurn() ? 0 : 1; // TODO test
//          key[1-color] ^= passantFile[BitboardUtils.getFile(passant)];
//      }
        if (Bitmap.white(bitmap))
            key[0] ^= whiteMove;
        return key;
    }
    
    public static long[] getKey(IPosition pos) {
        long key[] = {0,0};
        int[] board = pos.getBoard();
        int bitmap = pos.getInherit();
        int color = 0;
        for (int y = 56; y >=0; y-=8) {
            for (int i = 0; i < 8; i++) {
                int index = y+i;
                int piece=board[index];
                color = piece >>3;
                key[color] ^= getKeyPieceIndex(index, piece);
            }
        }
        if ((bitmap&IConst.NOCASTLE_WHITEKING)==0) key[0] ^= whiteKingSideCastling;
        if ((bitmap&IConst.NOCASTLE_WHITEQUEEN)==0) key[0] ^= whiteQueenSideCastling;
        if ((bitmap&IConst.NOCASTLE_BLACKKING)==0) key[1] ^= blackKingSideCastling;
        if ((bitmap&IConst.NOCASTLE_BLACKQUEEN)==0) key[1] ^= blackQueenSideCastling;
        // passant flags only when pawn can capture
//      long passant = board.getPassantSquare();
//      if ((passant !=0) &&
//          (((!board.getTurn() && (((passant<<9) | (passant<<7)) & board.blacks & board.pawns) != 0)) ||
//          ((board.getTurn() && (((passant>>>9) | (passant>>>7)) & board.whites & board.pawns) != 0)))) {
//          color = board.getTurn() ? 0 : 1; // TODO test
//          key[1-color] ^= passantFile[BitboardUtils.getFile(passant)];
//      }
        if (Bitmap.white(bitmap))
            key[0] ^= whiteMove;
        return key;
    }
}
