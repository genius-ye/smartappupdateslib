LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := ApkPatchLibrary
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_LDLIBS := \
	-llog \
	-lz \
	-lm \

LOCAL_SRC_FILES := \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\Application.mk \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\blocksort.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\bzip2.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\bzip2recover.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\bzlib.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\compress.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\crctable.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\decompress.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\huffman.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\randtable.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\bzip2\readMe.txt \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\diffUtils.c \
	H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni\patchUtils.c \

LOCAL_C_INCLUDES += H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\main\jni
LOCAL_C_INCLUDES += H:\AS_Workspace\vmm-2.0\smartappupdateslib\src\release\jni

include $(BUILD_SHARED_LIBRARY)
