import { INavData } from '@coreui/angular';


export const navItems: INavData[] = [
  {
    name: 'Trang chủ',
    url: '/dashboard',
    icon: 'icon-speedometer'
  },
  {
    title: true,
    name: 'Quản lý nhân sự'
  },
  {
    name: 'Quản lý nhân viên',
    url: '/quan-ly-nhan-vien',
    icon: 'icon-user',
    children: [
      {
        name: 'Thông tin cơ bản',
        url: '/quan-ly-nhan-vien/thong-tin-co-ban'
      }
    ]
  },
  {
    name: 'Tuyển dụng',
    url: '',
    icon: 'icon-magnifier-add',
    children: [
      {
        name: 'Danh sách ứng viên',
        url: '/tuyen-dung/tuyen-nhan-su',
        icon: '',
      },
    ]
  },
  {
    name: 'Quản lý công việc',
    url: '/quan-ly-cong-viec',
    icon: 'icon-briefcase',
    children: [
      {
        name: 'Thông tin công việc',
        url: '/quan-ly-cong-viec/thong-tin-cong-viec'
      },
      {
        name: 'Phòng ban',
        url: '/quan-ly-cong-viec/phong-ban'
      },
      {
        name: 'Lich công tác',
        url: '/quan-ly-cong-viec/lich-cong-tac'
      }
    ]
  },
  {
    name: 'Quản lý thời gian',
    url: '/quan-ly-thoi-gian',
    icon: 'icon-clock',
    children: [
      {
        name: 'Thời gian làm việc',
        url: '/quan-ly-thoi-gian/thoi-gian-lam-viec'
      },
      {
        name: 'Ca làm việc',
        url: '/quan-ly-thoi-gian/ca-lam-viec'
      }
    ]
  },
  {
    name: 'Quản lý chấm công',
    icon: 'icon-check',
    children: [
      {
        name: 'Bắt đầu ca làm',
        url: '/quan-ly-cham-cong/cham-cong'
      },
      {
        name : 'Chốt ca làm',
        url : '/quan-ly-cham-cong/cham-cong-chitiet'
      },
      {
        name : 'Lịch sử',
        url : '/quan-ly-cham-cong/cham-cong-lichsu'
      },
     
      {
        name : 'Xem bảng công',
        url : '/quan-ly-cham-cong/cham-cong-dong'
      }
    ],
  },
  {
    name: 'Quản lý lương',
    url: '/quan-ly-luong',
    icon: 'icon-pie-chart',
    children: [
      {
        name: 'Tính lương',
        url: '/quan-ly-luong/tinh-luong'      },
      {
        name: 'Nâng lương',
        url: '/quan-ly-luong/nang-luong'
      }
    ]
  },
  {
    name: 'Quản lý vị trí',
    url: '/quan-ly-vị-tri',
    icon: 'icon-location-pin',
    children: [
      {
        name: 'Phường-Xã',
        url: '/quan-ly-vi-tri/phuong-xa'
      },
      {
        name: 'Quận-Huyện',
        url: '/quan-ly-vi-tri/quan-huyen'
      },
      {
        name: 'Tỉnh-Thành phố',
        url: '/quan-ly-vi-tri/tinh-thanh-pho'
      }
    ]
  }
];
